package com.scalebit.timebadger.ui;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import com.scalebit.timebadger.model.Month;

public class MonthTabListener<T extends Fragment> implements ActionBar.TabListener {
    private Fragment fragment;
    private final Activity activity;
    private final Month tag;
    private final Class<T> clazz;

    /** Constructor used each time a new tab is created.
     * @param activity  The host Activity, used to instantiate the fragment
     * @param tag  The identifier tag for the fragment
     * @param clz  The fragment's Class, used to instantiate the fragment
     */
    public MonthTabListener(Activity activity, Month tag, Class<T> clz) {
        this.activity = activity;
        this.tag = tag;
        this.clazz = clz;
    }

    /* The following are each of the ActionBar.TabListener callbacks */

    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        // Check if the fragment is already initialized
        if (this.fragment == null) {
            // If not, instantiate and add it to the activity
            this.fragment = Fragment.instantiate(activity, clazz.getName());
            ft.add(android.R.id.content, this.fragment, this.tag.toString());
        } else {
            // If it exists, simply attach it in order to show it
            ft.attach(fragment);
        }
    }

    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
        if (fragment != null) {
            // Detach the fragment, because another one is being attached
            ft.detach(fragment);
        }
    }

    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
        // User selected the already selected tab. Usually do nothing.
    }
}
