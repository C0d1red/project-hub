package ru.c0d1red.projecthub.app.impl.security;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.c0d1red.projecthub.app.api.security.AuthenticationRequest;
import ru.c0d1red.projecthub.app.api.security.SecurityService;
import ru.c0d1red.projecthub.app.impl.security.ts.AuthenticateTransactionScript;
import ru.c0d1red.projecthub.app.impl.security.ts.RefreshTokenTransactionScript;
import ru.c0d1red.projecthub.app.impl.security.ts.RegisterTransactionScript;

@Service
@RequiredArgsConstructor
public class SecurityServiceImpl implements SecurityService {
    private final RegisterTransactionScript register;
    private final AuthenticateTransactionScript authenticate;
    private final RefreshTokenTransactionScript refreshToken;

    @Override
    public String register(AuthenticationRequest request) {
        return register.execute(request);
    }

    @Override
    public String authenticate(AuthenticationRequest request) {
        return authenticate.execute(request);
    }

    @Override
    public String refreshToken(String token) {
        return refreshToken.execute(token);
    }

}
