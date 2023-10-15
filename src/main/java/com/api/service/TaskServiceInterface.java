package com.api.service;


import com.api.dto.TaskDto;
import com.api.dto.TaskWithLogDto;

import java.util.Collection;
import java.util.Optional;

public interface TaskServiceInterface {
    /**
     * Find all tasks without associated logs
     * @return Collection<TaskDto>
     */
    Collection<TaskDto> findAll();

    /**
     * Find all tasks with associated logs
     * @return collection of tasks with logs dto
     */
    Collection<TaskWithLogDto> findAllWithLog();

    /**
     * Find one task by id without associated logs
     * @param id Long of the task
     * @return Optional<TaskDto>
     */
    Optional<TaskDto> findById(Long id);

    /**
     * Find one task by id with associated logs
     * @param id Long of the task
     * @return Optional<TaskDto>
     */
    Optional<TaskWithLogDto> findByIdWithLog(Long id);

    /**
     * Find one task by taskId without associated logs
     * @param taskId Integer of the task
     * @return Optional<TaskDto>
     */
    Optional<TaskDto> findByTaskId(Integer taskId);

    /**
     * Find one task by taskId with associated logs
     * @param taskId Integer of the task
     * @return Optional<TaskDto>
     */
    Optional<TaskWithLogDto> findByTaskIdWithLog(Integer taskId);

    /**
     * Add new task
     * @param taskDto
     * @return TaskDto completed
     */
    TaskDto add(TaskDto taskDto);

    /**
     * Delete one task by id
     * @param id Long
     * @return true if found and deleted, false if not found
     */
    boolean delete(Long id);

    /**
     * Update a task
     * @param taskDto
     * @return Optional<TaskDto>
     */
    Optional<TaskDto> update(TaskDto taskDto);
}
