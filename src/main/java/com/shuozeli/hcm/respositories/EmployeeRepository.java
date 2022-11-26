package com.shuozeli.hcm.respositories;

import com.shuozeli.hcm.data.Employee;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface EmployeeRepository extends ReactiveCrudRepository<Employee, Integer> {
}
