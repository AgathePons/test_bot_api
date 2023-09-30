package com.api.repository;

import com.api.dto.TaskDto;
import com.api.entities.Task;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TaskRepo extends CrudRepository<Task, Long> {
    @Query(
            value = "SELECT * From task WHERE task_id = :taskId",
            nativeQuery = true
    )
    Optional<TaskDto> findByTaskId(Integer taskId);
}
