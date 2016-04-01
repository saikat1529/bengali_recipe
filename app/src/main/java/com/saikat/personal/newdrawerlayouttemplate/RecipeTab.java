package com.saikat.personal.newdrawerlayouttemplate;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.saikat.personal.newdrawerlayouttemplate.Recipe.RecipeOverview;

/**
 * Created by Saikat on 13/12/2015.
 */
public class RecipeTab extends Fragment {

    public static TabLayout tabLayout;
    public static ViewPager viewPager;
    public static int items = 3;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        /**
         *Inflate tab_layout and setup Views.
         */
        View view = inflater.inflate(R.layout.recipe_tab,null);
        tabLayout = (TabLayout)view.findViewById(R.id.recipe_tabs);
        viewPager = (ViewPager)view.findViewById(R.id.recipe_viewpager);

        /**
         *Set an Apater for the View Pager
         */
        viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));

        /**
         * Now , this is a workaround ,
         * The setupWithViewPager dose't works without the runnable .
         * Maybe a Support Library Bug .
         */
        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
            }
        });
        return view;
    }

    class MyAdapter extends FragmentPagerAdapter{

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0 : return new RecipeOverview(getActivity());
                case 1 : return new Ingredients(getActivity());
                case 2 : return new Description(getActivity());
            }
            return null;
        }

        @Override
        public int getCount() {
            return items;
        }

        /**
         * This method returns the title of the tab according to the position.
         */

        @Override
        public CharSequence getPageTitle(int position) {

            switch (position){
                case 0 :
                    return "Overview";
                case 1 :
                    return "Ingredients";
                case 2 :
                    return "Description";
            }
            return null;
        }
    }

}
