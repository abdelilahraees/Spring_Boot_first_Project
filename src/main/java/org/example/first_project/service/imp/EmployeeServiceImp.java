package org.example.first_project.service.imp;

import lombok.RequiredArgsConstructor;
import org.example.first_project.dao.EmployeeDao;
import org.example.first_project.model.dto.DepartmentDtoRes;
import org.example.first_project.model.dto.EmployeeDtoReq;
import org.example.first_project.model.dto.EmployeeDtoRes;
import org.example.first_project.model.entity.Employee;
import org.example.first_project.model.mapper.AddressMapper;
import org.example.first_project.model.mapper.DepartmentMapper;
import org.example.first_project.model.mapper.EmployeeMapper;
import org.example.first_project.service.DepartmentService;
import org.example.first_project.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class EmployeeServiceImp implements EmployeeService {
    private final EmployeeDao employeeDao;
    private final EmployeeMapper employeeMapper;
    private final DepartmentService departmentService;
    private final AddressMapper addressMapper;

    private final DepartmentMapper departmentMapper;

    @Override
    public List<Employee> getEmployees() {
        return employeeDao.getEmployees();
    }

    @Override
    public EmployeeDtoRes getEmployeeById(Long id) {
        Employee employee=employeeDao.getEmployeeById(id).orElse(new Employee());
        EmployeeDtoRes res = employeeMapper.toDtoRes(employee);
        res.setDepartment(departmentMapper.toRes(employee.getDepartment()));
        return res;
    }

    @Override
    public EmployeeDtoRes createEmployee(EmployeeDtoReq req) {
        Employee employee = employeeMapper.toEntity(req);
        if (req.getDepartment().getId() != 0) {
            DepartmentDtoRes departmentseved = departmentService.getDepartmentById(req.getDepartment().getId());
            employee.setDepartment(departmentMapper.toEntity(departmentMapper.toReq(departmentseved)));
            System.out.println(departmentseved);
        } else {
            employee.setDepartment((departmentMapper.toEntity(req.getDepartment())));
        }
        employee.setAddress(addressMapper.toEntity(req.getAddress()));
        employee = employeeDao.createEmployee(employee);
//        System.out.println(employee.getDepartment().getName());
      //  System.out.println(employee.getAddress().getId());
        EmployeeDtoRes res = employeeMapper.toDtoRes(employee);
        res.setDepartment(departmentMapper.toRes(employee.getDepartment()));
        res.setAddress(addressMapper.toDto(employee.getAddress()));
        return res;

    }

    @Override
    public EmployeeDtoRes updateEmployee(EmployeeDtoReq req) {
        Employee employee = employeeMapper.toEntity(req);
        employee.setDepartment(departmentMapper.toEntity(req.getDepartment()));
        System.out.println(employee.getName());
        employee = employeeDao.updateEmployee(employee);
        EmployeeDtoRes res = employeeMapper.toDtoRes(employee);
        res.setDepartment(departmentMapper.toRes(employee.getDepartment()));
        return res;

    }

    @Override
    public boolean deleteEmployeeById(long id) {
        return employeeDao.deleteDepartmentById(id);
    }
}
