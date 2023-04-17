package ru.c0d1red.projecthub.domain.user;

import org.springframework.stereotype.Component;
import ru.c0d1red.projecthub.domain.project.Project;

@Component
public class ProjectParticipantFactory {
    public ProjectParticipant create(User user, Project project, Role role) {
        return new ProjectParticipant(user, project, role);
    }
}
