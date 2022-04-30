package com.gilad.AssignTasksApp.repo;

import com.gilad.AssignTasksApp.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
public interface TaskRepo extends JpaRepository<Task,Long> {
    Optional<Task> findTaskByTaskId(Long taskId);
    Optional<Task> findTaskByEmployeeEmployeeId(Long employeeId);
}
