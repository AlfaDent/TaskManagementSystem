package com.example.taskmanagementsystem.repositories;

import com.example.taskmanagementsystem.models.TaskPriority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriorityRepository extends JpaRepository<TaskPriority, Long> {
}
