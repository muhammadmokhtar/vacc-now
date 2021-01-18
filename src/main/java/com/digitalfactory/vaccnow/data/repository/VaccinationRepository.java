package com.digitalfactory.vaccnow.data.repository;

import com.digitalfactory.vaccnow.data.entity.TimeSchedule;
import com.digitalfactory.vaccnow.data.entity.Vaccination;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VaccinationRepository extends CrudRepository<Vaccination, Long> {

    Vaccination findVaccinationByTimeScheduleId(long timeScheduleId);

    @Modifying
    @Query("update Vaccination vcc set vcc.confirmed = 1 where vcc.vaccinationId = :vaccinationId")
    public void flagVaccinationConfirmed(@Param(value = "vaccinationId") long vaccinationId);
}
