package org.example.first_project.model.mapper;


import org.example.first_project.model.dto.DepartmentDto;
import org.example.first_project.model.entity.Department;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;


@Component
@Mapper(componentModel = "spring")
public interface DepartmentMapper {


    DepartmentDto toDto(Department department);

    Department toEntity(DepartmentDto departmentDto);

}
