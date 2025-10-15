package com.example.employee_search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository repository;

    @GetMapping("/search")
    public ResponseEntity<?> searchByName(@RequestParam String name) {
        List<Employee> employees = repository.findByNameIgnoreCase(name);
        if (employees.isEmpty()) {
            return ResponseEntity.status(404).body("No employee found");
        }
        return ResponseEntity.ok(employees);
    }
}
