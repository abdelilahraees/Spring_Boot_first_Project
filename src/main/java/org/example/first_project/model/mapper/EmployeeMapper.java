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
    Employee toEmployeeEntity(EmployeeDtoReq req);


    EmployeeDtoRes toEmployeeDtoRes(Employee entity);



    @Mapping(target ="department",ignore = true)
    EmployeeDtoReq toEmployeeDtoReq(Employee entity);

}
