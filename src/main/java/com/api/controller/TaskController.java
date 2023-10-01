package com.api.controller;

import com.api.dto.TaskDto;
import com.api.dto.TaskWithLogDto;
import com.api.error.NoDataFoundError;
import com.api.service.implementation.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/task")
public class TaskController {

    static final String ITEM_TYPE = "task";
    @Autowired
    private TaskService taskService;

    /**
     * Get all tasks with logs
     * @return Iterable<TaskWithLogDto>
     */
    @GetMapping
    public Iterable<TaskWithLogDto> getAllWithLog() {
        return taskService.findAllWithLog();
    }

    /**
     * Get 1 task with logs
     * @param id of the Task (Long)
     * @return TaskWithLogDto or NoDataFoundError
     */
    @GetMapping("{id}")
    public TaskWithLogDto getByIdWithLog(@PathVariable("id") Long id) {
        Optional<TaskWithLogDto> optTask = taskService.findByIdWithLog(id);
        if (optTask.isPresent()) {
            return optTask.get();
        } else {
            throw NoDataFoundError.withId(ITEM_TYPE, id);
        }
    }

    /**
     * Get all tasks without logs
     * @return Iterable<TaskWithLogDto>
     */
    @GetMapping("/noLog")
    public Iterable<TaskDto> getAll() {
        return taskService.findAll();
    }

    /**
     * Get 1 task with logs
     * @param id of the Task (Long)
     * @return TaskDto or NoDataFoundError
     */
    @GetMapping("/noLog/{id}")
    public TaskDto getById(@PathVariable("id") Long id) {
        Optional<TaskDto> optTask = taskService.findById(id);
        if (optTask.isPresent()) {
            return optTask.get();
        } else {
            throw NoDataFoundError.withId(ITEM_TYPE, id);
        }
    }

    /**
     * Add new task
     * @param taskDto to create
     * @return TaskDto created with id
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TaskDto add(@Valid @RequestBody TaskDto taskDto) {
        return taskService.add(taskDto);
    }

    /**
     * Delete a task
     * @param id of the Task (Long)
     */
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") Long id) {
        if (!taskService.delete(id)) {
            throw NoDataFoundError.withId(ITEM_TYPE, id);
        }
    }

    /**
     * Update a task
     * @param taskDto to update
     * @return TaskDto updated or NoDataFoundError
     */
    @PutMapping
    public TaskDto update(@Valid @RequestBody TaskDto taskDto) {
        return taskService.update(taskDto)
                .orElseThrow(() -> NoDataFoundError.withId(ITEM_TYPE, taskDto.getId()));
    }
}
