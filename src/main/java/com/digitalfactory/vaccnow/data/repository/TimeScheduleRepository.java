package com.digitalfactory.vaccnow.data.repository;

import com.digitalfactory.vaccnow.data.entity.TimeSchedule;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeScheduleRepository extends CrudRepository<TimeSchedule, Long> {

    @Query("from TimeSchedule ts where ts.branch.id = :branchId")
    List<TimeSchedule> getAvailableTimeForBranch(@Param(value = "branchId") long branchId);

}
