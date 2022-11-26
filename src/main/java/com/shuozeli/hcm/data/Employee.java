package com.shuozeli.hcm.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("employees")
public record Employee(@Id int employeeId, String name) {
}
