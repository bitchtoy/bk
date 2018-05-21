package com.sequoia.baoku.fragment.mallfragment.mallfrg;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.jude.rollviewpager.RollPagerView;
import com.sequoia.baoku.R;
import com.sequoia.baoku.base.BaseFragment;
import com.sequoia.baoku.fragment.mallfragment.mallapt.FrgMallRpvApt;
import com.sequoia.baoku.fragment.mallfragment.mallapt.FrgMallRvApt;
import com.sequoia.baoku.utils.RvItemSpace;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author Administrator.
 * @date 2018/5/11.
 * @funtion
 */
public class HotGoodsFrg extends BaseFragment {

    Unbinder unBinder;
    @BindView(R.id.frg_mall_hg_rpv)
    RollPagerView frg_mall_hg_rpv;
    @BindView(R.id.frg_mall_hg_rv)
    RecyclerView frg_mall_hg_rv;
    private FrgMallRpvApt mApt = null;
    private FrgMallRvApt mRvApt = null;
    public static HotGoodsFrg getInstance() {
        return new HotGoodsFrg();
    }

    @Override
    protected int setView() {
        return R.layout.frg_mall_hg;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        unBinder = ButterKnife.bind(this,view);
        initLayout();

    }

    private void initLayout() {
        mApt = new FrgMallRpvApt(frg_mall_hg_rpv);
        frg_mall_hg_rpv.setAdapter(mApt);
        GridLayoutManager manager = new GridLayoutManager(mActivity,2);
        frg_mall_hg_rv.setLayoutManager(manager);
        mRvApt = new FrgMallRvApt(frg_mall_hg_rv);
        frg_mall_hg_rv.addItemDecoration(new RvItemSpace(6));
        frg_mall_hg_rv.setAdapter(mRvApt);



    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unBinder.unbind();
    }
}
