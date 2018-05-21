package com.sequoia.baoku.fragment.communityfragment.childfrg;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sequoia.baoku.R;
import com.sequoia.baoku.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author Administrator.
 * @date 2018/5/6.
 * @funtion
 */

public class DynamicFrg extends BaseFragment {

    @BindView(R.id.recm_child_txt)
    TextView mRecmChildTxt;
    @BindView(R.id.recm_child_rccv)
    RecyclerView mRecmChildRccv;
    Unbinder unbinder;

    public static DynamicFrg getInstance() {
        return new DynamicFrg();
    }

    @Override
    protected int setView() {
        return R.layout.recm_child_layout;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        unbinder = ButterKnife.bind(this, view);
        initLayout();
    }

    private void initLayout() {
        mRecmChildTxt.setText(R.string.tab_two);
        Drawable drawable = getResources().getDrawable(R.drawable.tab_title);
        drawable.setBounds(0,0,drawable.getMinimumWidth(),drawable.getMinimumHeight());
        mRecmChildTxt.setCompoundDrawables(null,null,drawable,null);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
