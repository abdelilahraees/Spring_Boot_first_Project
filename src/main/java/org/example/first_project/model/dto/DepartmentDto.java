package org.example.first_project.model.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.first_project.model.entity.Employee;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {
    private long id;
    private String name;
    private String description;
//    private List<Employee> employees;
}
