package com.ems.service;

import com.ems.model.Employee;
import com.ems.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repo;

    @Override
    public Employee save(Employee e) {
        return repo.save(e);
    }

    @Override
    public List<Employee> getAll() {
        return repo.findAll();
    }

    @Override
    public Employee update(Integer id, Employee e) {
        Employee old = repo.findById(id).orElse(null);

        if (old == null) {
            return null;
        }

        old.setName(e.getName());
        old.setDepartment(e.getDepartment());
        old.setSalary(e.getSalary());
        old.setEmail(e.getEmail());

        return repo.save(old);
    }

    @Override
    public void delete(Integer id) {
        repo.deleteById(id);
    }
}

