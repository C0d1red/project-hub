package ru.c0d1red.projecthub.infrastructure.security.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
import ru.c0d1red.projecthub.infrastructure.security.AuthFailedException;

import java.io.IOException;

import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.security.core.context.SecurityContextHolder.getContext;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtFilter extends GenericFilterBean {
    private final JwtUtil jwtUtil;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            authenticate((HttpServletRequest) servletRequest);
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (AuthFailedException e) {
            sendForbiddenError((HttpServletResponse) servletResponse);
            log.error("JWT forbidden error has been send");
        }
    }

    // ===================================================================================================================
    // = Implementation
    // ===================================================================================================================

    private void authenticate(HttpServletRequest httpServletRequest) {
        String token = jwtUtil.resolveToken(httpServletRequest);
        if (token != null && jwtUtil.isTokenValid(token)) {
            Authentication authentication = jwtUtil.getAuthentication(token);
            getContext().setAuthentication(authentication);
        }
    }

    private void sendForbiddenError(HttpServletResponse httpServletResponse) throws IOException {
        httpServletResponse.sendError(FORBIDDEN.value());
    }
}
