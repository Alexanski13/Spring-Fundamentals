package com.plannerapp.model.dtos;

import com.plannerapp.model.entity.Task;

public class OtherTasksDTO {

    private Long id;

    private String dueDate;

    private String priority;

    private String description;

    public OtherTasksDTO(Task task) {
        this.id = task.getId();
        this.dueDate = task.getDueDate();
        this.priority = task.getPriority().getPriorityName().toString();
        this.description = task.getDescription();
    }

    public Long getId() {
        return id;
    }

    public OtherTasksDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDueDate() {
        return dueDate;
    }

    public OtherTasksDTO setDueDate(String dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public String getPriority() {
        return priority;
    }

    public OtherTasksDTO setPriority(String priority) {
        this.priority = priority;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OtherTasksDTO setDescription(String description) {
        this.description = description;
        return this;
    }
}
