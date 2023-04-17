package ru.c0d1red.projecthub.adapter.rest.security.v1;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import ru.c0d1red.projecthub.adapter.rest.security.v1.dto.AuthenticationRequestDto;
import ru.c0d1red.projecthub.adapter.rest.security.v1.dto.TokenDto;
import ru.c0d1red.projecthub.app.api.security.AuthenticationRequest;

@Component
public class V1SecurityDtoMapper {
    private final ModelMapper modelMapper;

    public V1SecurityDtoMapper() {
        this.modelMapper = new ModelMapper();
        this.modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        this.modelMapper.typeMap(AuthenticationRequestDto.class, AuthenticationRequest.class)
                .addMapping(AuthenticationRequestDto::getPassword, AuthenticationRequest::setRawPassword);
    }

    public AuthenticationRequest mapRequestFrom(AuthenticationRequestDto dto) {
        return modelMapper.map(dto, AuthenticationRequest.class);
    }

    public TokenDto mapTokenDtoFrom(String token) {
        return new TokenDto(token);
    }
}
