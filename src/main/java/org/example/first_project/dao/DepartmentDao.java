package org.example.first_project.dao;


import lombok.RequiredArgsConstructor;
import org.example.first_project.model.dto.DepartmentDto;
import org.example.first_project.model.entity.Department;
import org.example.first_project.repository.DepartmentRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentDao {
    private final DepartmentRepo departmentRepo;

    public List<Department> getdepartment() {
        return departmentRepo.findAll();

    }
    public Department getDepartmentById(Long id){
       Optional<Department> department=departmentRepo.findById(id);
        return department.orElseGet(Department::new);
    }

    public Department createDepartment(Department department) {
        return departmentRepo.save(department);
    }

}
