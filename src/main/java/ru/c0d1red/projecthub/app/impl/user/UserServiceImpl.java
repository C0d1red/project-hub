package ru.c0d1red.projecthub.app.impl.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.c0d1red.projecthub.app.api.user.FindUserRequest;
import ru.c0d1red.projecthub.app.api.user.UserService;
import ru.c0d1red.projecthub.app.impl.user.ts.FindUserTransactionScript;
import ru.c0d1red.projecthub.domain.user.User;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final FindUserTransactionScript findUser;

    @Override
    public User findUser(FindUserRequest request) {
        return findUser.execute(request);
    }
}
