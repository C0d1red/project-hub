package ru.c0d1red.projecthub.infrastructure.security;

import java.io.Serial;

public class AuthFailedException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 744663907048740802L;

    public AuthFailedException(String message) {
        super(message);
    }

}
