package ru.c0d1red.projecthub.adapter.rest.task.v1;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import ru.c0d1red.projecthub.adapter.rest.task.v1.dto.V1CreateTaskRequestDto;
import ru.c0d1red.projecthub.adapter.rest.task.v1.dto.V1TaskDto;
import ru.c0d1red.projecthub.app.api.task.CreateTaskRequest;
import ru.c0d1red.projecthub.domain.task.Task;

@Component
public class V1TaskDtoMapper {
    private final ModelMapper modelMapper;

    public V1TaskDtoMapper() {
        this.modelMapper = new ModelMapper();
        this.modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }


    public CreateTaskRequest mapToRequest(V1CreateTaskRequestDto dto) {
        return modelMapper.map(dto, CreateTaskRequest.class);
    }

    public V1TaskDto mapToDto(Task task) {
        return modelMapper.map(task, V1TaskDto.class);
    }
}
