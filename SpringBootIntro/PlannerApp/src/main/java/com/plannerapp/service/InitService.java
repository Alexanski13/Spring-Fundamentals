package com.plannerapp.service;

import com.plannerapp.model.entity.Priority;
import com.plannerapp.model.enums.PriorityName;
import com.plannerapp.repo.PriorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class InitService {

    private final PriorityRepository priorityRepository;

    @Autowired
    public InitService(PriorityRepository priorityRepository) {
        this.priorityRepository = priorityRepository;
    }

    @PostConstruct
    private void postConstruct() {
        if (this.priorityRepository.count() == 0) {
            this.priorityRepository.saveAllAndFlush(Arrays.stream(PriorityName.values())
                    .map(Priority::new)
                    .collect(Collectors.toList()));
        }
    }
}
