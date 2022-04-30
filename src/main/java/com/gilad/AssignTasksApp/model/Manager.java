package com.gilad.AssignTasksApp.model;

//import com.gilad.AssignTasksApp.model.Report;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Manager extends Employee{
    @OneToMany (mappedBy = "manager")
    private List<Employee> employees;
    @OneToMany(mappedBy = "manager")
    private List<Report> reports;

    public Manager(Long employeeId, String firstName, String lastName, String position,
                   List<Employee> employees, List<Task> tasks

                  ,List<Report> reports
    ) {
        super(employeeId, firstName, lastName, position, tasks);
        this.employees = employees;
        this.reports = reports;
    }


    public List<Report> getReports() {
        return reports;
    }

    public void addReport(Report report){
        List<Report> reports = getReports();
        reports.add(report);
    }

    public void setReports(List<Report> reports) {
        this.reports = reports;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
