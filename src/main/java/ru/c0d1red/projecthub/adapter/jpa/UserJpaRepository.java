package ru.c0d1red.projecthub.adapter.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.c0d1red.projecthub.domain.user.User;

import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<User, Long> {
    Optional<User> findUserById(long id);

    Optional<User> findUserByUsername(String username);

    boolean existsUserByUsername(String username);
}
