package com.digitalfactory.vaccnow.data.repository;

import com.digitalfactory.vaccnow.data.entity.PaymentMethod;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentMethodRepository extends CrudRepository<PaymentMethod, Long> {

}
