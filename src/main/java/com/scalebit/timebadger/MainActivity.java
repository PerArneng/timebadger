package com.scalebit.timebadger;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.scalebit.timebadger.logic.WorkDayFactory;
import com.scalebit.timebadger.model.Month;
import com.scalebit.timebadger.model.WorkDay;
import com.scalebit.timebadger.model.WorkMonth;
import com.scalebit.timebadger.ui.WorkMonthArrayAdapter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        Month month = new Month(2012, 11);
        List<WorkDay> workDays = WorkDayFactory.create(month);
        WorkMonth wm = new WorkMonth(month, workDays);


        ListView listView = (ListView) findViewById(R.id.mylist);

        // Assign adapter to ListView
        listView.setAdapter(new WorkMonthArrayAdapter(this, wm));
    }
}
