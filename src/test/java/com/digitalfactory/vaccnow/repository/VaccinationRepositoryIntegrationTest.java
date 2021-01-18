package com.digitalfactory.vaccnow.repository;

import com.digitalfactory.vaccnow.data.entity.Vaccination;
import com.digitalfactory.vaccnow.data.repository.VaccinationRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class VaccinationRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private VaccinationRepository vaccinationRepository;

    @Test
    public void whenFindByExistingTimeScheduleId_thenReturnVaccinationOfSchedule() {
        // given
        Vaccination vaccination = new Vaccination(2, 3, 1);
        entityManager.persistAndFlush(vaccination);
        // when
        Vaccination fromDb = vaccinationRepository.findVaccinationByTimeScheduleId(vaccination.getTimeScheduleId());
        // then
        assertThat(fromDb.getTimeScheduleId()).isEqualTo(fromDb.getTimeScheduleId());
    }

    @Test
    public void whenFindByNonExistingTimeScheduleId_thenReturnNull() {
        // given
        Vaccination vaccination = new Vaccination(2, 3, 1);
        entityManager.persistAndFlush(vaccination);
        // when
        Vaccination fromDb = vaccinationRepository.findVaccinationByTimeScheduleId(4);
        // then
        assertThat(fromDb).isEqualTo(null);
    }
}
