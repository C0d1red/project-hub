package ru.c0d1red.projecthub.domain.project;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.c0d1red.projecthub.domain.IdentifiedDomainObject;
import ru.c0d1red.projecthub.domain.task.Task;
import ru.c0d1red.projecthub.domain.user.ProjectParticipant;
import ru.c0d1red.projecthub.domain.user.User;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "project")
@AllArgsConstructor
@NoArgsConstructor
public class Project extends IdentifiedDomainObject {
    private String title;
    private LocalDate creationDate;
    @ManyToOne
    private User author;
    @OneToMany(orphanRemoval = true)
    private List<Task> tasks;
    @OneToMany(orphanRemoval = true)
    private List<ProjectParticipant> participants;

    public void addTask(Task newTask) {
        tasks.add(newTask);
    }

    public void addParticipant(ProjectParticipant newParticipant) {
        participants.add(newParticipant);
    }
}
