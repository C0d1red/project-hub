package ru.c0d1red.projecthub.app.impl.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import ru.c0d1red.projecthub.app.api.security.AnonymousUserException;
import ru.c0d1red.projecthub.app.api.user.UserRepository;
import ru.c0d1red.projecthub.domain.user.User;
import ru.c0d1red.projecthub.infrastructure.security.jwt.JwtUser;
import ru.c0d1red.projecthub.infrastructure.security.jwt.JwtUtil;

@Component
@RequiredArgsConstructor
public class AuthManager {
    private static final String ANONYMOUS_USER_PRINCIPAL = "anonymousUser";
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    public String authenticateAndCreateToken(String username, String password) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        JwtUser authenticatedUser = (JwtUser) authentication.getPrincipal();
        return jwtUtil.createTokenFor(authenticatedUser);
    }

    public String refreshToken(String oldToken) {
        JwtUser tokenUser = (JwtUser) jwtUtil.getAuthentication(oldToken).getPrincipal();
        return jwtUtil.createTokenFor(tokenUser);
    }

    public User getAuthenticatedUser() {
        long userId = getIdForAuthenticatedUser();
        return userRepository.getUserById(userId);
    }

    // ===================================================================================================================
    // = Implementation
    // ===================================================================================================================

    private long getIdForAuthenticatedUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (ANONYMOUS_USER_PRINCIPAL.equals(principal)) {
            throw new AnonymousUserException();
        }
        JwtUser authenticatedUser = (JwtUser) principal;
        return authenticatedUser.getId();
    }
}
