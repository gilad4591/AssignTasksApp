package com.gilad.AssignTasksApp.service;

import com.gilad.AssignTasksApp.exception.TaskNotFoundException;
import com.gilad.AssignTasksApp.exception.UserNotFoundException;
import com.gilad.AssignTasksApp.model.Employee;
import com.gilad.AssignTasksApp.model.Task;
import com.gilad.AssignTasksApp.repo.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepo taskRepo;
    @Autowired
    public TaskService(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }


    public List<Task> findAllTasks(){
        return taskRepo.findAll();
    }

    public Task addTask(Task task){
         taskRepo.save(task);
         return task;
    }


    public Task findTaskByTaskId(Long taskId){
        return taskRepo.findTaskByTaskId(taskId).orElseThrow(()->new TaskNotFoundException("task  " + taskId + " not found"));
    }

    public List<Task> findTasksByEmployeeId(Long employeeId){
        return (List<Task>) taskRepo.findTaskByEmployeeEmployeeId(employeeId).orElseThrow(()->new TaskNotFoundException("tasks not found for employee" + employeeId));
    }


}
