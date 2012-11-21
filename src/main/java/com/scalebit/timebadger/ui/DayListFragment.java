package com.scalebit.timebadger.ui;

import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import com.scalebit.timebadger.logic.WorkDayFactory;
import com.scalebit.timebadger.model.Month;
import com.scalebit.timebadger.model.WorkDay;
import com.scalebit.timebadger.model.WorkMonth;

import java.util.List;

public class DayListFragment extends ListFragment {

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Month month = (Month) getActivity().getActionBar().getSelectedTab().getTag();

        List<WorkDay> workDays = WorkDayFactory.create(month);
        WorkMonth wm = new WorkMonth(month, workDays);

        // Assign adapter to ListView
        setListAdapter(new WorkMonthArrayAdapter(this.getActivity(), wm));
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Log.i("FragmentList", "Item clicked: " + id);
    }
}
