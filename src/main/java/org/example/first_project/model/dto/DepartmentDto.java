package org.example.first_project.model.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.OneToMany;
import lombok.Data;
import org.example.first_project.model.entity.Employee;

import java.util.List;


@Data
public class DepartmentDto {
    private long id;
    private String name;
    private String description;
    private List<Employee> employees;
}
