package ru.c0d1red.projecthub.app.api.security;

public class UserAlreadyExistsException extends RuntimeException {
    private static final long serialVersionUID = 1214306116084918161L;
    private static final String USER_ALREADY_EXISTS_FORMAT_MESSAGE = "User '%s' already exists";

    public UserAlreadyExistsException(String username) {
        super(String.format(USER_ALREADY_EXISTS_FORMAT_MESSAGE, username));
    }
}
