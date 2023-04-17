package ru.c0d1red.projecthub.app.api.security;

public class AnonymousUserException extends RuntimeException {
    private static final long serialVersionUID = -8188933692156027614L;
    private static final String ANONYMOUS_USER_MESSAGE = "User is anonymous";

    public AnonymousUserException() {
        super(ANONYMOUS_USER_MESSAGE);
    }
}
