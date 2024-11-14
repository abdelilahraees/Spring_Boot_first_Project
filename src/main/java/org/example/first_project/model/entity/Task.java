package org.example.first_project.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String description;
    private LocalDate date_start;
    private LocalDate date_finishe;


    @JsonBackReference
    @ManyToMany
    @JoinTable(
            name = "tasks_employees",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id"))
    private List<Employee> employees;

    public Task(String title, String description, LocalDate date_start, LocalDate date_finishe, List<Employee> employees) {
        this.title = title;
        this.description = description;
        this.date_start = date_start;
        this.date_finishe = date_finishe;
        this.employees = employees;
    }
}
