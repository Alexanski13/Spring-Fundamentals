package com.plannerapp.model.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AddTaskDTO {

    @Size(min = 2, max = 50)
    @NotBlank
    private String description;

    private String dueDate;

    @NotBlank
    private String priority;

    public AddTaskDTO() {
    }

    public AddTaskDTO(String description, String dueDate, String priority) {
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public AddTaskDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getDueDate() {
        return dueDate;
    }

    public AddTaskDTO setDueDate(String dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public String getPriority() {
        return priority;
    }

    public AddTaskDTO setPriority(String priority) {
        this.priority = priority;
        return this;
    }
}
