package com.plannerapp.service;

import com.plannerapp.model.dtos.UserLoginDTO;
import com.plannerapp.model.dtos.UserRegistrationDTO;
import com.plannerapp.model.entity.User;
import com.plannerapp.repo.UserRepository;
import com.plannerapp.util.LoggedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final LoggedUser loggedUser;

    @Autowired
    public UserService(UserRepository userRepository,
                       LoggedUser loggedUser) {
        this.userRepository = userRepository;
        this.loggedUser = loggedUser;
    }

    public boolean register(@Valid UserRegistrationDTO registrationDTO) {
        if (!registrationDTO.getPassword().equals(registrationDTO.getConfirmPassword())) {
            return false;
        }

        Optional<User> byUsername = this.userRepository.findByUsername(registrationDTO.getUsername());
        if (byUsername.isPresent()) {
            return false;
        }

        Optional<User> byEmail = this.userRepository.findByEmail(registrationDTO.getEmail());
        if (byEmail.isPresent()) {
            return false;
        }

        User user = new User()
                .setUsername(registrationDTO.getUsername())
                .setPassword(registrationDTO.getPassword())
                .setEmail(registrationDTO.getEmail());

        this.userRepository.save(user);

        return true;
    }

    public boolean login(@Valid UserLoginDTO loginDTO) {
        Optional<User> hasUser = this.userRepository.findByUsername(loginDTO.getUsername());

        if (hasUser.isPresent()) {
            this.loggedUser.login(hasUser.get());
            return true;
        }

        return false;
    }

    public boolean isLogged() {
        return this.loggedUser.isLogged();
    }

    public void logout() {
        this.loggedUser.logout();
    }

}
