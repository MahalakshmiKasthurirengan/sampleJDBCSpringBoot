package com.example.demo.controller;


import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/emp/all")
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/emp/id/{empId}")
    public Optional<Employee> getEmpById(@PathVariable Integer empId) {
        return employeeService.getById(empId);
    }

    @PostMapping("/emp/create")
    public String createEmp(@RequestBody Employee employee) {
        return employeeService.create(employee);
    }

    @PutMapping("/emp/update/{empId}")
    public String updateEmpById(@PathVariable Integer empId, @RequestBody Employee employee) {
        return employeeService.update(employee);
    }

    @DeleteMapping("/emp/delete/{empId}")
    public String deleteEmp(@PathVariable Integer empId) {
        return employeeService.delete(empId);
    }
}
