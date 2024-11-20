package com.example.task_management_system.service;

import com.example.task_management_system.dto.TaskDto;
import com.example.task_management_system.model.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAllTasks();
    Task getTaskById(long id);
    Task createTask(TaskDto taskDto);
    Task updateTask(long id, TaskDto taskDto);
    void deleteTask(long id);
    Task markTaskAsComplete(long id);
}
