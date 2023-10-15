package com.api.service;

import com.api.dto.MergeItemDto;

import java.util.Collection;
import java.util.Optional;

public interface MergeItemServiceInterface {
    /**
     * Find all mergeItem
     * @return Collection<MergeItemDto>
     */
    Collection<MergeItemDto> findAll();

    /**
     * Find one mergeItem by id
     * @param id Long of the mergeItem
     * @return Optional<MergeItemDto>
     */
    Optional<MergeItemDto> findById(Long id);

    /**
     * Add new mergeItem
     * @param mergeItemDto
     * @return MergeItemDto completed
     */
    MergeItemDto add(MergeItemDto mergeItemDto);

    /**
     * Delete one mergeItem by id
     * @param id Long
     * @return true if found and deleted, false if not found
     */
    boolean delete(Long id);

    /**
     * Update a mergeItem
     * @param mergeItemDto
     * @return Optional<MergeItemDto>
     */
    Optional<MergeItemDto> update(MergeItemDto mergeItemDto);
}
