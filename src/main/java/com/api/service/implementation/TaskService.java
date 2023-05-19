package com.api.service.implementation;

import com.api.dto.TaskDto;
import com.api.dto.TaskWithLogDto;
import com.api.repository.LogRepo;
import com.api.repository.TaskRepo;
import com.api.service.TaskServiceInterface;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService implements TaskServiceInterface {

    @Autowired
    private TaskRepo taskRepo;

    @Autowired
    private LogRepo logRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<TaskDto> findAll() {
        return null;
    }

    @Override
    public Collection<TaskWithLogDto> findAllWithLog() {
        return null;
    }

    @Override
    public Optional<TaskDto> findById(Long id) {
        return this.taskRepo.findById(id).map(taskEntity -> modelMapper.map(taskEntity, TaskDto.class));
    }

    @Override
    public Optional<TaskWithLogDto> findByIdWithLog(Long id) {
        return this.taskRepo.findById(id).map(taskEntity -> modelMapper.map(taskEntity, TaskWithLogDto.class));
    }

    @Override
    public Optional<TaskDto> findByTaskId(Integer taskId) {

        return Optional.empty();
    }

    @Override
    public Optional<TaskWithLogDto> findByTaskIdWithLog(Long taskId) {
        return Optional.empty();
    }
}
