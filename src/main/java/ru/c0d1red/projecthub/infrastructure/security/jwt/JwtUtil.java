package ru.c0d1red.projecthub.infrastructure.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import ru.c0d1red.projecthub.infrastructure.security.AuthFailedException;

import java.util.Date;

import static io.jsonwebtoken.SignatureAlgorithm.HS256;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtUtil {
    private static final String CLAIM_KEY_ID = "id";
    private static final String EMPTY_CREDENTIALS = "";
    private final JwtUserDetailsService jwtUserDetailsService;
    @Value("${jwt.expired}")
    private long tokenValidityInMilliseconds;
    @Value("${jwt.secret}")
    private String secret;

    public String createTokenFor(JwtUser jwtUser) {
        Claims claims = createClaims(jwtUser.getId(), jwtUser.getUsername());
        Date now = new Date();
        Date expiration = new Date(now.getTime() + tokenValidityInMilliseconds);
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(HS256, secret)
                .compact();
    }

    public String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

    public boolean isTokenValid(String token) {
        try {
            Jws<Claims> claims = parseClaims(token);
            return isTokenActual(claims);
        } catch (Exception e) {
            throw new AuthFailedException("JWT is invalid");
        }
    }

    public Authentication getAuthentication(String token) {
        String username = getUsername(token);
        JwtUser jwtUser = jwtUserDetailsService.loadUserByUsername(username);
        return new UsernamePasswordAuthenticationToken(jwtUser, EMPTY_CREDENTIALS, jwtUser.getAuthorities());
    }

    // ===================================================================================================================
    // = Implementation
    // ===================================================================================================================

    private Claims createClaims(long id, String username) {
        Claims claims = Jwts.claims().setSubject(username);
        claims.put(CLAIM_KEY_ID, id);
        return claims;
    }

    private boolean isTokenActual(Jws<Claims> claims) {
        Date tokenExpirationDate = claims.getBody().getExpiration();
        Date now = new Date();
        return tokenExpirationDate.after(now);
    }

    private String getUsername(String token) {
        try {
            return parseClaims(token).getBody().getSubject();
        } catch (ExpiredJwtException e) {
            log.warn("Token {} has been expired", token);
            return e.getClaims().getSubject();
        }
    }

    private Jws<Claims> parseClaims(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token);
    }
}
