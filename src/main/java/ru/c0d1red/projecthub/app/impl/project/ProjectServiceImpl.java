package ru.c0d1red.projecthub.app.impl.project;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.c0d1red.projecthub.app.api.project.AddEmployeeToProjectRequest;
import ru.c0d1red.projecthub.app.api.project.ProjectService;
import ru.c0d1red.projecthub.app.impl.project.ts.AddParticipantToProjectTransactionalScript;
import ru.c0d1red.projecthub.app.impl.project.ts.CreateProjectTransactionalScript;
import ru.c0d1red.projecthub.domain.project.Project;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    private final CreateProjectTransactionalScript createProject;
    private final AddParticipantToProjectTransactionalScript addParticipantToProject;

    @Override
    public Project createProject(String title) {
        return createProject.execute(title);
    }

    @Override
    public void addParticipantToProject(AddEmployeeToProjectRequest request) {
        addParticipantToProject.execute(request);
    }
}
