package com.gilad.AssignTasksApp.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Task {
//    @GeneratedValue

    @Id
    private Long taskId;
    private String text;
    private Date assignDate;
    private Date dueDate;
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employee;

    public Task(Long taskId, String text, Date assignDate, Date dueDate) {
        this.taskId = taskId;
        this.text = text;
        this.assignDate = assignDate;
        this.dueDate = dueDate;

    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getAssignDate() {
        return assignDate;
    }

    public void setAssignDate(Date assignDate) {
        this.assignDate = assignDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
