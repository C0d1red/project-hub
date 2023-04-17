package ru.c0d1red.projecthub.adapter.jpa;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.c0d1red.projecthub.app.api.project.ProjectRepository;
import ru.c0d1red.projecthub.domain.project.Project;

@Repository
@RequiredArgsConstructor
public class ProjectJpaRepositoryAdapter implements ProjectRepository {
    private final ProjectJpaRepository jpaRepository;

    @Override
    public void save(Project project) {
        jpaRepository.save(project);
    }

    @Override
    public Project getProjectById(long id) {
        return jpaRepository.findById(id).orElseThrow();
    }
}
