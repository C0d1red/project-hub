package ru.c0d1red.projecthub.adapter.rest.project.v1;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import ru.c0d1red.projecthub.adapter.rest.project.v1.dto.V1CreateProjectResponseDto;
import ru.c0d1red.projecthub.domain.project.Project;

@Component
public class V1ProjectDtoMapper {
    private final ModelMapper modelMapper;

    public V1ProjectDtoMapper() {
        this.modelMapper = new ModelMapper();
        this.modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        this.modelMapper.typeMap(Project.class, V1CreateProjectResponseDto.class)
                .addMapping(project -> project.getAuthor().getUsername(), V1CreateProjectResponseDto::setAuthorUsername);
    }

    public V1CreateProjectResponseDto mapToDto(Project project) {
        return modelMapper.map(project, V1CreateProjectResponseDto.class);
    }
}
