package com.gilad.AssignTasksApp.resources;

import com.gilad.AssignTasksApp.model.Department;
import com.gilad.AssignTasksApp.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentResource {
    private final DepartmentService departmentService;

    public DepartmentResource(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Department>> getAllDepartments() {
        List<Department> departments = departmentService.findAllDepartments();
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable("id") Long id) {
        Department department = departmentService.findDepartmentById(id);
        return new ResponseEntity<>(department, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Department> addDepartment(@RequestBody Department department) {
        Department newDepartment = departmentService.addDepartment(department);
        return new ResponseEntity<>(newDepartment, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Department> updateDepartment(@RequestBody Department department) {
        Department updatedDepartment = departmentService.updateDepartment(department);
        return new ResponseEntity<>(updatedDepartment, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDepartment(@PathVariable("id") Long id) {
        departmentService.deleteDepartment(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
