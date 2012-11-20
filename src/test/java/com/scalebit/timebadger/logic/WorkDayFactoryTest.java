package com.scalebit.timebadger.logic;

import com.scalebit.timebadger.model.Month;
import com.scalebit.timebadger.model.WorkDay;
import junit.framework.Assert;
import org.junit.Test;

import java.util.List;

public class WorkDayFactoryTest {

    @Test
    public void testCreate() {
        List<WorkDay> workDays = WorkDayFactory.create(new Month(2012, 11));
        Assert.assertEquals(30, workDays.size());
        Assert.assertEquals("2012-11-01", workDays.get(0).getDate().toFormattedString());
    }

}
