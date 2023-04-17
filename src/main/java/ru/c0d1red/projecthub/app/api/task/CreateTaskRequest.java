package ru.c0d1red.projecthub.app.api.task;

import lombok.Data;
import ru.c0d1red.projecthub.domain.task.Task;

import java.time.LocalDate;

@Data
public class CreateTaskRequest {
    private Long projectId;
    private String description;
    private Integer number;
    private Task.Priority priority;
    private LocalDate dueDate;
    private String performerUsername;
}
