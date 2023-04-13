package com.plannerapp.config;

import com.plannerapp.util.LoggedUser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

@Configuration
public class BeanConfig {

    @Bean
    @SessionScope
    public LoggedUser loggedUser() {
        return new LoggedUser();
    }
}
