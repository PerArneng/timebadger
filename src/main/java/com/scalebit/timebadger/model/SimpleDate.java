package com.scalebit.timebadger.model;

import com.scalebit.timebadger.logic.DateUtil;

import java.util.Calendar;
import java.util.Date;

public class SimpleDate {

    private final int year;
    private final int month;
    private final int day;
    private final boolean isRedDay;

    public SimpleDate(Month month, int day) {
        this(month.getYear(), month.getMonth(), day);
    }

    public SimpleDate(int year, int month, int day) {
        assureNrInRange(year, 1980, 3000, "A year must be between 1980-3000 not:" + year);
        assureNrInRange(month, 1, 12, "A month must be between 1-12 not:" + month);
        assureNrInRange(day, 1, 31, "A day must be between 1-31 not:" + day);
        this.year = year;
        this.month = month;
        this.day = day;
        Calendar cal = DateUtil.dateToCalendar(this);
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        this.isRedDay = dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY;
    }

    public boolean isRedDay() {
        return isRedDay;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public static SimpleDate fromDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return fromCalendar(calendar);
    }

    public static SimpleDate fromCalendar(Calendar calendar) {
        return new SimpleDate(calendar.get(Calendar.YEAR),
                              calendar.get(Calendar.MONTH) + 1,
                              calendar.get(Calendar.DAY_OF_MONTH));
    }

    public String toFormattedString() {
        return String.format("%d-%02d-%02d", year, month, day);
    }

    @Override
    public String toString() {
        return "SimpleDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    private void assureNrInRange(int nr, int min, int max, String message) {
           if (nr < min || nr > max) {
               throw new IllegalArgumentException(message);
           }
    }
}
