package ru.c0d1red.projecthub.app.impl.task;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.c0d1red.projecthub.app.api.task.CreateTaskRequest;
import ru.c0d1red.projecthub.app.api.task.TaskService;
import ru.c0d1red.projecthub.domain.task.Task;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final CreateTaskTransactionalScript createTask;

    @Override
    public Task createTask(CreateTaskRequest request) {
        return createTask.execute(request);
    }
}
