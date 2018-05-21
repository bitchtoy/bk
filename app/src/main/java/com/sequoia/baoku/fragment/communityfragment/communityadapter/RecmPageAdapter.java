package com.sequoia.baoku.fragment.communityfragment.communityadapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * @author Administrator.
 * @date 2018/5/6.
 * @funtion
 */

public class RecmPageAdapter extends FragmentPagerAdapter {
    private List<Fragment> frgs;

    public RecmPageAdapter(FragmentManager fm,List<Fragment> frgs) {
        super(fm);
        this.frgs = frgs;
    }

    @Override
    public Fragment getItem(int position) {
        return frgs.get(position);
    }

    @Override
    public int getCount() {
        return frgs.size();
    }


}
