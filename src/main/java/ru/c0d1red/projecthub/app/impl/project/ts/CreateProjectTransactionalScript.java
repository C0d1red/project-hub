package ru.c0d1red.projecthub.app.impl.project.ts;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.c0d1red.projecthub.app.api.project.ProjectRepository;
import ru.c0d1red.projecthub.app.impl.user.AuthManager;
import ru.c0d1red.projecthub.domain.project.Project;
import ru.c0d1red.projecthub.domain.project.ProjectFactory;
import ru.c0d1red.projecthub.domain.user.User;

@Component
@RequiredArgsConstructor
public class CreateProjectTransactionalScript {
    private final AuthManager authManager;
    private final ProjectFactory projectFactory;
    private final ProjectRepository projectRepository;

    @Transactional
    public Project execute(String title) {
        User authenticatedUser = authManager.getAuthenticatedUser();
        Project project = projectFactory.create(title, authenticatedUser);
        projectRepository.save(project);
        return project;
    }
}
