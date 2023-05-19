package com.api.controller;

import com.api.dto.LogDto;
import com.api.service.implementation.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log")
public class LogController {

    @Autowired
    private LogService logService;

    @GetMapping
    public Iterable<LogDto> getAll() {
        System.out.println("LogService >> getAll");
        return this.logService.findAll();
    }
}
