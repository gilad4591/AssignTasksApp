package com.gilad.AssignTasksApp.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportId;
    private String text;
    private Date date;
    @ManyToOne(fetch = FetchType.LAZY)
    private Manager manager;
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee reporter;

    public Report() {
    }

    public Report(String text, Date date, Employee reporter) {
        this.text = text;
        this.date = date;
        this.reporter = reporter;
    }

    public Long getReportId() {
        return reportId;
    }

    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Employee getReporterId() {
        return reporter;
    }

    public void setReporterId(Employee reporterId) {
        this.reporter = reporter;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
}
