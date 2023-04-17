package ru.c0d1red.projecthub.adapter.rest.project.v1.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class V1CreateProjectResponseDto {
    private String title;
    private LocalDate creationDate;
    private String authorUsername;
}
