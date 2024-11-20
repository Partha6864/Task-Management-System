package com.example.task_management_system.controller;

import com.example.task_management_system.dto.TaskDto;
import com.example.task_management_system.model.Task;
import com.example.task_management_system.service.TaskService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody TaskDto taskDto) {
        try {
            return ResponseEntity.ok(taskService.createTask(taskDto));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTaskById(@PathVariable long id) {
        try {
            return ResponseEntity.ok(taskService.getTaskById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTask(@PathVariable long id, @RequestBody TaskDto taskDto) {
        try {
            return ResponseEntity.ok(taskService.updateTask(id, taskDto));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable long id) {
        try {
            taskService.deleteTask(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping("/{id}/complete")
    public ResponseEntity<?> markTaskAsComplete(@PathVariable long id) {
        try {
            return ResponseEntity.ok(taskService.markTaskAsComplete(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
