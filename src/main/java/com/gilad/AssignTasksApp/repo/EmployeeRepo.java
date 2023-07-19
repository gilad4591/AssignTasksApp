package com.gilad.AssignTasksApp.repo;

import com.gilad.AssignTasksApp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    Optional<List<Employee>> findEmployeeByManagerEmployeeId(Long id);
    Optional<Employee> findEmployeeByEmployeeId(Long id);
    void deleteEmployeeByEmployeeId(Long id);
    List<Employee> findEmployeesByFirstName(String firstName);
    Optional<List<Employee>> findEmployeesByDepartmentId(Long departmentId);
}
