package com.plannerapp.service;

import com.plannerapp.model.dtos.AddTaskDTO;
import com.plannerapp.model.dtos.OtherTasksDTO;
import com.plannerapp.model.dtos.UserTaskDTO;
import com.plannerapp.model.entity.Priority;
import com.plannerapp.model.entity.Task;
import com.plannerapp.model.entity.User;
import com.plannerapp.model.enums.PriorityName;
import com.plannerapp.repo.PriorityRepository;
import com.plannerapp.repo.TaskRepository;
import com.plannerapp.repo.UserRepository;
import com.plannerapp.util.LoggedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskService {
    private final UserRepository userRepository;
    private final PriorityRepository priorityRepository;
    private final TaskRepository taskRepository;
    private final LoggedUser loggedUser;

    @Autowired
    public TaskService(UserRepository userRepository,
                       PriorityRepository priorityRepository,
                       TaskRepository taskRepository,
                       LoggedUser loggedUser) {
        this.userRepository = userRepository;
        this.priorityRepository = priorityRepository;
        this.taskRepository = taskRepository;
        this.loggedUser = loggedUser;
    }

    public void created(@Valid AddTaskDTO addTaskDTO) {

        PriorityName priorityName = PriorityName.valueOf(addTaskDTO.getPriority());
        Priority priority = this.priorityRepository.findByPriorityName(priorityName);

        Task task = new Task()
                .setDescription(addTaskDTO.getDescription())
                .setPriority(priority)
                .setDueDate(addTaskDTO.getDueDate());

        this.taskRepository.save(task);
    }

    public List<UserTaskDTO> userTaskList() {

        return this.taskRepository.findAllByUserId(loggedUser.getId())
                .stream()
                .map(UserTaskDTO::new)
                .collect(Collectors.toList());
    }

    public List<OtherTasksDTO> otherTasksList() {
        return this.taskRepository.findAll()
                .stream()
                .filter(task -> task.getUser() == null)
                .map(OtherTasksDTO::new)
                .collect(Collectors.toList());
    }


    public void taskRemove(Long taskId) {
        this.taskRepository.deleteById(taskId);
    }

    public void returnTask(Long id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setUser(null);
            taskRepository.save(task);
        }
    }

    @Transactional
    public void assignTask(Long taskId,  Long userId) {
        Optional<Task> optionalTask = taskRepository.findById(taskId);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setUser(userRepository.getById(userId));
            taskRepository.save(task);
        }
    }
}
