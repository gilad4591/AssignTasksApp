package com.gilad.AssignTasksApp.repo;


import com.gilad.AssignTasksApp.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReportRepo extends JpaRepository<Report,Long> {
    Optional<Report> findReportByManagerEmployeeId(Long employeeId);
    Optional<Report> findReportsByReporterId(Long reporterId);
}
