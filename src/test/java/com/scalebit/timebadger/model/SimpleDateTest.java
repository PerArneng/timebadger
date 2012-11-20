package com.scalebit.timebadger.model;

import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateTest {

    @Test
    public void testGetFormattedString() {
        Assert.assertEquals("2012-01-01", new SimpleDate(2012, 1, 1).toFormattedString());
        Assert.assertEquals("2012-12-31", new SimpleDate(2012, 12, 31).toFormattedString());
    }

    @Test
    public void testFromDate() throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Assert.assertEquals("2012-08-31", SimpleDate.fromDate(df.parse("2012-08-31")).toFormattedString());
    }
}
