package org.example.first_project.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private double salary;
    private String email;
    private int age;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;


    @JsonBackReference
    @ManyToOne()
    @JoinColumn(name = "department_id")
    private Department department;

    @JsonManagedReference
    @ManyToMany(mappedBy = "employees")
    private List<Task> tasks;
    @JsonManagedReference
    @OneToOne(mappedBy = "employee")
    private Address address;


    public  Employee(){
        this.department=new Department();
    }

    public Employee(String name, double salary,
                    String email, int age,
                    LocalDateTime createdAt, LocalDateTime updatedAt,
                    LocalDateTime deletedAt, Department department,
                    List<Task> tasks, Address address) {
        this.name = name;
        this.salary = salary;
        this.email = email;
        this.age = age;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
        this.department = department;
        this.tasks = tasks;
        this.address = address;
    }
}
