package com.sequoia.baoku.activity.index;


import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.jaeger.library.StatusBarUtil;
import com.sequoia.baoku.R;
import com.sequoia.baoku.base.BaseActivity;
import com.sequoia.baoku.fragment.communityfragment.CommunityFragment;
import com.sequoia.baoku.fragment.indexfragment.IndexFragment;
import com.sequoia.baoku.fragment.mainfragment.MainFragment;
import com.sequoia.baoku.fragment.mallfragment.MallFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.sequoia.baoku.fragment.indexfragment.IndexFragment.getInstanceIndexFragment;

/**
 * @author Administrator.
 * @date 2018/4/25.
 * @funtion
 */

public class IndexActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {
    @BindView(R.id.index_frame_layout)
    FrameLayout mIndexFrameLayout;
    @BindView(R.id.index_radio_home_bottom_bar)
    RadioButton mIndexRadioHomeBottomBar;
    @BindView(R.id.index_radio_community_bottom_bar)
    RadioButton mIndexRadioCommunityBottomBar;
    @BindView(R.id.index_radio_mall_bottom_bar)
    RadioButton mIndexRadioMallBottomBar;
    @BindView(R.id.index_radio_main_bottom_bar)
    RadioButton mIndexRadioMainBottomBar;
    @BindView(R.id.index_radio_group_bottom_bar)
    RadioGroup mIndexRadioGroupBottomBar;
    @BindView(R.id.index_bottom_popuwindown)
    RadioButton mIndexBottomPopuwindown;
    private FragmentManager mManager = null;
    private IndexFragment mIndexFragment = null;
    private CommunityFragment mCommunityFragment = null;
    private MallFragment mMallFragment = null;
    private MainFragment mMainFragment = null;


    @Override
    public void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_index);
        ButterKnife.bind(this);
        //toolbar
        initToolbar();
    }

    private void initToolbar() {
        StatusBarUtil.setTranslucent(IndexActivity.this);
        mManager = getSupportFragmentManager();
        //底部栏的实现
        mIndexRadioGroupBottomBar.setOnCheckedChangeListener(this);
        mIndexRadioHomeBottomBar.setChecked(true);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        FragmentTransaction transaction = mManager.beginTransaction();
        hide(transaction);
        switch (i) {
            case R.id.index_radio_home_bottom_bar:
                if (mIndexFragment == null) {
                    mIndexFragment = getInstanceIndexFragment();
                    transaction.add(R.id.index_frame_layout, mIndexFragment);
                } else {
                    transaction.show(mIndexFragment);
                }
                break;
            case R.id.index_radio_community_bottom_bar:
                if (mCommunityFragment == null) {
                    mCommunityFragment = CommunityFragment.getInstanceCommunityFragment();
                    transaction.add(R.id.index_frame_layout, mCommunityFragment);
                } else {
                    transaction.show(mCommunityFragment);
                }
                break;
            case R.id.index_radio_mall_bottom_bar:
                if (mMallFragment == null) {
                    mMallFragment = MallFragment.getInstanceMallFragment();
                    transaction.add(R.id.index_frame_layout, mMallFragment);
                } else {
                    transaction.show(mMallFragment);
                }
                break;
            case R.id.index_radio_main_bottom_bar:
                if (mMainFragment == null) {
                    mMainFragment = MainFragment.getInstanceMainFragment();
                    transaction.add(R.id.index_frame_layout, mMainFragment);
                } else {
                    transaction.show(mMainFragment);
                }
                break;
            default:
                break;
        }
        transaction.commit();
    }

    //yin chang
    private void hide(FragmentTransaction transaction) {
        if (mIndexFragment != null) {
            transaction.hide(mIndexFragment);
        }
        if (mCommunityFragment != null) {
            transaction.hide(mCommunityFragment);
        }
        if (mMallFragment != null) {
            transaction.hide(mMallFragment);
        }
        if (mMainFragment != null) {
            transaction.hide(mMainFragment);
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
