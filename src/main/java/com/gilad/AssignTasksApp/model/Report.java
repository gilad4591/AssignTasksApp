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
    private Long reporterId;
    @ManyToOne(fetch = FetchType.LAZY)
    private Manager manager;


    public Report() {
    }

    public Report(String text, Date date, Long reporterId) {
        this.text = text;
        this.date = date;
        this.reporterId = reporterId;
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

    public Long getReporterId() {
        return reporterId;
    }

    public void setReporterId(Long reporterId) {
        this.reporterId = reporterId;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
}
