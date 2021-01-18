package com.digitalfactory.vaccnow.bussiness.service;

import com.digitalfactory.vaccnow.bussiness.dto.TimeScheduleDTO;
import com.digitalfactory.vaccnow.data.entity.TimeSchedule;
import com.digitalfactory.vaccnow.data.repository.TimeScheduleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TimeScheduleService {

    private ModelMapper modelMapper;
    private TimeScheduleRepository timeScheduleRepository;

    @Autowired
    public TimeScheduleService(TimeScheduleRepository timeScheduleRepository, ModelMapper modelMapper) {
        this.timeScheduleRepository = timeScheduleRepository;
        this.modelMapper = modelMapper;
    }

    public List<TimeScheduleDTO> getAvailableTimeForBranch(long branchId,
                                                           Optional<Long> from, Optional<Long> to) {
        List<TimeScheduleDTO> timeScheduleDTOs = new ArrayList<>();
        List<TimeSchedule> timeScheduleEntities = timeScheduleRepository.getAvailableTimeForBranch(branchId);
        timeScheduleDTOs = timeScheduleEntities.stream().map(entity -> modelMapper.map(entity, TimeScheduleDTO.class)).
                collect(Collectors.toList());
        if (from.isPresent()) {
            timeScheduleDTOs = timeScheduleDTOs.stream().filter(dto -> new Date(dto.getStart()).
                    after(new Date(from.get()))).collect(Collectors.toList());
        }
        if (to.isPresent()) {
            timeScheduleDTOs = timeScheduleDTOs.stream().filter(dto -> new Date(dto.getEnd()).
                    before(new Date(to.get()))).collect(Collectors.toList());
        }
        return timeScheduleDTOs;
    }
}
