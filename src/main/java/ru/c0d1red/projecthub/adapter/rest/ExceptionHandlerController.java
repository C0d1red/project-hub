package ru.c0d1red.projecthub.adapter.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.c0d1red.projecthub.app.api.security.AnonymousUserException;
import ru.c0d1red.projecthub.app.api.security.UserAlreadyExistsException;
import ru.c0d1red.projecthub.app.api.user.UserNotFoundException;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class ExceptionHandlerController {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({UserNotFoundException.class})
    public String notFoundHandler(RuntimeException exception) {
        log.info("Not found exception handled with message: {}", exception.getMessage());
        return exception.getMessage();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({AnonymousUserException.class})
    public String anonymousUserHandler(RuntimeException exception) {
        log.info("Anonymous user exception handled with message: {}", exception.getMessage());
        return exception.getMessage();
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler({UserAlreadyExistsException.class})
    public String userRegistrationHandler(RuntimeException exception) {
        log.info("User registration exception handled with message: {}", exception.getMessage());
        return exception.getMessage();
    }
}
