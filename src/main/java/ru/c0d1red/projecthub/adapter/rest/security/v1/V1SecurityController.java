package ru.c0d1red.projecthub.adapter.rest.security.v1;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.c0d1red.projecthub.adapter.rest.security.v1.dto.AuthenticationRequestDto;
import ru.c0d1red.projecthub.adapter.rest.security.v1.dto.TokenDto;
import ru.c0d1red.projecthub.app.api.security.AuthenticationRequest;
import ru.c0d1red.projecthub.app.api.security.SecurityService;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class V1SecurityController {
    private final V1SecurityDtoMapper securityMapper;
    private final SecurityService securityService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public TokenDto register(@RequestBody AuthenticationRequestDto dto) {
        log.info("Request to register new user '{}'", dto.getUsername());
        AuthenticationRequest request = securityMapper.mapRequestFrom(dto);
        String token = securityService.register(request);
        return securityMapper.mapTokenDtoFrom(token);
    }

    @PostMapping("/authenticate")
    @ResponseStatus(HttpStatus.OK)
    public TokenDto authenticate(@RequestBody AuthenticationRequestDto dto) {
        log.info("Request to authenticate user '{}'", dto.getUsername());
        AuthenticationRequest request = securityMapper.mapRequestFrom(dto);
        String token = securityService.authenticate(request);
        return securityMapper.mapTokenDtoFrom(token);
    }

    @PostMapping("/token/refresh")
    @ResponseStatus(HttpStatus.OK)
    public TokenDto refreshToken(@RequestBody TokenDto dto) {
        log.info("Request to refresh token [{}]", dto.getToken());
        String newToken = securityService.refreshToken(dto.getToken());
        return securityMapper.mapTokenDtoFrom(newToken);
    }
}
