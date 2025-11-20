package com.ems.controller;

import com.ems.model.Employee;
import com.ems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping
    public Employee add(@RequestBody Employee e) {
        return service.save(e);
    }

    @GetMapping
    public List<Employee> all() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable Integer id, @RequestBody Employee e) {
        return service.update(id, e);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}

