package com.example.task_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.task_management_system.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> { 
}
