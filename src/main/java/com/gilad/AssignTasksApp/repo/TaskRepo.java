package com.gilad.AssignTasksApp.repo;

import com.gilad.AssignTasksApp.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Repository
public interface TaskRepo extends JpaRepository<Task, Long> {
    Optional<Task> findTaskByTaskId(Long taskId);
    Optional<List<Task>> findTaskByEmployeeEmployeeId(Long employeeId);
    List<Task> findTasksByDueDate(Date dueDate);
}
