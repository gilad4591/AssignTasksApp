package com.gilad.AssignTasksApp;

import com.gilad.AssignTasksApp.model.Employee;
import com.gilad.AssignTasksApp.model.Task;
import com.gilad.AssignTasksApp.service.EmployeeService;
import com.gilad.AssignTasksApp.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskResource {

    private final TaskService taskService;
    private final EmployeeService employeeService;
    public TaskResource(TaskService taskService, EmployeeService employeeService) {
        this.taskService = taskService;
        this.employeeService = employeeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Task>> getTasksByEmployeeId(@PathVariable("id") Long id){
        return new ResponseEntity<>(taskService.findTasksByEmployeeId(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Task> addNewTask(@RequestBody Task task){
        Task newTask = taskService.addTask(task);
        return new ResponseEntity<>(newTask,HttpStatus.CREATED);
    }

    @PutMapping ("/assign/{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Task task, @PathVariable("id") Long employeeId){
        Employee assignedEmployee = employeeService.findEmployeeById(employeeId);
        Task taskToAssign = taskService.findTaskByTaskId(task.getTaskId());
        taskToAssign.setEmployee(assignedEmployee);
        return new ResponseEntity<>(assignedEmployee,HttpStatus.CREATED);
    }

//    @PostMapping("/assign/{taskId}/{employeeId}")
//    public ResponseEntity<>

}
