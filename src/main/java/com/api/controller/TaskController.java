package com.api.controller;

import com.api.dto.TaskDto;
import com.api.dto.TaskWithLogDto;
import com.api.service.implementation.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public Iterable<TaskWithLogDto> getAll() {
        System.out.println("TaskController getAll()");
        return taskService.findAllWithLog();
    }

    @GetMapping("{taskId}")
    public Optional<TaskWithLogDto> getByIdWithLog(@PathVariable("taskId") Long taskId) {
        System.out.println("TaskController getByTaskIdWithLog() for taskId " + taskId);
        return taskService.findByIdWithLog(taskId);
    }
}
