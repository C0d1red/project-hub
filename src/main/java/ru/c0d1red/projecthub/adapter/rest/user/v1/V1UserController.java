package ru.c0d1red.projecthub.adapter.rest.user.v1;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.c0d1red.projecthub.adapter.rest.user.v1.dto.V1UserDto;
import ru.c0d1red.projecthub.app.api.user.FindUserRequest;
import ru.c0d1red.projecthub.app.api.user.UserService;
import ru.c0d1red.projecthub.domain.user.User;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class V1UserController {
    private final V1UserDtoMapper userDtoMapper;
    private final UserService userService;

    @GetMapping("/{username}")
    @ResponseStatus(HttpStatus.CREATED)
    public V1UserDto findUser(@PathVariable String username) {
        log.info("Request to get user '{}'", username);
        FindUserRequest request = userDtoMapper.mapUsernameToFindRequest(username);
        User user = userService.findUser(request);
        return userDtoMapper.mapToDto(user);
    }
}
