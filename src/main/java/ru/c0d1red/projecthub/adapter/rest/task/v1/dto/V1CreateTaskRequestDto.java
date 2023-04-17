package ru.c0d1red.projecthub.adapter.rest.task.v1.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class V1CreateTaskRequestDto {
    private Long projectId;
    private String description;
    private Integer number;
    private String priority;
    private LocalDate dueDate;
    private String performerUsername;
}
