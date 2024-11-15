package org.example.first_project.model.mapper;


import org.example.first_project.model.dto.DepartmentDto;
import org.example.first_project.model.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;


@Component
@Mapper(componentModel = "spring")
public interface DepartmentMapper {

    @Mapping(target = "id",source = "id")
    DepartmentDto toDto(Department department);

    @Mapping(target = "employees",ignore=true)
    Department toEntity(DepartmentDto departmentDto);

}
