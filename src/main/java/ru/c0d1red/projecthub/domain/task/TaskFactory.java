package ru.c0d1red.projecthub.domain.task;

import org.springframework.stereotype.Component;
import ru.c0d1red.projecthub.app.api.task.CreateTaskRequest;

@Component
public class TaskFactory {
    public Task create(CreateTaskRequest request) {
        return new Task();
    }
}
