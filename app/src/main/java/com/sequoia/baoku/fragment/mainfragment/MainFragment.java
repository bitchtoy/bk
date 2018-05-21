package com.sequoia.baoku.fragment.mainfragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.sequoia.baoku.R;
import com.sequoia.baoku.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author Administrator.
 * @date 2018/4/26.
 * @funtion
 */

public class MainFragment extends BaseFragment {

    @BindView(R.id.tool_bar_img_one)
    ImageButton mToolBarImgOne;
    @BindView(R.id.tool_bar_img_two)
    ImageButton mToolBarImgTwo;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.main_frg_tly)
    TabLayout tly;
    @BindView(R.id.m_frg_nsv)
    NestedScrollView nsv;
    Unbinder unbinder;
    @BindView(R.id.grid_one)
    View grid_one;
    @BindView(R.id.grid_two)
    View grid_two;
    @BindView(R.id.grid_three)
    View grid_three;
    @BindView(R.id.grid_four)
    View grid_four;
    @BindView(R.id.tool_bar_title)
    TextView tool_bar_title;
    //false 为没锁定
    private boolean locktab = false;
    //判断scroll view 滑动的位置
    private int lastPosition = 0;


    public static MainFragment getInstanceMainFragment() {
        return new MainFragment();
    }

    @Override
    protected int setView() {
        return R.layout.fragment_main_layout;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        unbinder = ButterKnife.bind(this, view);
        initLayout();
    }

    private void initLayout() {
        mToolbar.setBackgroundColor(getResources().getColor(R.color.validata_btn));
        mToolBarImgOne.setImageResource(R.drawable.share);
        mToolBarImgTwo.setImageResource(R.drawable.set);

        tool_bar_title.setText(R.string.main);
        tool_bar_title.setTextColor(getResources().getColor(R.color.toolBar));
        tly.addTab(tly.newTab().setText(R.string.tab_xin_xi));
        tly.addTab(tly.newTab().setText(R.string.tab_bao_zhang));
        tly.addTab(tly.newTab().setText(R.string.tab_shou_quan));
        tly.addTab(tly.newTab().setText(R.string.tab_zi_chan));
        tly.addTab(tly.newTab().setText(R.string.tab_li_pei));
        initTabSvLinkage();

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    //tab layout 和  scroll view 联动
    @SuppressLint("NewApi")
    private void initTabSvLinkage() {

        nsv.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View view, int i, int i1, int i2, int i3) {
                int y = i1;
                if (y > grid_one.getTop()) {
                    changeTab(1);
                }
                if (y > grid_two.getTop()) {
                    changeTab(2);
                }
                if (y > grid_three.getTop()) {
                    changeTab(3);
                }
                if (y > grid_four.getTop()) {
                    changeTab(4);
                } else if (y > 0 && y < grid_one.getTop()) {
                    changeTab(0);
                }

            }
        });
        tly.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int postion = tab.getPosition();
                int targetY = 0;
                switch (postion) {
                    case 0:
                        targetY = 0;
                        break;
                    case 1:
                        targetY = grid_one.getTop();
                        break;
                    case 2:
                        targetY = grid_two.getTop();
                        break;
                    case 3:
                        targetY = grid_three.getTop();
                        break;
                    case 4:
                        targetY = grid_four.getTop();
                        break;
                    default:
                        break;
                }
                nsv.scrollTo(0, targetY);

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    //scroll view 滑动改变tab
    private void changeTab(int currentTab) {
        tly.setScrollPosition(currentTab, 0, true);
    }
}
