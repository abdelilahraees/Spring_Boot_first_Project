package org.example.first_project.service.imp;

import lombok.RequiredArgsConstructor;
import org.example.first_project.dao.EmployeeDao;
import org.example.first_project.model.dto.DepartmentDtoRes;
import org.example.first_project.model.dto.EmployeeDtoReq;
import org.example.first_project.model.dto.EmployeeDtoRes;
import org.example.first_project.model.entity.Address;
import org.example.first_project.model.entity.Employee;
import org.example.first_project.model.mapper.AddressMapper;
import org.example.first_project.model.mapper.DepartmentMapper;
import org.example.first_project.model.mapper.EmployeeMapper;
import org.example.first_project.service.AddressService;
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

    private final AddressService addressService;

    @Override
    public List<Employee> getEmployees() {
        return employeeDao.getEmployees();
    }

    @Override
    public EmployeeDtoRes getEmployeeById(Long id) {
        Employee employee = employeeDao.getEmployeeById(id).orElse(new Employee());
        EmployeeDtoRes res = employeeMapper.toDtoRes(employee);
        res.setDepartment(departmentMapper.toRes(employee.getDepartment()));
        res.setAddress(addressMapper.toDto(employee.getAddress()));
        return res;
    }

    @Override
    public EmployeeDtoRes createEmployee(EmployeeDtoReq req) {
        Employee employee = employeeMapper.toEntity(req);
        if (req.getDepartment().getId() != 0) {
            DepartmentDtoRes departmentseved = departmentService.getDepartmentById(req.getDepartment().getId()).get();
            employee.setDepartment(departmentMapper.toEntity(departmentMapper.toReq(departmentseved)));
            System.out.println(departmentseved);
        } else {
            employee.setDepartment((departmentMapper.toEntity(req.getDepartment())));
        }
        Address address = addressMapper.toEntity(req.getAddress());
        employee = employeeDao.createEmployee(employee);
        address.setEmployee(employee);
        addressService.createAddress(address);
        EmployeeDtoRes res = employeeMapper.toDtoRes(employee);
        res.setDepartment(departmentMapper.toRes(employee.getDepartment()));
        res.setAddress(addressMapper.toDto(address));
        return res;

    }

    @Override
    public EmployeeDtoRes updateEmployee(EmployeeDtoReq req) {
        Employee employee = employeeMapper.toEntity(req);
        employee.setDepartment(departmentMapper.toEntity(req.getDepartment()));
        employee.setAddress(addressMapper.toEntity(req.getAddress()));
        employee = employeeDao.updateEmployee(employee);
        EmployeeDtoRes res = employeeMapper.toDtoRes(employee);
        System.out.println(employee.getAddress().getId());
        res.setDepartment(departmentMapper.toRes(employee.getDepartment()));
        res.setAddress(addressMapper.toDto(employee.getAddress()));
        return res;

    }

    @Override
    public boolean isExist(Long id) {
        return employeeDao.isExistById(id);
    }

    @Override
    public boolean deleteEmployeeById(long id) {
        if (this.isExist(id)) {
            try {
                employeeDao.deleteDepartmentById(id);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        return false;

    }
}
