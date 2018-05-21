package com.sequoia.baoku.fragment.mallfragment.mallapt;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator.
 * @date 2018/5/11.
 * @funtion
 */
public class MallFrgVpApt extends FragmentPagerAdapter {
    private List<Fragment> mList;
    public MallFrgVpApt(FragmentManager fm,List<Fragment> list) {
        super(fm);
        mList = list;
    }

    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mList.size();
    }
}
