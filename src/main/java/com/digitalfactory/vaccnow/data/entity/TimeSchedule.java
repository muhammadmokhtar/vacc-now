package com.digitalfactory.vaccnow.data.entity;

import javax.persistence.*;

@Entity()
public class TimeSchedule {

    @Id
    @Column(name="TIME_SCHEDULE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long timeScheduleId;
    @Column
    private long start;
    @Column
    private long end;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BRANCH_ID")
    private Branch branch;

    public TimeSchedule() {
    }

    public long getTimeScheduleId() {
        return timeScheduleId;
    }

    public void setTimeScheduleId(long timeScheduleId) {
        this.timeScheduleId = timeScheduleId;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getEnd() {
        return end;
    }

    public void setEnd(long end) {
        this.end = end;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }
}
