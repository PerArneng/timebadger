package com.scalebit.timebadger;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import com.scalebit.timebadger.model.Month;
import com.scalebit.timebadger.ui.DayListFragment;
import com.scalebit.timebadger.ui.MonthTabListener;

public class MainActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // setup action bar for tabs
        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.setDisplayShowTitleEnabled(false);

        int year = 2012;

        for (int i=1;i<13;i++) {
            Month month = new Month(year, i);
            ActionBar.Tab tab = actionBar.newTab()
                    .setText(month.getShortName())
                    .setTag(month)
                    .setTabListener(new MonthTabListener<DayListFragment>(
                            this, month, DayListFragment.class));
            actionBar.addTab(tab);
        }

    }
}
