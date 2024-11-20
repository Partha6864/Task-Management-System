package com.example.task_management_system.dto;

import java.util.Date;

import lombok.Data;

@Data
public class TaskDto {
    private String title;

    private String description;

    private Date dueDate;
}