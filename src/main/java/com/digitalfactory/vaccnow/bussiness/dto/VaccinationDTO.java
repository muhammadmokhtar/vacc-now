package com.digitalfactory.vaccnow.bussiness.dto;

import com.digitalfactory.vaccnow.data.entity.Client;

public class VaccinationDTO {

    private long vaccinationId;
    private Boolean confirmed;
    private long timeScheduleId;
    private long clientId;
    private long paymentMethodID;

    public VaccinationDTO() {
    }

    public VaccinationDTO(long timeScheduleId, long clientId, long paymentMethodID) {
        this.timeScheduleId = timeScheduleId;
        this.clientId = clientId;
        this.paymentMethodID = paymentMethodID;
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

    public long getPaymentMethodID() {
        return paymentMethodID;
    }

    public void setPaymentMethodID(long paymentMethodID) {
        this.paymentMethodID = paymentMethodID;
    }
}
