package com.shuozeli.hcm.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("projects")
public record Project(@Id int projectId, String name, String description) {
}
