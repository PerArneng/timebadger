package com.scalebit.timebadger.logic;

import com.scalebit.timebadger.model.Month;
import com.scalebit.timebadger.model.SimpleDate;
import com.scalebit.timebadger.model.WorkDay;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class WorkDayFactory {

    public static List<WorkDay> create(Month month) {
        Calendar cal = DateUtil.monthToCalendar(month);
        int daysOfMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        List<WorkDay> workDays = new ArrayList<WorkDay>(daysOfMonth);

        for (int i=0;i<daysOfMonth;i++) {
            workDays.add(new WorkDay(new SimpleDate(month, i + 1)));
        }

        return workDays;
    }

}
