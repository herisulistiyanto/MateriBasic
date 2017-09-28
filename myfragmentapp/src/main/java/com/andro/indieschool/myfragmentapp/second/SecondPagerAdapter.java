package com.andro.indieschool.myfragmentapp.second;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by herisulistiyanto on 8/29/17.
 */

public class SecondPagerAdapter extends FragmentStatePagerAdapter {

    private final List<SlideFragment> fragmentList;

    public SecondPagerAdapter(FragmentManager fm, List<SlideFragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
