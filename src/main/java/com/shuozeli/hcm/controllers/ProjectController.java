package com.shuozeli.hcm.controllers;

import com.shuozeli.hcm.data.Project;
import com.shuozeli.hcm.respositories.ProjectRepository;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/projects")
public final class ProjectController {
    private final ProjectRepository projectRepository;

    public ProjectController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @PostMapping
    Mono<Project> createProject(@RequestBody Project project) {
        return projectRepository.save(project);
    }

    @GetMapping
    Flux<Project> listProjects() {
        return projectRepository.findAll();
    }

    @GetMapping("/{projectId}")
    Mono<Project> findProjectById(@PathVariable int projectId) {
        return projectRepository.existsById(projectId).flatMap(
                found -> {
                    if (found) {
                        return projectRepository.findById(projectId);
                    }
                    return Mono.error(new ResourceNotFoundException());
                }
        );
    }

    @DeleteMapping("/{projectId}")
    Mono<Void> deleteProjectById(@PathVariable int projectId) {
        return projectRepository.existsById(projectId).flatMap(
                found -> {
                    if (found) {
                        return projectRepository.deleteById(projectId);
                    }
                    return Mono.error(new ResourceNotFoundException());
                }
        );
    }

    @PutMapping("/{projectId}")
    Mono<Project> updateProject(@RequestBody Project projectFromRequest, @PathVariable int projectId) {
        return projectRepository
                .findById(projectId)
                .flatMap(project -> {
                    Project projectUpdated = new Project(
                            projectId,
                            projectFromRequest.name() == null ? project.name() : projectFromRequest.name(),
                            projectFromRequest.description() == null ? project.description() : projectFromRequest.description()
                    );
                    return projectRepository.save(projectUpdated);
                });
    }
}
