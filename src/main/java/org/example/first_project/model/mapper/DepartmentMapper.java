package org.example.first_project.model.mapper;


import org.example.first_project.model.dto.DepartmentDtoReq;
import org.example.first_project.model.dto.DepartmentDtoRes;
import org.example.first_project.model.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;


@Mapper(componentModel = "spring")
@Component
public interface
DepartmentMapper {

    @Mapping(target = "employees", ignore = true)
    DepartmentDtoRes toRes(Department department);

    @Mapping(target = "employees", ignore = true)
    Department toEntity(DepartmentDtoReq departmentDto);

    DepartmentDtoReq toReq(DepartmentDtoRes department);

}
