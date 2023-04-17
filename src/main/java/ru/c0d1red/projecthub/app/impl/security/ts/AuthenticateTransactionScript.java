package ru.c0d1red.projecthub.app.impl.security.ts;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.c0d1red.projecthub.app.api.security.AuthenticationRequest;
import ru.c0d1red.projecthub.app.impl.user.AuthManager;

@Component
@RequiredArgsConstructor
public class AuthenticateTransactionScript {
    private final AuthManager authManager;

    @Transactional
    public String execute(AuthenticationRequest request) {
        String username = request.getUsername();
        String rawPassword = request.getRawPassword();
        return authManager.authenticateAndCreateToken(username, rawPassword);
    }
}
