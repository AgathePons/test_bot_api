package com.api.repository;

import com.api.entities.Log;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LogRepo extends CrudRepository<Log, Long> {
    @Query(
            value = "SELECT * FROM log WHERE log_task_id = :logTaskId ORDER BY log_order",
            nativeQuery = true
    )
    List<Log> findByLogTaskId(Integer logTaskId);
}
