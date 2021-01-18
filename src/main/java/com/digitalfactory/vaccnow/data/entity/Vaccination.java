package com.digitalfactory.vaccnow.data.entity;

import javax.persistence.*;

@Entity
public class Vaccination {

    @Id
    @Column(name="VACCINATION_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long vaccinationId;
    @Column
    private Boolean confirmed;
    @Column(unique = true)
    private long timeScheduleId;
    @Column
    private long clientId;
    @Column
    private long paymentMethodId;

    public Vaccination() {
    }

    public Vaccination(long timeScheduleId, long clientId, long paymentMethodId) {
        this.timeScheduleId = timeScheduleId;
        this.clientId = clientId;
        this.paymentMethodId = paymentMethodId;
    }

    public long getVaccinationId() {
        return vaccinationId;
    }

    public void setVaccinationId(long vaccinationId) {
        this.vaccinationId = vaccinationId;
    }

    public Boolean getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Boolean confirmed) {
        this.confirmed = confirmed;
    }

    public long getTimeScheduleId() {
        return timeScheduleId;
    }

    public void setTimeScheduleId(long timeScheduleId) {
        this.timeScheduleId = timeScheduleId;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public long getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(long paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }
}
