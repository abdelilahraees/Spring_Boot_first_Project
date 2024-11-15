package org.example.first_project.dao;


import lombok.RequiredArgsConstructor;
import org.example.first_project.model.entity.Employee;
import org.example.first_project.repository.EmployeeRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeDao {
  private final EmployeeRepo employeeRepo;

  public Optional<Employee> getEmployeeById(Long id){
      return employeeRepo.findById(id);
  }

  public List<Employee> getEmployees(){
      return  employeeRepo.findAll();
  }

  public Employee createEmployee(Employee employee){
      return  employeeRepo.save(employee);

  }

    public Employee updateEmployee(Employee employee) {
        return employeeRepo.saveAndFlush(employee);

    }
    public boolean deleteDepartmentById(Long id) {
        if (employeeRepo.existsById(id)) {
            try {
                employeeRepo.deleteById(id);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }



}
