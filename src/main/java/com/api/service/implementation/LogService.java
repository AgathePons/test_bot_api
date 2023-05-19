package com.api.service.implementation;

import com.api.Utils.StreamUtils;
import com.api.dto.LogDto;
import com.api.repository.LogRepo;
import com.api.service.LogServiceInterface;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class LogService implements LogServiceInterface {

    @Autowired
    private LogRepo logRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<LogDto> findAll() {
        return StreamUtils.toStream(this.logRepo.findAll())
                .map(logEntity -> modelMapper.map(logEntity, LogDto.class))
                .toList();
    }

    @Override
    public List<LogDto> findByLogTaskId(Integer logTaskId) {
        return Collections.emptyList();
    }
}
