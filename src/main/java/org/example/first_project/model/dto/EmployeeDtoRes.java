package org.example.first_project.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.first_project.model.entity.Address;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDtoRes {
    private long id;
    private String name;
    private String email;
    private double salary;
    private int age;
    private DepartmentDtoRes department;
    private AddressDto address;


}
