package com.gilad.AssignTasksApp.repo;


import com.gilad.AssignTasksApp.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ReportRepo extends JpaRepository<Report,Long> {
    Optional<List<Report>> findReportByManagerEmployeeId(Long employeeId);
    Optional<List<Report>> findReportsByReporterId(Long reporterId);
}
