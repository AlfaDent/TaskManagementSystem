package com.example.taskmanagementsystem.repositories;


import com.example.taskmanagementsystem.models.task.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
