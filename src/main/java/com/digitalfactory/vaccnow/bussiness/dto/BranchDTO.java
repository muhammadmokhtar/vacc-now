package com.digitalfactory.vaccnow.bussiness.dto;

import javax.persistence.Column;

public class BranchDTO {

    private long branchId;
    private String name;
    private long availableVaccines;

    public long getBranchId() {
        return branchId;
    }

    public void setBranchId(long branchId) {
        this.branchId = branchId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getAvailableVaccines() {
        return availableVaccines;
    }

    public void setAvailableVaccines(long availableVaccines) {
        this.availableVaccines = availableVaccines;
    }
}
