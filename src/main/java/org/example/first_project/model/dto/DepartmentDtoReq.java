package org.example.first_project.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDtoReq {
    private long id;
    @NotBlank(message = "Name Is required")
    private String name;
    @Email(message = "department in required Email Address")
    private String description;
}
