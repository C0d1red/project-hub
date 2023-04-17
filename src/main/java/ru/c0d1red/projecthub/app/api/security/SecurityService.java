package ru.c0d1red.projecthub.app.api.security;

public interface SecurityService {
    String register(AuthenticationRequest request);

    String authenticate(AuthenticationRequest request);

    String refreshToken(String token);
}
