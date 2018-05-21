package com.sequoia.baoku.fragment.indexfragment.childactivity.companyfrg.adpter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * @author Administrator.
 * @date 2018/5/19.
 * @funtion
 */
public class SAVPAdp extends FragmentPagerAdapter {
    private List<Fragment> mList;

    public SAVPAdp(FragmentManager fm,List<Fragment> mList) {
        super(fm);
        this.mList = mList;
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
