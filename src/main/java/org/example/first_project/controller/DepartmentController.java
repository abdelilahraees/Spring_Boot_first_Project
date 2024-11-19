package org.example.first_project.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.first_project.model.dto.DepartmentDtoReq;
import org.example.first_project.model.dto.DepartmentDtoRes;
import org.example.first_project.model.entity.Department;
import org.example.first_project.service.DepartmentService;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.DefaultMessageCodesResolver;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping("/get-departments")
    public List<Department> getDepartments() {
        return departmentService.getDepartments();
    }

    @GetMapping("/get-department/{id}")
    public DepartmentDtoRes getDepartmentById(@PathVariable Long id) {
        return departmentService.getDepartmentById(id);
    }

    @PostMapping("/save-department")
    public DepartmentDtoRes saveDepartment(@RequestBody @Valid DepartmentDtoReq dto) {
        return departmentService.saveDepartment(dto);
    }

    @PutMapping("/update-department")
    public DepartmentDtoRes updateDepartment(@RequestBody DepartmentDtoReq departmentDto) {
        return departmentService.updateDepartment(departmentDto);
    }

    @DeleteMapping("/delete-department/{id}")
    private boolean deleteDepartment(@PathVariable long id) {
        return departmentService.deleteDepartmentById(id);
    }

    @ExceptionHandler(BindException.class)
    public Map<String, Object> handleBindException(BindException e) {
        List<String> errorList = e.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).toList();
        Map<String, Object> error = new HashMap();
        error.put("Error", errorList);
        return error;
    }
}
