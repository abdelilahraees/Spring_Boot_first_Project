package org.example.first_project.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    @JsonManagedReference
    @OneToMany(mappedBy = "department")
    private List<Employee> employees;
    public Department(){
        this.employees=new ArrayList<>();
    }

    public Department(String name, String description, List<Employee> employees) {
        this.name = name;
        this.description = description;
        this.employees = employees;
    }
}
