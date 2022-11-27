package com.shuozeli.hcm.controllers;

import com.shuozeli.hcm.data.Employee;
import com.shuozeli.hcm.respositories.EmployeeRepository;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/employees")
public final class EmployeeController {
    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/{employeeId}")
    Mono<Employee> getEmployees(
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

    @GetMapping("/")
    Flux<Employee> listEmployees() {
        return employeeRepository.findAll();
    }

    @PostMapping("/")
    Mono<Employee> createEmployees(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }
}
