package com.api.repository;

import com.api.entities.Log;
import com.api.entities.MergeItem;
import org.springframework.data.repository.CrudRepository;

public interface MergeItemRepo extends CrudRepository<MergeItem, Long> {
}
