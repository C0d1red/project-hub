package ru.c0d1red.projecthub.app.api.user;

public class UserNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 7674645796250191642L;
    private static final String USER_NOT_FOUND_BY_ID_FORMAT_MESSAGE = "User #%s not found";
    private static final String USER_NOT_FOUND_BY_USERNAME_FORMAT_MESSAGE = "User '%s' not found";

    public UserNotFoundException(long id) {
        super(String.format(USER_NOT_FOUND_BY_ID_FORMAT_MESSAGE, id));
    }

    public UserNotFoundException(String username) {
        super(String.format(USER_NOT_FOUND_BY_USERNAME_FORMAT_MESSAGE, username));
    }
}
