package com.gilad.AssignTasksApp.model;



import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    private String firstName;
    private String lastName;
    @ManyToOne(fetch = FetchType.LAZY)
    private Manager manager;
    @OneToMany(mappedBy = "employee")
    private List<Task> tasks;
    @OneToMany(mappedBy = "reporter", cascade = CascadeType.ALL)
    private List<Report> reports;
    @ManyToOne(fetch = FetchType.LAZY)
    private Department department;

    public Employee() {
    }

    public Employee(String firstName, String lastName, List<Task> tasks, Manager manager, Department department) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.tasks = tasks;
        this.manager = manager;
        this.department = department;
    }


    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Report> getReports() {
        return reports;
    }

    public void setReports(List<Report> reports) {
        this.reports = reports;
    }
}
