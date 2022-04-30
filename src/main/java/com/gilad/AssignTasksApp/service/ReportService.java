package com.gilad.AssignTasksApp.service;

import com.gilad.AssignTasksApp.exception.ReportNotFoundException;
import com.gilad.AssignTasksApp.model.Report;
import com.gilad.AssignTasksApp.repo.ReportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class ReportService {
    private final ReportRepo reportRepo;
    @Autowired
    public ReportService(ReportRepo reportRepo) {
        this.reportRepo = reportRepo;
    }

    public List<Report> findReportsByManagerEmployeeId(Long employeeId){
        return (List<Report>) reportRepo.findReportByManagerEmployeeId(employeeId).orElseThrow(()->new ReportNotFoundException("report not found for manager" + employeeId));
    }
    public List<Report> findReportsByReporterId(Long reporterId){
        return (List<Report>) reportRepo.findReportsByReporterId(reporterId).orElseThrow(()->new ReportNotFoundException("report not found for manager" + reporterId));
    }

    public Report addReport(Report report){
        reportRepo.save(report);
        return report;
    }
}
