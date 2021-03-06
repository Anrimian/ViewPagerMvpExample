package com.github.anrimian.viewpagermvpexample.ui.utils.view_pager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 22.09.2015.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

    private final List<FragmentCreator> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager manager) {
        super(manager);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position).createFragment();
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    public void addFragment(FragmentCreator fragmentCreator, String title) {
        addFragment(fragmentCreator);
        mFragmentTitleList.add(title);
    }

    public void addFragment(FragmentCreator fragmentCreator) {
        mFragmentList.add(fragmentCreator);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitleList.get(position);
    }
}
