package com.scalebit.timebadger.model;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Month {

    private final SimpleDate date;

    private static final Map<Integer, String> MONTH_NAMES = new HashMap<Integer, String>() {{
        Calendar cal = Calendar.getInstance();
        for (int i=0;i<12;i++) {
            cal.set(2012, i, 1);
            put(i + 1, cal.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.US));
        }
    }};

    public Month(int year, int month) {
        this.date = new SimpleDate(year, month, 1);
    }

    public int getYear() {
        return this.date.getYear();
    }

    public int getMonth() {
        return this.date.getMonth();
    }

    public String getShortName() {
        return MONTH_NAMES.get(date.getMonth());
    }


    @Override
    public String toString() {
        return "Month{" +
                "date=" + date +
                '}';
    }
}
