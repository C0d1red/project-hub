package ru.c0d1red.projecthub.app.impl.security.ts;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.c0d1red.projecthub.app.api.security.AuthenticationRequest;
import ru.c0d1red.projecthub.app.api.security.UserAlreadyExistsException;
import ru.c0d1red.projecthub.app.api.user.UserRepository;
import ru.c0d1red.projecthub.app.impl.user.AuthManager;
import ru.c0d1red.projecthub.domain.user.User;
import ru.c0d1red.projecthub.domain.user.UserFactory;

@Component
@RequiredArgsConstructor
public class RegisterTransactionScript {
    private final UserRepository userRepository;
    private final UserFactory userFactory;
    private final AuthManager authManager;

    @Transactional
    public String execute(AuthenticationRequest request) {
        String username = request.getUsername();
        String rawPassword = request.getRawPassword();
        validateUsername(username);
        saveUser(username, rawPassword);
        return authManager.authenticateAndCreateToken(username, rawPassword);
    }

    // ===================================================================================================================
    // = Implementation
    // ===================================================================================================================

    private void validateUsername(String username) {
        if (userRepository.existsUserByUsername(username)) {
            throw new UserAlreadyExistsException(username);
        }
    }

    private void saveUser(String username, String rawPassword) {
        User user = userFactory.create(username, rawPassword);
        userRepository.save(user);
    }
}
