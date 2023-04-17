package ru.c0d1red.projecthub.app.api.project;

import ru.c0d1red.projecthub.domain.project.Project;

public interface ProjectRepository {
    void save(Project project);

    Project getProjectById(long id);
}
