package org.example.first_project.model.mapper;

import org.example.first_project.model.dto.EmployeeDtoReq;
import org.example.first_project.model.dto.EmployeeDtoRes;
import org.example.first_project.model.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    @Mapping(target = "department",ignore = true)
    @Mapping(target = "address",ignore = true)
    Employee toEntity(EmployeeDtoReq req);

    @Mapping(target = "department",ignore = true)
    @Mapping(target = "address",ignore = true)
    EmployeeDtoRes toDtoRes(Employee entity);


}
