package com.scalebit.timebadger.model;


import java.util.List;

public class WorkMonth {

    private final List<WorkDay> days;
    private final Month month;

    public WorkMonth(Month month, List<WorkDay> workDays) {
        this.month = month;
        this.days = workDays;

    }

    public List<WorkDay> getDays() {
        return days;
    }

    public Month getMonth() {
        return this.month;
    }
}
