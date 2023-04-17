package ru.c0d1red.projecthub.adapter.rest.user.v1;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import ru.c0d1red.projecthub.adapter.rest.user.v1.dto.V1UserDto;
import ru.c0d1red.projecthub.app.api.user.FindUserRequest;
import ru.c0d1red.projecthub.domain.user.User;

@Component
public class V1UserDtoMapper {
    private final ModelMapper modelMapper;

    public V1UserDtoMapper() {
        this.modelMapper = new ModelMapper();
        this.modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    public V1UserDto mapToDto(User user) {
        return modelMapper.map(user, V1UserDto.class);
    }

    public FindUserRequest mapUsernameToFindRequest(String username) {
        return new FindUserRequest(username);
    }
}
