package org.example.first_project.controller;

import lombok.RequiredArgsConstructor;
import org.example.first_project.model.dto.EmployeeDtoReq;
import org.example.first_project.model.dto.EmployeeDtoRes;
import org.example.first_project.model.entity.Employee;
import org.example.first_project.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("/get-employees")
    public List<Employee> getEmployees() {
        List<Employee> employees = employeeService.getEmployees();
        System.out.println(employees.getFirst().getDepartment().getName());
        return employees;
    }

    @GetMapping("/get-employee/{id}")
    public EmployeeDtoRes getEmployees(@PathVariable long id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/create-employee")
    public EmployeeDtoRes createEmployee(@RequestBody EmployeeDtoReq req) {
        return employeeService.createEmployee(req);
    }

    @PutMapping("/update-employee")
    public EmployeeDtoRes updateEmployee(@RequestBody EmployeeDtoReq req) {
        return employeeService.updateEmployee(req);
    }

    @DeleteMapping("/delete-employee/{id}")

    public boolean deleteEmployee(@PathVariable long id){
        return employeeService.deleteEmployeeById(id);
    }

}
