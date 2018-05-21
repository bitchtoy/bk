package com.sequoia.baoku.fragment.mallfragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TextView;

import com.sequoia.baoku.R;
import com.sequoia.baoku.base.BaseFragment;
import com.sequoia.baoku.fragment.mallfragment.mallapt.MallFrgVpApt;
import com.sequoia.baoku.fragment.mallfragment.mallfrg.GoodsFrgOne;
import com.sequoia.baoku.fragment.mallfragment.mallfrg.GoodsFrgThree;
import com.sequoia.baoku.fragment.mallfragment.mallfrg.GoodsFrgTwo;
import com.sequoia.baoku.fragment.mallfragment.mallfrg.HotGoodsFrg;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author Administrator.
 * @date 2018/4/26.
 * @funtion
 */

public class MallFragment extends BaseFragment {

    @BindView(R.id.tool_bar_title)
    TextView mToolBarTitle;
    Unbinder unbinder;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.mall_frg_tab)
    TabLayout tab;
    @BindView(R.id.mall_frg_vp)
    ViewPager vp;
    private MallFrgVpApt mVpApt = null;

    public static MallFragment getInstanceMallFragment() {
        return new MallFragment();
    }

    @Override
    protected int setView() {
        return R.layout.fragment_mall_layout;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        unbinder = ButterKnife.bind(this, view);
        initLayout();
    }

    private void initLayout() {
        mToolbar.setBackgroundColor(getResources().getColor(R.color.validata_btn));
        mToolBarTitle.setText(R.string.mall);
        mToolBarTitle.setTextColor(getResources().getColor(R.color.toolBar));
        tab.addTab(tab.newTab());
        tab.addTab(tab.newTab());
        tab.addTab(tab.newTab());
        tab.addTab(tab.newTab());
        initVP();
        tab.setupWithViewPager(vp);
        tab.getTabAt(0).setText(R.string.rmsp);
        tab.getTabAt(1).setText(R.string.splm_one);
        tab.getTabAt(2).setText(R.string.splm_two);
        tab.getTabAt(3).setText(R.string.splm_three);
    }

    private void initVP() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(HotGoodsFrg.getInstance());
        fragments.add(GoodsFrgOne.getInstance());
        fragments.add(GoodsFrgTwo.getInstance());
        fragments.add(GoodsFrgThree.getInstance());
        mVpApt = new MallFrgVpApt(getFragmentManager(),fragments);
        vp.setAdapter(mVpApt);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


}
