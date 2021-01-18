package com.digitalfactory.vaccnow.bussiness.service;

import com.digitalfactory.vaccnow.bussiness.dto.PaymentMethodDTO;
import com.digitalfactory.vaccnow.data.entity.PaymentMethod;
import com.digitalfactory.vaccnow.data.repository.PaymentMethodRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class PaymentMethodService {

    private ModelMapper modelMapper;
    private PaymentMethodRepository paymentMethodRepository;

    @Autowired
    public PaymentMethodService(PaymentMethodRepository paymentMethodRepository, ModelMapper modelMapper) {
        this.paymentMethodRepository = paymentMethodRepository;
        this.modelMapper = modelMapper;
    }

    public List<PaymentMethodDTO> getPaymentMethods() {
        List<PaymentMethodDTO> paymentMethodDTOS = new ArrayList<>();
        Iterator<PaymentMethod> iterator = paymentMethodRepository.findAll().iterator();
        while (iterator.hasNext()) {
            paymentMethodDTOS.add(modelMapper.map(iterator.next(), PaymentMethodDTO.class));
        }
        return paymentMethodDTOS;
    }

}
