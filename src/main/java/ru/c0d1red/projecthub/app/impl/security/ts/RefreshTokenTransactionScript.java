package ru.c0d1red.projecthub.app.impl.security.ts;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.c0d1red.projecthub.app.impl.user.AuthManager;

@Component
@RequiredArgsConstructor
public class RefreshTokenTransactionScript {
    private final AuthManager authManager;

    @Transactional
    public String execute(String token) {
        return authManager.refreshToken(token);
    }
}
