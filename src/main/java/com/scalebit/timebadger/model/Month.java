package com.scalebit.timebadger.model;

import java.util.Calendar;

public class Month {

    private final SimpleDate date;

    public Month(int year, int month) {
        this.date = new SimpleDate(year, month, 1);
    }

    public int getYear() {
        return this.date.getYear();
    }

    public int getMonth() {
        return this.date.getMonth();
    }

}
