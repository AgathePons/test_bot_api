package com.api.controller;

import com.api.dto.LogDto;
import com.api.error.NoDataFoundError;
import com.api.service.implementation.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/log")
public class LogController {

    static final String ITEM_TYPE = "log";

    @Autowired
    private LogService logService;

    @GetMapping
    public Iterable<LogDto> getAll() {
        return logService.findAll();
    }

    @GetMapping("/{logId}")
    public  LogDto getByLogId(@PathVariable("logId") Long logId) {
        Optional<LogDto> optLog = logService.findById(logId);
        if (optLog.isPresent()) {
            return optLog.get();
        } else {
            throw NoDataFoundError.withId(ITEM_TYPE, logId);
        }
    }

    @GetMapping("/task/{logTaskId}")
    public  Iterable<LogDto> getByLogTaskId(@PathVariable("logTaskId") Integer logTaskId) {
        return logService.findByLogTaskId(logTaskId);
    }
}
