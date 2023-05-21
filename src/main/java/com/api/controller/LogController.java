package com.api.controller;

import com.api.dto.LogDto;
import com.api.service.implementation.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log")
public class LogController {

    @Autowired
    private LogService logService;

    @GetMapping
    public Iterable<LogDto> getAll() {
        return logService.findAll();
    }

    @GetMapping("{logTaskId}")
    public  Iterable<LogDto> getByLogTaskId(@PathVariable("logTaskId") Integer logTaskId) {
        return logService.findByLogTaskId(logTaskId);
    }
}
