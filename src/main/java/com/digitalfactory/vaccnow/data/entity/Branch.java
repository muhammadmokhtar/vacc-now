package com.digitalfactory.vaccnow.data.entity;

import javax.persistence.*;

@Entity
public class Branch {

    @Id
    @Column(name="BRANCH_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long branchId;
    @Column
    private String name;
    @Column(name = "AVAILABLE_VACCINES")
    private long availableVaccines;

    public Branch() {
    }

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
