package ru.c0d1red.projecthub.adapter.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.c0d1red.projecthub.domain.project.Project;

public interface ProjectJpaRepository extends JpaRepository<Project, Long> {
}
