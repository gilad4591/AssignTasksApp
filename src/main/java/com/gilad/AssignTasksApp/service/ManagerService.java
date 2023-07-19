package com.gilad.AssignTasksApp.service;

import com.gilad.AssignTasksApp.exception.ReportNotFoundException;
import com.gilad.AssignTasksApp.exception.UserNotFoundException;
import com.gilad.AssignTasksApp.model.Manager;
import com.gilad.AssignTasksApp.model.Report;
import com.gilad.AssignTasksApp.repo.ManagerRepo;
import com.gilad.AssignTasksApp.repo.ReportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ManagerService {
    private final ManagerRepo managerRepo;
    private final ReportRepo reportRepo;

    public ManagerService(ManagerRepo managerRepo, ReportRepo reportRepo) {
        this.managerRepo = managerRepo;
        this.reportRepo = reportRepo;
    }

    public List<Manager> findAllManagers() {
        return managerRepo.findAll();
    }

    public Manager findManagerByEmployeeId(Long id) {
        return managerRepo.findManagerByEmployeeId(id)
                .orElseThrow(() -> new UserNotFoundException("Manager not found for employee ID: " + id));
    }

    public List<Report> findReportsByManagerEmployeeId(Long employeeId) {
        return reportRepo.findReportByManagerEmployeeId(employeeId)
                .orElseThrow(() -> new ReportNotFoundException("Reports not found for manager with employee ID: " + employeeId));
    }

    public void addReportToManager(Report report, Long employeeId) {
        Manager manager = findManagerByEmployeeId(employeeId);
        manager.getReports().add(report);
        report.setManager(manager);
        managerRepo.save(manager);
    }
}
