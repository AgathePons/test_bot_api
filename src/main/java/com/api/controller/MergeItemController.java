package com.api.controller;

import com.api.dto.MergeItemDto;
import com.api.error.NoDataFoundError;
import com.api.service.implementation.MergeItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/mergeItem")
public class MergeItemController {
    static final String ITEM_TYPE = "mergeItem";

    @Autowired
    private MergeItemService mergeItemService;

    /**
     * Get all mergeItem
     * @return Iterable<MergeItemDto>
     */
    @GetMapping
    public Iterable<MergeItemDto> getAll() {
        return mergeItemService.findAll();
    }

    /**
     * Get one mergeItem by id
     * @param id Long of the mergeItem
     * @return MergeItemDto or NoDataFoundError
     */
    @GetMapping("{id}")
    public MergeItemDto getById(@PathVariable("id") Long id) {
        Optional<MergeItemDto> optMergeItem = mergeItemService.findById(id);
        if (optMergeItem.isPresent()) {
            return optMergeItem.get();
        } else {
            throw NoDataFoundError.withId(ITEM_TYPE, id);
        }
    }

    /**
     * Add new mergeItem
     * @param mergeItemDto to create
     * @return mergeItemDto created with id
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MergeItemDto add(@Valid @RequestBody MergeItemDto mergeItemDto) {
        return mergeItemService.add(mergeItemDto);
    }

    /**
     * Delete a mergeItem
     * @param id Long of the mergeItem
     */
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") Long id) {
        if (!mergeItemService.delete(id)) {
            throw NoDataFoundError.withId(ITEM_TYPE, id);
        }
    }

    /**
     * Update a mergeItem
     * @param mergeItemDto to update
     * @return mergeItemDto updated or NoDataFoundError
     */
    @PutMapping
    public MergeItemDto update(@Valid @RequestBody MergeItemDto mergeItemDto) {
        return mergeItemService.update(mergeItemDto)
                .orElseThrow(() -> NoDataFoundError.withId(ITEM_TYPE, mergeItemDto.getId()));
    }
}
