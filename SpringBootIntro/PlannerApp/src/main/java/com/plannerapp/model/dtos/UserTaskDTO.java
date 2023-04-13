package com.plannerapp.model.dtos;

import com.plannerapp.model.entity.Task;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UserTaskDTO {

    private long id;
    private String description;
    private String dueDate;
    private String priority;

    public UserTaskDTO(Task task) {
        this.id = task.getId();
        this.description = task.getDescription();
        this.dueDate = task.getDueDate();
        this.priority = task.getPriority().getPriorityName().toString();
    }

    public long getId() {
        return id;
    }

    public UserTaskDTO setId(long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public UserTaskDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getDueDate() {
        return dueDate;
    }

    public UserTaskDTO setDueDate(String dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public String getPriority() {
        return priority;
    }

    public UserTaskDTO setPriority(String priority) {
        this.priority = priority;
        return this;
    }
}
