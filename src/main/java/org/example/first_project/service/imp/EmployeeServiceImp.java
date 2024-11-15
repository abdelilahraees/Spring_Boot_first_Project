package org.example.first_project.service.imp;

import lombok.RequiredArgsConstructor;
import org.example.first_project.dao.EmployeeDao;
import org.example.first_project.model.dto.EmployeeDtoReq;
import org.example.first_project.model.dto.EmployeeDtoRes;
import org.example.first_project.model.entity.Department;
import org.example.first_project.model.entity.Employee;
import org.example.first_project.model.mapper.DepartmentMapper;
import org.example.first_project.model.mapper.EmployeeMapper;
import org.example.first_project.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class EmployeeServiceImp implements EmployeeService {
    private final EmployeeDao employeeDao;
    private final EmployeeMapper employeeMapper;

    private final DepartmentMapper departmentMapper;

    @Override
    public List<Employee> getEmployees() {
        return employeeDao.getEmployees();
    }

    @Override
    public EmployeeDtoRes getEmployeeById(Long id) {
        return employeeMapper.toEmployeeDtoRes(employeeDao.getEmployeeById(id).orElse(new Employee()));
    }

    @Override
    public EmployeeDtoReq createEmployee(EmployeeDtoReq req) {
        Employee employee = employeeMapper.toEmployeeEntity(req);
        employee.getDepartment().setId(req.getDepartment_id());
        System.out.println(employee.getName());
        employee = employeeDao.updateEmployee(employee);
        req = employeeMapper.toEmployeeDtoReq(employee);
        return req;

    }

    @Override
    public EmployeeDtoReq updateEmployee(EmployeeDtoReq req) {
        Employee employee = employeeMapper.toEmployeeEntity(req);
        employee.getDepartment().setId(req.getDepartment_id());
        System.out.println(employee.getName());
        employee = employeeDao.createEmployee(employee);
        req = employeeMapper.toEmployeeDtoReq(employee);
        return req;

    }

    @Override
    public boolean deleteEmployeeById(long id) {
        return employeeDao.deleteDepartmentById(id);
    }
}
