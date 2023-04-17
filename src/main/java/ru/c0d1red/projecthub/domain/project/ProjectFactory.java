package ru.c0d1red.projecthub.domain.project;

import org.springframework.stereotype.Component;
import ru.c0d1red.projecthub.domain.user.User;

import java.time.LocalDate;
import java.util.List;

@Component
public class ProjectFactory {
    public Project create(String title, User author) {
        return new Project(title, LocalDate.now(), author, List.of(), List.of());
    }
}
