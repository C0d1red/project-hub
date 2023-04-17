package ru.c0d1red.projecthub.app.api.task;

import ru.c0d1red.projecthub.domain.task.Task;

public interface TaskService {
    Task createTask(CreateTaskRequest request);
}
