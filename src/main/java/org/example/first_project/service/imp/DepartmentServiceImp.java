package org.example.first_project.service.imp;


import lombok.RequiredArgsConstructor;
import org.example.first_project.dao.DepartmentDao;
import org.example.first_project.model.dto.DepartmentDto;
import org.example.first_project.model.entity.Department;
import org.example.first_project.model.mapper.DepartmentMapper;
import org.example.first_project.service.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImp implements DepartmentService {

    private final DepartmentDao departmentDao;
    private final DepartmentMapper departmentMapper;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto department) {
        Department departmentEntity = departmentMapper.toEntity(department);
        departmentEntity=departmentDao.createDepartment(departmentEntity);
        return departmentMapper.toDto(departmentEntity);
    }

    @Override
    public DepartmentDto getDepartmentById(Long id) {
       return departmentMapper.toDto(departmentDao.getDepartmentById(id));
    }

    @Override
    public List<Department> getDepartments() {
        return departmentDao.getdepartment();
    }
}
