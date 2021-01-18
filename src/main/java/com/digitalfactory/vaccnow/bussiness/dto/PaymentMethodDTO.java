package com.digitalfactory.vaccnow.bussiness.dto;

import javax.persistence.Column;

public class PaymentMethodDTO {

    private long paymentMethodId;
    private String name;

    public long getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(long paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
