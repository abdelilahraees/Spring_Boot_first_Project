package org.example.first_project.service;

import org.example.first_project.model.dto.DepartmentDtoReq;
import org.example.first_project.model.dto.DepartmentDtoRes;
import org.example.first_project.model.entity.Department;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface DepartmentService {
    DepartmentDtoRes saveDepartment(DepartmentDtoReq department);
    DepartmentDtoRes updateDepartment(DepartmentDtoReq department);
    Optional<DepartmentDtoRes> getDepartmentById(long id);
    List<Department> getDepartments();
    boolean isExistById(Long id);

    boolean deleteDepartmentById(Long id);

}
