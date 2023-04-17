package ru.c0d1red.projecthub.app.api.user;

import ru.c0d1red.projecthub.domain.user.User;

public interface UserService {
    User findUser(FindUserRequest request);
}
