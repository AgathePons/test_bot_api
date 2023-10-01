package com.api.controller;

import com.api.dto.LogDto;
import com.api.error.NoDataFoundError;
import com.api.service.implementation.LogService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/log")
public class LogController {

    static final String ITEM_TYPE = "log";

    @Autowired
    private LogService logService;

    /**
     * Get all logs
     * @return Iterable<LogDto>
     */
    @GetMapping
    public Iterable<LogDto> getAll() {
        return logService.findAll();
    }

    /**
     * Get 1 log
     * @param id of the log (Long)
     * @return logDto or NoDataFoundError
     */
    @GetMapping("/{logId}")
    public  LogDto getByLogId(@PathVariable("logId") Long id) {
        Optional<LogDto> optLog = logService.findById(id);
        if (optLog.isPresent()) {
            return optLog.get();
        } else {
            throw NoDataFoundError.withId(ITEM_TYPE, id);
        }
    }

    /**
     * Get logs by logTaskId
     * @param logTaskId of the log
     * @return Iterable<LogDto> or NoDataFoundError
     */
    @GetMapping("/task/{logTaskId}")
    public  Iterable<LogDto> getByLogTaskId(@PathVariable("logTaskId") Integer logTaskId) {
        var logDtoList = logService.findByLogTaskId(logTaskId);
        if (!logDtoList.isEmpty()) {
            return logDtoList;
        } else {
            throw NoDataFoundError.withId(ITEM_TYPE, logTaskId);
        }
    }

    /**
     * Add new log to a task
     * @param logDto to create
     * @return logDto created with id
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LogDto add(@Valid @RequestBody LogDto logDto) { return logService.add(logDto); }

    /**
     * Delete a log
     * @param id of the log (Long)
     */
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") Long id) {
        if (!logService.delete(id)) {
            throw NoDataFoundError.withId(ITEM_TYPE, id);
        }
    }

    /**
     * Update a log
     * @param logDto to update
     * @return LogDto updated or NoDataFoundError
     */
    @PutMapping
    public LogDto update(@Valid @RequestBody LogDto logDto) {
        return logService.update(logDto)
                .orElseThrow(() -> NoDataFoundError.withId(ITEM_TYPE, logDto.getId()));
    }
}
