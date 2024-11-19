package org.example.first_project.service.imp;


import lombok.RequiredArgsConstructor;
import org.example.first_project.dao.DepartmentDao;
import org.example.first_project.model.dto.DepartmentDtoReq;
import org.example.first_project.model.dto.DepartmentDtoRes;
import org.example.first_project.model.entity.Department;
import org.example.first_project.model.entity.Employee;
import org.example.first_project.model.mapper.DepartmentMapper;
import org.example.first_project.model.mapper.EmployeeMapper;
import org.example.first_project.service.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImp implements DepartmentService {

    private final DepartmentDao departmentDao;
    private final DepartmentMapper departmentMapper;
    private final EmployeeMapper employeeMapper;

    @Override
    public DepartmentDtoRes saveDepartment(DepartmentDtoReq department) {

        Department departmentEntity = new Department();
        departmentEntity.setName(department.getName());
        departmentEntity.setDescription(department.getDescription());
        departmentEntity = departmentDao.createDepartment(departmentEntity);
        return departmentMapper.toRes(departmentEntity);
    }

    @Override
    public DepartmentDtoRes updateDepartment(DepartmentDtoReq department) {
        Department departmentEntity = departmentMapper.toEntity(department);
        departmentEntity = departmentDao.createDepartment(departmentEntity);
        return departmentMapper.toRes(departmentEntity);
    }

    @Override
    public DepartmentDtoRes getDepartmentById(long id) {
        Department entity=departmentDao.getDepartmentById(id);
        DepartmentDtoRes dto=departmentMapper.toRes(entity);

       if(!entity.getEmployees().isEmpty()){
           for(Employee emp :entity.getEmployees()){
               dto.getEmployees().add(employeeMapper.toDtoRes(emp));
           }
       }
        return dto;
    }

    @Override
    public List<Department> getDepartments() {
        return departmentDao.getdepartment();
    }

    @Override
    public boolean deleteDepartmentById(Long id) {
        return departmentDao.deleteDepartmentById(id);
    }
}
