package ru.c0d1red.projecthub.app.impl.task;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.c0d1red.projecthub.app.api.project.ProjectRepository;
import ru.c0d1red.projecthub.app.api.task.CreateTaskRequest;
import ru.c0d1red.projecthub.app.api.user.UserRepository;
import ru.c0d1red.projecthub.app.impl.user.AuthManager;
import ru.c0d1red.projecthub.domain.project.Project;
import ru.c0d1red.projecthub.domain.task.Task;
import ru.c0d1red.projecthub.domain.task.TaskFactory;
import ru.c0d1red.projecthub.domain.user.User;

@Component
@RequiredArgsConstructor
public class CreateTaskTransactionalScript {
    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;
    private final AuthManager authManager;
    private final TaskFactory taskFactory;

    @Transactional
    public Task execute(CreateTaskRequest request) {
        User taskAuthor = authManager.getAuthenticatedUser();
        Project project = projectRepository.getProjectById(request.getProjectId());
        User taskPerformer = userRepository.getUserByUsername(request.getPerformerUsername());

        Task task = taskFactory.create(request);
        project.addTask(task);
        return task;
    }
}
