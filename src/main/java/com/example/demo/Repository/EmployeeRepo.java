package com.example.demo.Repository;

import com.example.demo.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.*;

public interface EmployeeRepo {
    List<Employee> findAll();
    Optional<Employee> findById(int id);
    int save(Employee emp);
    int update(Employee emp);
    int delete(int id);
}