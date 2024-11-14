package org.example.first_project.service;

import org.example.first_project.model.dto.EmployeeDtoReq;
import org.example.first_project.model.dto.EmployeeDtoRes;
import org.example.first_project.model.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface EmployeeService {


    public List<Employee> getEmployees();

    public EmployeeDtoRes getEmployeeById(Long id);

    public EmployeeDtoReq createEmployee(EmployeeDtoReq employeeDtoReq);


}
