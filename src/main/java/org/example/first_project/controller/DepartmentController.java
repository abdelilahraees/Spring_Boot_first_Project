package org.example.first_project.controller;

import lombok.RequiredArgsConstructor;
import org.example.first_project.model.dto.DepartmentDto;
import org.example.first_project.model.entity.Department;
import org.example.first_project.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public DepartmentDto getDepartmentById(@PathVariable Long id) {
        return departmentService.getDepartmentById(id);
    }

    @PostMapping("/save-department")
    public DepartmentDto saveDepartment(@RequestBody DepartmentDto dto) {
        return departmentService.saveDepartment(dto);
    }

    @PutMapping("/update-department")
    public DepartmentDto updateDepartment(@RequestBody DepartmentDto departmentDto) {
        return departmentService.updateDepartment(departmentDto);
    }

    @DeleteMapping("/delete-department/{id}")
    private boolean deleteDepartment(@PathVariable long id) {
        return departmentService.deleteDepartmentById(id);
    }


}
