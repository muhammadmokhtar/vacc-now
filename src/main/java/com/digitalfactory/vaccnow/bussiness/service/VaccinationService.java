package com.digitalfactory.vaccnow.bussiness.service;

import com.digitalfactory.vaccnow.bussiness.dto.VaccinationDTO;
import com.digitalfactory.vaccnow.data.entity.Client;
import com.digitalfactory.vaccnow.data.entity.PaymentMethod;
import com.digitalfactory.vaccnow.data.entity.TimeSchedule;
import com.digitalfactory.vaccnow.data.entity.Vaccination;
import com.digitalfactory.vaccnow.data.repository.TimeScheduleRepository;
import com.digitalfactory.vaccnow.data.repository.VaccinationRepository;
import com.digitalfactory.vaccnow.exception.TimeScheduleNotAvailableException;
import com.digitalfactory.vaccnow.exception.TimeScheduleNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Scope("singleton")
@Transactional
public class VaccinationService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private VaccinationRepository vaccinationRepository;

    public synchronized VaccinationDTO saveClientVaccinationSchedule(VaccinationDTO vaccinationDTO) {
        // check if schedule_id exists at vaccination table then
        // throw custom exception TimeScheduleNotAvailable
        Vaccination vaccination = null;
        vaccination  = vaccinationRepository.findVaccinationByTimeScheduleId(vaccinationDTO.getTimeScheduleId());
        if (vaccination != null) {
            throw new TimeScheduleNotAvailableException("requested vaccination schedule is not available anymore");
        }
        vaccination = this.vaccinationRepository.save(modelMapper.map(vaccinationDTO, Vaccination.class));
        return modelMapper.map(vaccination, VaccinationDTO.class);
        // here we could send confirmation e-mial with vaccinatioId for client to confirm
        // using SMTP for example
    }

    public void confirmVaccination(long vaccinationId) {
        if (this.vaccinationRepository.findById(vaccinationId).isPresent()) {
            this.vaccinationRepository.flagVaccinationConfirmed(vaccinationId);
        } else {
            throw new TimeScheduleNotFoundException("vaccination not found and cannot be confirmed");
        }
    }

}
