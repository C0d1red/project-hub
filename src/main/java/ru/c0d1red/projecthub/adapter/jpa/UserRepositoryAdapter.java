package ru.c0d1red.projecthub.adapter.jpa;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.c0d1red.projecthub.app.api.user.UserNotFoundException;
import ru.c0d1red.projecthub.app.api.user.UserRepository;
import ru.c0d1red.projecthub.domain.user.User;

@Repository
@RequiredArgsConstructor
public class UserRepositoryAdapter implements UserRepository {
    private final UserJpaRepository userJpaRepository;

    @Override
    public void save(User user) {
        userJpaRepository.save(user);
    }

    @Override
    public User getUserById(long id) {
        return userJpaRepository.findUserById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public User getUserByUsername(String username) {
        return userJpaRepository.findUserByUsername(username)
                .orElseThrow(() -> new UserNotFoundException(username));
    }

    @Override
    public boolean existsUserByUsername(String username) {
        return userJpaRepository.existsUserByUsername(username);
    }
}
