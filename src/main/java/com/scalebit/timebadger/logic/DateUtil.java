package com.scalebit.timebadger.logic;


import com.scalebit.timebadger.model.Month;
import com.scalebit.timebadger.model.SimpleDate;

import java.util.Calendar;

public class DateUtil {

    public static Calendar monthToCalendar(Month month) {
        return dateToCalendar(new SimpleDate(month.getYear(), month.getMonth(), 1));
    }

    public static Calendar dateToCalendar(SimpleDate date) {
        Calendar cal = Calendar.getInstance();
        cal.set(date.getYear(), date.getMonth() - 1, date.getDay());
        return cal;
    }
    public static String minutesToHourMinuteString(int minutes) {
        int hourPart = (int)Math.floor(minutes/60);
        int minutePart = minutes - hourPart * 60;
        return String.format("%02d:%02d", hourPart, minutePart);
    }

    public static String minutesToDecimalHours(int minutes) {
        return String.format("%.2f", (double)minutes / 60);
    }
}
