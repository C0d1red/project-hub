package ru.c0d1red.projecthub.app.api.project;

import lombok.Data;
import ru.c0d1red.projecthub.domain.user.Role;

@Data
public class AddEmployeeToProjectRequest {
    private String employeeUsername;
    private Long projectId;
    private Role role;
}
