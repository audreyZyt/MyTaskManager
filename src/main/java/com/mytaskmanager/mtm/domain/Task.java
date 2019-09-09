package com.mytaskmanager.mtm.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Task {

    @Id
    @GeneratedValue
    private Long id;
    @NotBlank (message = "Task Name can't be blank")
    private String taskName;
    @NotBlank (message = "Task Identifier can't be blank")
    @Size(min = 2, max = 6, message = "Please use 2 to 6 characters")
    @Column (updatable = false, unique = true)
    private String taskIdentifier;
    private String description;
    @JsonFormat (pattern = "yyyy-mm-dd")
    private Date startDate;
    @JsonFormat (pattern = "yyyy-mm-dd")
    private Date endDate;

    @JsonFormat (pattern = "yyyy-mm-dd")
    private Date createdAt;
    @JsonFormat (pattern = "yyyy-mm-dd")
    private Date updatedAt;

    public Task () {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskIdentifier() {
        return taskIdentifier;
    }

    public void setTaskIdentifier(String taskIdentifier) {
        this.taskIdentifier = taskIdentifier;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }



}
