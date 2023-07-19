package com.gilad.AssignTasksApp;

import com.gilad.AssignTasksApp.model.Manager;
import com.gilad.AssignTasksApp.model.Report;
import com.gilad.AssignTasksApp.service.ManagerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/manager")
public class ManagerResource {
    private final ManagerService managerService;

    public ManagerResource(ManagerService managerService) {
        this.managerService = managerService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Manager>> getAllManagers() {
        List<Manager> managers = managerService.findAllManagers();
        return new ResponseEntity<>(managers, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Manager> getManagerByEmployeeId(@PathVariable("id") Long id) {
        Manager manager = managerService.findManagerByEmployeeId(id);
        return new ResponseEntity<>(manager, HttpStatus.OK);
    }

    @GetMapping("/{id}/reports")
    public ResponseEntity<List<Report>> getReportsByManagerEmployeeId(@PathVariable("id") Long id) {
        List<Report> reports = managerService.findReportsByManagerEmployeeId(id);
        return new ResponseEntity<>(reports, HttpStatus.OK);
    }
}

