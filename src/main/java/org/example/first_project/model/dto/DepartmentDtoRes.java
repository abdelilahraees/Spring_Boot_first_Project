package org.example.first_project.model.dto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor

public class DepartmentDtoRes {
    private long id;
    private String name;
    private String description;
    private List<EmployeeDtoRes> employees;

    public DepartmentDtoRes(){
        this.employees = new ArrayList<>();
    }



}
