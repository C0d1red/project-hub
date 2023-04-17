package ru.c0d1red.projecthub.app.api.user;

import ru.c0d1red.projecthub.domain.user.User;

public interface UserRepository {
    void save(User user);

    User getUserById(long id);

    User getUserByUsername(String username);

    boolean existsUserByUsername(String username);
}
