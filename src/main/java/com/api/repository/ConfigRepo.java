package com.api.repository;

import com.api.entities.Config;
import org.springframework.data.repository.CrudRepository;

public interface ConfigRepo extends CrudRepository<Config, Long> {
}
