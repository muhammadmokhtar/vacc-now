package com.digitalfactory.vaccnow.data.repository;

import com.digitalfactory.vaccnow.data.entity.Branch;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BranchRepository extends CrudRepository<Branch, Long> {

    @Query("select b.name from Branch b")
    List<String> getAllBranchesNames();

}
