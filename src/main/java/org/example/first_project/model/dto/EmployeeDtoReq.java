package org.example.first_project.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDtoReq {
    private long id;
    private String name;
    private String email;
    private double salary;
    private int age;
    private DepartmentDtoReq department;
    private AddressDto address;
//    private List<Task> tasks;
}
