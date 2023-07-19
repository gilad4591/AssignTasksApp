package com.gilad.AssignTasksApp.service;

import com.gilad.AssignTasksApp.exception.UserNotFoundException;
import com.gilad.AssignTasksApp.model.Department;
import com.gilad.AssignTasksApp.model.Employee;
import com.gilad.AssignTasksApp.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;
    private final DepartmentService departmentService;


    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo, DepartmentService departmentService) {
        this.employeeRepo = employeeRepo;
        this.departmentService = departmentService;
    }

    public Employee addEmployee(Employee employee) {
        employee.setEmployeeId(UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE);
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepo.findAll();
    }

    public List<Employee> findEmployeesByManagerId(Long id) {
        return employeeRepo.findEmployeeByManagerEmployeeId(id)
                .orElseThrow(() -> new UserNotFoundException("Users not found for manager with ID: " + id));
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    public Employee findEmployeeById(Long id) {
        return employeeRepo.findEmployeeByEmployeeId(id)
                .orElseThrow(() -> new UserNotFoundException("User not found for ID: " + id));
    }

    public void deleteEmployee(Long id) {
        employeeRepo.deleteEmployeeByEmployeeId(id);
    }

    public List<Employee> findEmployeesByFirstName(String firstName) {
        return employeeRepo.findEmployeesByFirstName(firstName);
    }

    public List<Employee> findEmployeesByDepartmentId(Long departmentId) {
        return employeeRepo.findEmployeesByDepartmentId(departmentId)
                .orElseThrow(() -> new UserNotFoundException("Employees not found for department with ID: " + departmentId));
    }

    public Employee setEmployeeDepartment(Long employeeId, Long departmentId) {
        Employee employee = employeeRepo.findEmployeeByEmployeeId(employeeId)
                .orElseThrow(() -> new UserNotFoundException("Employee not found for ID: " + employeeId));
        Department department = departmentService.findDepartmentById(departmentId);
        employee.setDepartment(department);
        return employeeRepo.save(employee);
    }
}
