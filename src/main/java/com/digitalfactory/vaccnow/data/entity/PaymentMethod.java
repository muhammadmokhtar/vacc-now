package com.digitalfactory.vaccnow.data.entity;

import javax.persistence.*;

@Entity(name = "PAYMENT_METHOD")
public class PaymentMethod {

    @Id
    @Column(name="PAYMENT_METHOD_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long paymentMethodId;
    @Column
    private String name;

    public PaymentMethod() {
    }

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
