package com.shuozeli.hcm.respositories;

import com.shuozeli.hcm.data.Project;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ProjectRepository extends ReactiveCrudRepository<Project, Integer> {
}
