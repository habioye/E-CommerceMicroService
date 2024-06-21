package com.example.employee_service.repository;

import com.example.employee_service.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {

    public ArrayList<Employee> repo = new ArrayList<>();

    public Employee save(Employee employee) {
        if (repo.add(employee))
            return employee;
        return null;
    }

    public List<Employee> getAll() {
        return repo;
    }

}
