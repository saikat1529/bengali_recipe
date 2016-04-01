package com.saikat.personal.newdrawerlayouttemplate.Adpter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.saikat.personal.newdrawerlayouttemplate.Feedback;
import com.saikat.personal.newdrawerlayouttemplate.Saved;
import com.saikat.personal.newdrawerlayouttemplate.Settings;

/**
 * Created by fojlesaikat on 18/12/15.
 */
public class TabPagerAdapter extends FragmentPagerAdapter {

    int items;

    public TabPagerAdapter(FragmentManager childFragmentManager, int items) {
        super(childFragmentManager);
        this.items = items;
    }

    @Override
    public Fragment getItem(int i) {
        switch(i){
            case 0: return new Feedback();
            case 1: return new Settings();
            case 2: return new Saved();
        }
        return null;
    }

    @Override
    public int getCount() {
        return items;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0: return "Overview";
            case 1: return "Ingredients";
            case 2: return "Description";
        }
        return null;
    }
}
