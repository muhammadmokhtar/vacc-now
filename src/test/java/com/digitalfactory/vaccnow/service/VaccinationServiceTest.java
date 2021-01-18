package com.digitalfactory.vaccnow.service;

import com.digitalfactory.vaccnow.bussiness.dto.VaccinationDTO;
import com.digitalfactory.vaccnow.bussiness.service.VaccinationService;
import com.digitalfactory.vaccnow.data.entity.Vaccination;
import com.digitalfactory.vaccnow.data.repository.VaccinationRepository;
import com.digitalfactory.vaccnow.exception.TimeScheduleNotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringRunner.class)
public class VaccinationServiceTest {

    @TestConfiguration
    static class VaccinationServiceTestContextConfiguration {
        @Bean
        public VaccinationService vaccinationService() {
            return new VaccinationService();
        }

        @Bean
        public ModelMapper modelMapper() {
            return new ModelMapper();
        }
    }
    @Autowired
    private VaccinationService vaccinationService;
    @MockBean
    private VaccinationRepository vaccinationRepository;

    @Before
    public void setup() {
        Vaccination vaccination213 = new Vaccination(2,1,3);
        Vaccination vaccination431 = new Vaccination(4,3,1);

        Mockito.when(vaccinationRepository.save(any(Vaccination.class))).thenReturn(vaccination431);
        Mockito.when(vaccinationRepository.findVaccinationByTimeScheduleId(2)).thenReturn(vaccination213);
    }

    @Test
    public void shouldSaveVaccinationSuccessfully_WhenScheduleIsAvailable() {
        // given
        VaccinationDTO vaccinationDTO431 = new VaccinationDTO(4, 3, 1);
        // when
        VaccinationDTO saved  = vaccinationService.saveClientVaccinationSchedule(vaccinationDTO431);
        // then
        assertThat(saved.getTimeScheduleId()).isEqualTo(vaccinationDTO431.getTimeScheduleId());
    }

}
