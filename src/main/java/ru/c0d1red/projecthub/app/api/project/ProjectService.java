package ru.c0d1red.projecthub.app.api.project;

import ru.c0d1red.projecthub.domain.project.Project;

public interface ProjectService {
    Project createProject(String title);

    void addParticipantToProject(AddEmployeeToProjectRequest request);
}
