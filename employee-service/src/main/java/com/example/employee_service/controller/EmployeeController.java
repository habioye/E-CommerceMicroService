package com.example.employee_service.controller;

import com.example.employee_service.entity.Employee;
import com.example.employee_service.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeRepository repo;

    @GetMapping("/hello")
    public String root() {
        return "Hello world!";
    }

    @PostMapping("")
    public Employee addEmployee(@RequestBody Employee employee) {
        return repo.save(employee);
    }

    @GetMapping("")
    public ArrayList<Employee> getAll() {
        return (ArrayList<Employee>) repo.getAll();
    }

}
