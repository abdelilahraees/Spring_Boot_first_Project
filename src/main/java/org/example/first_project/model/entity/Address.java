package org.example.first_project.model.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String city;
    private String street;
    private int HouseNumber;

    @JsonBackReference
    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;


    public Address(String city, String street, int houseNumber, Employee employee) {
        this.city = city;
        this.street = street;
        HouseNumber = houseNumber;
        this.employee = employee;
    }
}
