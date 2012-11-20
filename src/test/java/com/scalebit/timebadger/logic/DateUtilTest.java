package com.scalebit.timebadger.logic;

import junit.framework.Assert;
import org.junit.Test;

public class DateUtilTest {

    @Test
    public void tesTminutesToHourMinuteString() {
        Assert.assertEquals("01:02", DateUtil.minutesToHourMinuteString(62));
        Assert.assertEquals("10:59", DateUtil.minutesToHourMinuteString(659));
    }

    @Test
    public void testMinutesToDecimalHours() {
        Assert.assertEquals("1.00", String.format("%.2f", 1d));
        Assert.assertEquals("57.99", String.format("%.2f", 57.989d));
    }

}
