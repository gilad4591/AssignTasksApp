package com.gilad.AssignTasksApp.service;

import com.gilad.AssignTasksApp.exception.UserNotFoundException;
import com.gilad.AssignTasksApp.model.Manager;
import com.gilad.AssignTasksApp.model.Report;
import com.gilad.AssignTasksApp.repo.ManagerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service

public class ManagerService {
    private final ManagerRepo managerRepo;
    @Autowired
    public ManagerService(ManagerRepo managerRepo) {
        this.managerRepo = managerRepo;
    }

    public List<Manager> findAllManagers(){
        return managerRepo.findAll();
    }


    public Manager findManagerByEmployeeId(Long id){
        return managerRepo.findManagerByEmployeeId(id).orElseThrow(()->new UserNotFoundException("Manager by id " + id + " not found"));
    }

    public void addReportToManager(Report report, Long employeeId){
        Manager managerToAddReport = findManagerByEmployeeId(employeeId);
        managerToAddReport.addReport(report);
        managerRepo.save(managerToAddReport);
    }
}
