package ru.c0d1red.projecthub.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserFactory {
    private final BCryptPasswordEncoder passwordEncoder;

    public User create(String username, String rawPassword) {
        String encodedPassword = passwordEncoder.encode(rawPassword);
        return new User(username, encodedPassword);
    }
}
