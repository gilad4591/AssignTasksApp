package com.gilad.AssignTasksApp.service;

import com.gilad.AssignTasksApp.exception.ReportNotFoundException;
import com.gilad.AssignTasksApp.model.Report;
import com.gilad.AssignTasksApp.repo.ReportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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
        return reportRepo.findReportByManagerEmployeeId(employeeId).orElseThrow(()->new ReportNotFoundException("report not found for manager" + employeeId));
    }
    public List<Report> findReportsByReporterId(Long reporterId){
        return reportRepo.findReportsByReporterId(reporterId).orElseThrow(()->new ReportNotFoundException("report not found for manager" + reporterId));
    }

    public Report addReport(Report report){
        reportRepo.save(report);
        return report;
    }
    public void deleteReport(Long reportId) {
        try {
            reportRepo.deleteById(reportId);
        } catch (EmptyResultDataAccessException ex) {
            throw new ReportNotFoundException("Report not found for ID: " + reportId);
        }
    }

    public Report updateReport(Report report) {
        if (report.getReportId() == null) {
            throw new IllegalArgumentException("Report ID cannot be null for update operation.");
        }

        if (!reportRepo.existsById(report.getReportId())) {
            throw new ReportNotFoundException("Report not found for ID: " + report.getReportId());
        }

        return reportRepo.save(report);
    }
}
