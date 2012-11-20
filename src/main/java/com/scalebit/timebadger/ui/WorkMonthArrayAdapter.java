package com.scalebit.timebadger.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.scalebit.timebadger.logic.DateUtil;
import com.scalebit.timebadger.model.WorkDay;
import com.scalebit.timebadger.model.WorkMonth;
import com.scalebit.timebadger.R;

public class WorkMonthArrayAdapter extends ArrayAdapter<WorkDay> {

    private final WorkMonth workMonth;
    private final LayoutInflater viewInflator;

    public WorkMonthArrayAdapter(Context context, WorkMonth workMonth) {
        super(context, android.R.layout.simple_list_item_1, android.R.id.text1, workMonth.getDays());
        this.workMonth = workMonth;
        viewInflator = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;

        if (rowView == null)
            rowView = viewInflator.inflate(R.layout.work_day_row, null);

        WorkDay workDay = workMonth.getDays().get(position);

        if (workDay.getDate().isRedDay()) {
            rowView.setBackgroundColor(0x20FF0000);
        } else {
            rowView.setBackgroundColor(Color.TRANSPARENT);
        }

        TextView dateTextView = (TextView) rowView.findViewById(R.id.date);
        dateTextView.setText(workDay.getDate().toFormattedString());

        TextView totalTimeTextView = (TextView) rowView.findViewById(R.id.totalTime);
        totalTimeTextView.setText(String.format("%s/%s",
                DateUtil.minutesToDecimalHours(workDay.getTotalTime()),
                DateUtil.minutesToDecimalHours(workDay.getTotalTime())
        ));

        TextView noteTextView = (TextView) rowView.findViewById(R.id.note);
        noteTextView.setText(workDay.getComment());

        return rowView;
    }
}
