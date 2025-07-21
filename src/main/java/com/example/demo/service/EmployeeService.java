package com.example.demo.service;


import com.example.demo.Repository.EmployeeRepo;
import com.example.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    public Optional<Employee> getById(int id) {
        return employeeRepo.findById(id);
    }

    public String create(Employee emp) {
        employeeRepo.save(emp);
        return "Employee saved";
    }

    public String update(Employee emp) {
        employeeRepo.update(emp);
        return "Employee updated";
    }

    public String delete(int id) {
        employeeRepo.delete(id);
        return "Employee deleted";
    }
}
