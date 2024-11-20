package org.example.first_project.dao;


import lombok.RequiredArgsConstructor;
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

    public Optional<Department> getDepartmentById(Long id) {
        return departmentRepo.findById(id);
    }

    public Department createDepartment(Department department) {
        return departmentRepo.save(department);
    }

    public Department updateDepartment(Department department) {
        return departmentRepo.save(department);
    }


    public boolean isExistById(Long id) {
        return departmentRepo.existsById(id);
    }

    public void deleteDepartmentById(Long id) {
        departmentRepo.deleteById(id);

    }
}


