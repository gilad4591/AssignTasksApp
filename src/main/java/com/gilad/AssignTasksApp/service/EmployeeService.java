package com.gilad.AssignTasksApp.service;

import com.gilad.AssignTasksApp.exception.UserNotFoundException;
import com.gilad.AssignTasksApp.model.Employee;
import com.gilad.AssignTasksApp.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;
    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee){
        employee.setEmployeeId(UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE);
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployee(){
        return employeeRepo.findAll();
    }
    public List<Employee> findEmployeesByManagerId(Long id){
        return (List<Employee>) employeeRepo.findEmployeeByManagerEmployeeId(id).orElseThrow(()->new UserNotFoundException("Users not found"));
    }

    public Employee updateEmployee(Employee employee)
    {
        return employeeRepo.save(employee);
    }

    public Employee findEmployeeById(Long id){
        return employeeRepo.findEmployeeByEmployeeId(id).orElseThrow(()->new UserNotFoundException("User by id " + id + " not found"));
    }

    public void deleteEmployee(Long id){
        employeeRepo.deleteEmployeeByEmployeeId(id);
    }
}
