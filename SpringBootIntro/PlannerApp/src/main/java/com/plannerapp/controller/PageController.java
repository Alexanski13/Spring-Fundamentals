package com.plannerapp.controller;

import com.plannerapp.model.dtos.OtherTasksDTO;
import com.plannerapp.model.dtos.UserTaskDTO;
import com.plannerapp.service.TaskService;
import com.plannerapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PageController {

    private final TaskService taskService;
    private final UserService userService;

    @Autowired
    public PageController(TaskService taskService, UserService userService) {
        this.taskService = taskService;
        this.userService = userService;
    }

    @GetMapping({"/home"})
    public String loggedInIndex(Model model){
        if(!this.userService.isLogged()) {
            return "redirect:/";
        }

        List<UserTaskDTO> userTasks = this.taskService.userTaskList();
        List<OtherTasksDTO> otherTasks = this.taskService.otherTasksList();

        model.addAttribute("userTasks", userTasks);
        model.addAttribute("otherTasks", otherTasks);



        return "home";
    }

    @GetMapping({"/"})
    public String loggedOutIndex(){
        if(this.userService.isLogged()) {
            return "redirect:/home";
        }
        return "index";
    }
}
