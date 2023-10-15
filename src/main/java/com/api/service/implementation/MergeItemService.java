package com.api.service.implementation;

import com.api.Utils.StreamUtils;
import com.api.dto.MergeItemDto;
import com.api.entities.MergeItem;
import com.api.repository.MergeItemRepo;
import com.api.service.MergeItemServiceInterface;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MergeItemService implements MergeItemServiceInterface {
    @Autowired
    private MergeItemRepo mergeItemRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<MergeItemDto> findAll() {
        return StreamUtils.toStream(mergeItemRepo.findAll())
                .map(mergeItemEntity -> modelMapper.map(mergeItemEntity, MergeItemDto.class))
                .toList();
    }

    @Override
    public Optional<MergeItemDto> findById(Long id) {
        return mergeItemRepo.findById(id).map(mergeItemEntity -> modelMapper.map(mergeItemEntity, MergeItemDto.class));
    }

    public MergeItemDto add(MergeItemDto mergeItemDto) {
        var mergeItemEntity = modelMapper.map(mergeItemDto, MergeItem.class);
        this.mergeItemRepo.save(mergeItemEntity);
        return modelMapper.map(mergeItemEntity, MergeItemDto.class);
    }

    @Override
    public boolean delete(Long id) {
        Optional<MergeItem> mergeItemToDelete = this.mergeItemRepo.findById(id);
        if(mergeItemToDelete.isPresent()) {
            this.mergeItemRepo.delete(mergeItemToDelete.get());
            return true;
        }
        return false;
    }

    @Override
    public Optional<MergeItemDto> update(MergeItemDto mergeItemDto) {
        return this.mergeItemRepo.findById(mergeItemDto.getId())
                .map(mergeItemEntity -> {
                    // update entity object with DTO fields
                    modelMapper.map(mergeItemDto, mergeItemEntity);
                    // save in DB
                    mergeItemRepo.save(mergeItemEntity);
                    // transform entity updated in DTO and return
                    return modelMapper.map(mergeItemEntity, MergeItemDto.class);
                });
    }
}
