package com.example.task_management_system.service.impl;

import com.example.task_management_system.dto.TaskDto;
import com.example.task_management_system.exception.ResourceNotFoundException;
import com.example.task_management_system.model.Status;
import com.example.task_management_system.model.Task;
import com.example.task_management_system.repository.TaskRepository;
import com.example.task_management_system.service.TaskService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createTask(TaskDto taskDto) {
        Task task = new Task();
        task.setTitle(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());
        task.setDueDate(taskDto.getDueDate());
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id " + id));
    }

    @Override
    public Task updateTask(long id, TaskDto taskDto) {
        Task task = getTaskById(id);

        if (task != null) {
            task.setTitle(taskDto.getTitle());
            task.setDescription(taskDto.getDescription());
            task.setDueDate(taskDto.getDueDate());
            return taskRepository.save(task);
        } else {
            throw new ResourceNotFoundException("Task not found with id " + id);
        }
    }

    @Override
    public void deleteTask(long id) {
        Task task = getTaskById(id);

        if (task != null) {
            taskRepository.delete(task);
        } else {
            throw new ResourceNotFoundException("Task not found with id " + id);
        }
    }

    @Override
    public Task markTaskAsComplete(long id) {
        Task task = getTaskById(id);

        if (task.getStatus() == Status.COMPLETED) {
            throw new RuntimeException("Task is already marked as completed.");
        }

        task.setStatus(Status.COMPLETED);
        return taskRepository.save(task);
    }
}
