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

    public Manager() {
    }

    public Manager(String firstName, String lastName, List<Task> tasks, List<Employee> employees, List<Report> reports, Department department, Manager manager) {
        super(firstName, lastName, tasks,manager,department);
        this.employees = employees;
        this.reports = reports;
    }



    public void addReport(Report report){
        reports.add(report);
    }

    public void addEmployee (Employee employee){
        employees.add(employee);
    }
}



