package ru.c0d1red.projecthub.app.impl.user.ts;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.c0d1red.projecthub.app.api.user.FindUserRequest;
import ru.c0d1red.projecthub.app.api.user.UserRepository;
import ru.c0d1red.projecthub.domain.user.User;

@Component
@RequiredArgsConstructor
public class FindUserTransactionScript {
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public User execute(FindUserRequest request) {
        return userRepository.getUserByUsername(request.getUsername());
    }
}
