package ru.c0d1red.projecthub.infrastructure.security.jwt;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.c0d1red.projecthub.app.api.user.UserRepository;
import ru.c0d1red.projecthub.domain.user.User;

@Service
@RequiredArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public JwtUser loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getUserByUsername(username);
        return createFrom(user);
    }

    // ===================================================================================================================
    // = Implementation
    // ===================================================================================================================

    private JwtUser createFrom(User user) {
        long userId = user.getId();
        String username = user.getUsername();
        String encryptedPassword = user.getPassword();
        return new JwtUser(userId, username, encryptedPassword);
    }
}
