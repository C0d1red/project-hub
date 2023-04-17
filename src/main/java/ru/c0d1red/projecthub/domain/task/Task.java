package ru.c0d1red.projecthub.domain.task;

import jakarta.persistence.*;
import lombok.Data;
import ru.c0d1red.projecthub.domain.IdentifiedDomainObject;
import ru.c0d1red.projecthub.domain.user.User;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "task")
public class Task extends IdentifiedDomainObject {
    private LocalDate creationDate;
    private String description;
    private Integer number;
    @Enumerated(EnumType.STRING)
    private Priority priority;
    private LocalDate dueDate;
    @ManyToOne
    private User author;
    @ManyToOne
    private User performer;

    public enum Priority {
        HIGH, MIDDLE, LOW
    }
}
