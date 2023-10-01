package com.api.service;

import com.api.dto.LogDto;
import com.api.entities.Log;

import java.util.Collection;
import java.util.Optional;

public interface LogServiceInterface {

    /**
     * Find all logs
     * @return Collection<LogDto>
     */
    Collection<LogDto> findAll();

    /**
     * Find one log by ID
     * @return Optional<LogDto>
     */
    Optional<LogDto> findById(Long logId);

    /**
     * Find logs for one task by logTaskId
     * @param logTaskId taskId of the task
     * @return Collection<LogDto>
     */
    Collection<LogDto> findByLogTaskId(Integer logTaskId);

    /**
     * Add n ew log
     * @param logDto
     * @return LogDto completed
     */
    LogDto add(LogDto logDto);

    /**
     * Delete one log by id
     * @param id Long
     * @return true if found and deleted, false if not found
     */
    boolean delete(Long id);

    /**
     * Update a log
     * @param logDto
     * @return Optional<LogDto>
     */
    Optional<LogDto> update(LogDto logDto);
}
