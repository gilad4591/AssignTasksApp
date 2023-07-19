package com.gilad.AssignTasksApp.service;

import com.gilad.AssignTasksApp.exception.DepartmentNotFoundException;
import com.gilad.AssignTasksApp.model.Department;
import com.gilad.AssignTasksApp.repo.DepartmentRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    private final DepartmentRepo departmentRepo;

    public DepartmentService(DepartmentRepo departmentRepo) {
        this.departmentRepo = departmentRepo;
    }

    public Department findDepartmentById(Long id) {
        return departmentRepo.findById(id)
                .orElseThrow(() -> new DepartmentNotFoundException("Department not found for ID: " + id));
    }

    public List<Department> findAllDepartments() {
        return departmentRepo.findAll();
    }

    public Department addDepartment(Department department) {
        return departmentRepo.save(department);
    }

    public Department updateDepartment(Department department) {
        return departmentRepo.save(department);
    }

    public void deleteDepartment(Long id) {
        departmentRepo.deleteById(id);
    }
}
