package ru.c0d1red.projecthub.adapter.rest.project.v1;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.c0d1red.projecthub.adapter.rest.project.v1.dto.V1CreateProjectRequestDto;
import ru.c0d1red.projecthub.adapter.rest.project.v1.dto.V1CreateProjectResponseDto;
import ru.c0d1red.projecthub.app.api.project.ProjectService;
import ru.c0d1red.projecthub.domain.project.Project;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/project")
public class V1ProjectController {
    private final V1ProjectDtoMapper projectDtoMapper;
    private final ProjectService projectService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(security = {@SecurityRequirement(name = "bearer-key")})
    public V1CreateProjectResponseDto create(@RequestBody V1CreateProjectRequestDto dto) {
        log.info("Request to create new project '{}'", dto.getTitle());
        Project project = projectService.createProject(dto.getTitle());
        return projectDtoMapper.mapToDto(project);
    }
}
