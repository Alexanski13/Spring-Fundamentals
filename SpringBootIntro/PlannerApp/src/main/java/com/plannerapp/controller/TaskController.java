package com.plannerapp.controller;

import com.plannerapp.model.dtos.AddTaskDTO;
import com.plannerapp.model.entity.User;
import com.plannerapp.service.TaskService;
import com.plannerapp.service.UserService;
import com.plannerapp.util.LoggedUser;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class TaskController {

    private final TaskService taskService;
    private final UserService userService;

    private final LoggedUser loggedUser;


    public TaskController(TaskService taskService,
                          UserService userService,
                           LoggedUser loggedUser) {
        this.taskService = taskService;
        this.userService = userService;
        this.loggedUser = loggedUser;
    }

    @ModelAttribute("addTaskDTO")
    public AddTaskDTO initAddTaskDTO(){
        return new AddTaskDTO();
    }

    @GetMapping("/task/add")
    public String task(){
        if(this.userService.isLogged()) {
            return "task-add";
        }
        return "redirect:/login";
    }

    @PostMapping("/task/add")
    public String addTask(@Valid AddTaskDTO addTaskDTO,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes){

        if(!this.userService.isLogged()) {
            return "redirect:/";
        }

        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("addTaskDTO", addTaskDTO);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.addTaskDTO", bindingResult);

            return "redirect:/task/add";
        }

        this.taskService.created(addTaskDTO);

        return "redirect:/home";
    }

    @GetMapping("/task/remove/{id}")
    String removeTask(@PathVariable Long id){
        if(!this.userService.isLogged()) {
            return "redirect:/";
        }

        taskService.taskRemove(id);
        return "redirect:/home";
    }

    @GetMapping("/task/return/{id}")
    public String returnTask(@PathVariable("id") Long id) {
        taskService.returnTask(id);
        return "redirect:/";
    }

    @GetMapping("/task/assign/{id}")
    String assignTask(@PathVariable("id") Long id){
        if(!this.userService.isLogged()) {
            return "redirect:/";
        }

        Long userId = this.loggedUser.getId();
        taskService.assignTask(id, userId);
        return "redirect:/home";
    }
}
