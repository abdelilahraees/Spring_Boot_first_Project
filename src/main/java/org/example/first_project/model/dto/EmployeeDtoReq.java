package org.example.first_project.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.first_project.model.entity.Department;
import org.example.first_project.model.entity.Task;
import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDtoReq {
    private long id;
    private String name;
    private String email;
    private double salary;
    private int age;
    private long department_id;
//    private List<Task> tasks;
}
