package com.api.repository;

import com.api.entities.Log;
import org.springframework.data.repository.CrudRepository;

public interface LogRepo extends CrudRepository<Log, Long> {
}
