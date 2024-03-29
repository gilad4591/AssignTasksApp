package com.gilad.AssignTasksApp.model;

import com.gilad.AssignTasksApp.Common.TaskStatus;
import com.gilad.AssignTasksApp.exception.InvalidStatusException;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;
    private String text;
    private Date assignDate;
    private Date dueDate;
    @ManyToOne(fetch = FetchType.LAZY)
    private Manager manager; // Many tasks can be assigned by one manager
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employee;
    private TaskStatus status = TaskStatus.NOT_STARTED;
    private String completionDate;

    public Task() {
    }

    public Task(Long taskId, String text, Date assignDate, Date dueDate, Manager manager) {
        this.taskId = taskId;
        this.text = text;
        this.assignDate = assignDate;
        this.dueDate = dueDate;
        this.manager = manager;

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

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public String getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(String completionDate) {
        this.completionDate = completionDate;
    }

    public void updateStatus(TaskStatus newStatus) {
        this.status = newStatus;
        if (newStatus == (TaskStatus.COMPLETED)) {
            this.completionDate = new Date().toString(); // Update with current date
        } else if (newStatus==(TaskStatus.NOT_STARTED) || newStatus==(TaskStatus.IN_PROGRESS)) {
            this.completionDate = "";
        } else {
            throw new InvalidStatusException("Status is incorrect: " + newStatus);
        }
    }
}
