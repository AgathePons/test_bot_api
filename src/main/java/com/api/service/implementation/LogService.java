package com.api.service.implementation;

import com.api.Utils.StreamUtils;
import com.api.dto.LogDto;
import com.api.entities.Log;
import com.api.repository.LogRepo;
import com.api.service.LogServiceInterface;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LogService implements LogServiceInterface {

    @Autowired
    private LogRepo logRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<LogDto> findAll() {
        return StreamUtils.toStream(logRepo.findAll())
                .map(logEntity -> modelMapper.map(logEntity, LogDto.class))
                .toList();
    }

    @Override
    public Optional<LogDto> findById(Long logId) {
        return this.logRepo.findById(logId)
                .map(logEntity -> modelMapper.map(logEntity, LogDto.class));
    }

    @Override
    public List<LogDto> findByLogTaskId(Integer logTaskId) {
        return StreamUtils.toStream(logRepo.findByLogTaskId(logTaskId))
                .map(logEntity -> modelMapper.map(logEntity, LogDto.class))
                .toList();
    }

    @Override
    public LogDto add(LogDto logDto) {
        var logEntity = modelMapper.map(logDto, Log.class);
        this.logRepo.save(logEntity);
        return modelMapper.map(logEntity, LogDto.class);
    }
}
