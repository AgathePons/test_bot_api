package com.api.service;


import com.api.dto.TaskDto;
import com.api.dto.TaskWithLogDto;

import java.util.Collection;
import java.util.Optional;

public interface TaskServiceInterface {
    /**
     * Find all tasks without associated logs
     * @return collection of tasks dto
     */
    Collection<TaskDto> findAll();

    /**
     * Find all tasks with associated logs
     * @return collection of tasks with logs dto
     */
    Collection<TaskWithLogDto> findAllWithLog();

    /**
     * Find one task by id without associated logs
     * @param id of the task
     * @return optional of a task
     */
    Optional<TaskDto> findById(Long id);

    /**
     * Find one task by id with associated logs
     * @param id of the task
     * @return optional of a task
     */
    Optional<TaskWithLogDto> findByIdWithLog(Long id);

    /**
     * Find one task by taskId without associated logs
     * @param taskId of the task
     * @return optional of a task
     */
    Optional<TaskDto> findByTaskId(Integer taskId);

    /**
     * Find one task by taskId with associated logs
     * @param taskId of the task
     * @return optional of a task
     */
    Optional<TaskWithLogDto> findByTaskIdWithLog(Integer taskId);

    /**
     * Add new task
     * @param taskDto
     * @return TaskDto task completed
     */
    TaskDto add(TaskDto taskDto);

    /**
     * Delete one task by id
     * @param id Long
     * @return true if found and deleted, false if not found
     */
    boolean delete(Long id);

    Optional<TaskDto> update(TaskDto taskDto);
}
