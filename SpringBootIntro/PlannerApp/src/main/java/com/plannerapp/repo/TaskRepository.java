package com.plannerapp.repo;

import com.plannerapp.model.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    Optional<Task> findAllByUserId(Long id);

    Optional<Task> findAllByUserIdNull();
}
