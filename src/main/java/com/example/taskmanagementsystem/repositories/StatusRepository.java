package com.example.taskmanagementsystem.repositories;

import com.example.taskmanagementsystem.models.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<TaskStatus, Long> {
}
