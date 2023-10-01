package com.api.service;

import com.api.dto.LogDto;
import com.api.entities.Log;

import java.util.Collection;
import java.util.Optional;

public interface LogServiceInterface {

    /**
     * Find all logs
     * @return a collection of logDto
     */
    Collection<LogDto> findAll();

    /**
     * Find one log by ID
     * @return one LogDto
     */
    Optional<LogDto> findById(Long logId);

    /**
     * Find logs for one task by logTaskId
     * @param logTaskId taskId of the task
     * @return a collection of logDto
     */
    Collection<LogDto> findByLogTaskId(Integer logTaskId);

    /**
     * Add n ew log
     * @param logDto
     * @return logDto
     */
    LogDto add(LogDto logDto);

    /**
     * Delete one log by id
     * @param id Long
     * @return true if found and deleted, false if not found
     */
    boolean delete(Long id);
}
