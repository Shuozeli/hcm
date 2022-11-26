package com.shuozeli.hcm.controllers;

import com.shuozeli.hcm.data.Employee;
import com.shuozeli.hcm.respositories.EmployeeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/employees")
public final class EmployeeController {
    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/{employeeId}")
    Mono<Employee> listBookmarks(
            @PathVariable int employeeId
    ) {
        return employeeRepository.existsById(employeeId)
                .flatMap(found -> {
                    if (found) {
                        return employeeRepository.findById(employeeId);
                    } else {
                        return Mono.error(new ResourceNotFoundException());
                    }
                });
    }
}
