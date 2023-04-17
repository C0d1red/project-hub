package ru.c0d1red.projecthub.domain.user;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.c0d1red.projecthub.domain.IdentifiedDomainObject;
import ru.c0d1red.projecthub.domain.project.Project;

@Data
@Entity
@Table(name = "project_participant")
@AllArgsConstructor
@NoArgsConstructor
public class ProjectParticipant extends IdentifiedDomainObject {
    @OneToOne
    private User user;
    @OneToOne
    private Project project;
    private Role role;
}
