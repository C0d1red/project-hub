package ru.c0d1red.projecthub.adapter.rest.task.v1;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.c0d1red.projecthub.adapter.rest.task.v1.dto.V1CreateTaskRequestDto;
import ru.c0d1red.projecthub.adapter.rest.task.v1.dto.V1TaskDto;
import ru.c0d1red.projecthub.app.api.task.CreateTaskRequest;
import ru.c0d1red.projecthub.app.api.task.TaskService;
import ru.c0d1red.projecthub.domain.task.Task;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/task")
public class V1TaskController {
    private final V1TaskDtoMapper taskDtoMapper;
    private final TaskService taskService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public V1TaskDto register(@RequestBody V1CreateTaskRequestDto requestDto) {
        log.info("Create task request '{}'", requestDto);
        CreateTaskRequest request = taskDtoMapper.mapToRequest(requestDto);
        Task task = taskService.createTask(request);
        return taskDtoMapper.mapToDto(task);
    }
}
