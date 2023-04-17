package ru.c0d1red.projecthub.app.impl.project.ts;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.c0d1red.projecthub.app.api.project.AddEmployeeToProjectRequest;
import ru.c0d1red.projecthub.app.api.project.ProjectRepository;
import ru.c0d1red.projecthub.app.api.user.UserRepository;
import ru.c0d1red.projecthub.domain.project.Project;
import ru.c0d1red.projecthub.domain.user.ProjectParticipant;
import ru.c0d1red.projecthub.domain.user.ProjectParticipantFactory;
import ru.c0d1red.projecthub.domain.user.User;

@Component
@RequiredArgsConstructor
public class AddParticipantToProjectTransactionalScript {
    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;
    private final ProjectParticipantFactory projectParticipantFactory;

    @Transactional
    public void execute(AddEmployeeToProjectRequest request) {
        User participantUser = userRepository.getUserByUsername(request.getEmployeeUsername());
        Project project = projectRepository.getProjectById(request.getProjectId());
        ProjectParticipant projectParticipant = projectParticipantFactory.create(participantUser, project, request.getRole());
        project.addParticipant(projectParticipant);
    }
}
