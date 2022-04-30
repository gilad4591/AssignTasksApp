package com.gilad.AssignTasksApp.repo;

import com.gilad.AssignTasksApp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository

public interface EmployeeRepo extends JpaRepository<Employee,Long> {


    void deleteEmployeeByEmployeeId(Long id);

    Optional<Employee> findEmployeeByEmployeeId(Long id);

    Optional<Employee> findEmployeeByManagerEmployeeId(Long id);
}
