package org.example.first_project.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDtoRes { private String name;
    private String email;
    private String salary;
    private String age;
    private DepartmentDto department;

}
