package com.plannerapp.util;

import com.plannerapp.model.entity.User;

public class LoggedUser {
    private Long id;
    private String username;


    public void login(User user){
        this.id = user.getId();
        this.username = user.getUsername();
    }

    public LoggedUser() {
    }

    public LoggedUser(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public LoggedUser setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public LoggedUser setUsername(String username) {
        this.username = username;
        return this;
    }

    public void logout(){
        this.id = null;
        this.username = null;
    }

    public boolean isLogged(){
        return this.getId() != null;
    }
}