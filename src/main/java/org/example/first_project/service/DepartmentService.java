package org.example.first_project.service;

import org.example.first_project.model.dto.DepartmentDto;
import org.example.first_project.model.entity.Department;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public interface DepartmentService {
    DepartmentDto saveDepartment(DepartmentDto department);
    DepartmentDto updateDepartment(DepartmentDto department);
    DepartmentDto getDepartmentById(Long id);
    List<Department> getDepartments();
    boolean deleteDepartmentById(Long id);
}
