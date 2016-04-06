package com.test.testandroidproject.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.test.testandroidproject.fragments.PagerFragment;

public class CustomViewPagerAdapter extends FragmentPagerAdapter {

    private int TOTAL_ITEMS = 4;

    public CustomViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return PagerFragment.newInstance("Fragment"+position);
    }

    @Override
    public int getCount() {
        return TOTAL_ITEMS;
    }
}
