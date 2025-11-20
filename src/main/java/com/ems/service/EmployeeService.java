package com.ems.service;

import com.ems.model.Employee;
import java.util.List;

public interface EmployeeService {

    Employee save(Employee e);
    List<Employee> getAll();
    Employee update(Integer id, Employee e);
    void delete(Integer id);
}

