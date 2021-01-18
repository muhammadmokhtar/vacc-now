package com.digitalfactory.vaccnow.bussiness.dto;


public class TimeScheduleDTO {
    private long timeScheduleId;
    private long start;
    private long end;

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
}
