package com.gilad.AssignTasksApp.service;

import com.gilad.AssignTasksApp.Common.TaskStatus;
import com.gilad.AssignTasksApp.exception.TaskNotFoundException;
import com.gilad.AssignTasksApp.exception.UserNotFoundException;
import com.gilad.AssignTasksApp.model.Employee;
import com.gilad.AssignTasksApp.model.Task;
import com.gilad.AssignTasksApp.repo.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TaskService {
    private final TaskRepo taskRepo;

    @Autowired
    public TaskService(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }

    public List<Task> findAllTasks() {
        return taskRepo.findAll();
    }

    public Task addTask(Task task) {
        return taskRepo.save(task);
    }

    public Task findTaskByTaskId(Long taskId) {
        return taskRepo.findTaskByTaskId(taskId)
                .orElseThrow(() -> new TaskNotFoundException("Task not found for ID: " + taskId));
    }

    public List<Task> findTasksByEmployeeId(Long employeeId) {
        return taskRepo.findTaskByEmployeeEmployeeId(employeeId)
                .orElseThrow(() -> new TaskNotFoundException("Tasks not found for employee with ID: " + employeeId));
    }

    public List<Task> findTasksByDueDate(Date dueDate) {
        return taskRepo.findTasksByDueDate(dueDate);
    }

    public Task updateTaskStatus(Long taskId, TaskStatus newStatus) {
        Task task = taskRepo.findTaskByTaskId(taskId)
                .orElseThrow(() -> new TaskNotFoundException("Task not found for ID: " + taskId));

        task.updateStatus(newStatus);

        return taskRepo.save(task);
    }
}
