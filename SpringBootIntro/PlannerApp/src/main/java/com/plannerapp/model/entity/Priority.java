package com.plannerapp.model.entity;

import com.plannerapp.model.enums.PriorityName;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "priorities")
public class Priority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    private PriorityName priorityName;

    @Column(nullable = false)
    private String description;

    @ManyToMany
    private List<Task> tasks;

    public Priority() {
        this.tasks = new ArrayList<>();
    }

    public Priority(PriorityName priorityName) {
        this.priorityName = priorityName;

        switch (priorityName.toString()){
            case "URGENT":
                this.description = "An urgent problem that blocks the system use until the issue is resolved.";
                break;
            case "IMPORTANT":
                this.description = "A core functionality that your product is explicitly supposed to perform is compromised.";
                break;
            case "LOW":
                this.description = "Should be fixed if time permits but can be postponed.";
                break;
            default:
                this.description = "No such priority type!";
        };
    }

    public Priority(Long id, PriorityName priorityName, String description, List<Task> tasks) {
        this.id = id;
        this.priorityName = priorityName;
        this.description = description;
        this.tasks = tasks;
    }

    public Long getId() {
        return id;
    }

    public Priority setId(Long id) {
        this.id = id;
        return this;
    }

    public PriorityName getPriorityName() {
        return priorityName;
    }

    public Priority setPriorityName(PriorityName priorityName) {
        this.priorityName = priorityName;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Priority setDescription(String description) {
        this.description = description;
        return this;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public Priority setTasks(List<Task> tasks) {
        this.tasks = tasks;
        return this;
    }
}
