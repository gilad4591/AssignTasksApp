package com.gilad.AssignTasksApp.resources;

import com.gilad.AssignTasksApp.model.Manager;
import com.gilad.AssignTasksApp.model.Report;
import com.gilad.AssignTasksApp.service.EmployeeService;
import com.gilad.AssignTasksApp.service.ManagerService;
import com.gilad.AssignTasksApp.service.ReportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//import com.gilad.AssignTasksApp.service.TaskService;
@RestController
@RequestMapping("/report")
public class ReportResource {
    private final ReportService reportService;
    private final ManagerService managerService;


    public ReportResource(ReportService reportService, ManagerService managerService) {
        this.reportService = reportService;
        this.managerService = managerService;
    }

    @GetMapping("/findReports/{id}")
    public ResponseEntity<List<Report>> getReportsByManagerEmployeeId(@PathVariable("id") Long id){
        return new ResponseEntity<>(reportService.findReportsByManagerEmployeeId(id), HttpStatus.OK);
    }

    @PostMapping("/add/{id}")
    public ResponseEntity<Report> addNewReport(@RequestBody Report report, @PathVariable("id") Long managerId){
        managerService.addReportToManager(report,managerId);
        Report newReport = reportService.addReport(report);
        return new ResponseEntity<>(newReport,HttpStatus.CREATED);
    }

    /* @PutMapping ("/assign/{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Task task, @PathVariable("id") Long employeeId){
        Employee assignedEmployee = employeeService.findEmployeeById(employeeId);
        Task taskToAssign = taskService.findTaskByTaskId(task.getTaskId());
        taskToAssign.setEmployee(assignedEmployee);
        return new ResponseEntity<>(assignedEmployee,HttpStatus.CREATED);
    } */

}
