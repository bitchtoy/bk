package com.sequoia.baoku.fragment.communityfragment.childfrg;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.sequoia.baoku.R;
import com.sequoia.baoku.base.BaseFragment;
import com.sequoia.baoku.common.ItemOnClickListener;
import com.sequoia.baoku.fragment.communityfragment.DeathLayoutData;
import com.sequoia.baoku.fragment.communityfragment.DetailsActivity;
import com.sequoia.baoku.fragment.communityfragment.communityadapter.RecmChildAdapter;
import com.sequoia.baoku.fragment.communityfragment.communitybean.RecmChildBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author Administrator.
 * @date 2018/5/6.
 * @funtion
 */

public class RecommendFrg extends BaseFragment {
    @BindView(R.id.recm_child_txt)
    TextView mRecmChildTxt;
    @BindView(R.id.recm_child_rccv)
    RecyclerView mRecmChildRccv;

    private RecmChildAdapter mAdapter = null;
    Unbinder unbinder;

    public static RecommendFrg getInstance() {
        return new RecommendFrg();
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
        mRecmChildTxt.setText(R.string.tab_one);
        Drawable drawable = getResources().getDrawable(R.drawable.tab_title);
        drawable.setBounds(0,0,drawable.getMinimumWidth(),drawable.getMinimumHeight());
        mRecmChildTxt.setCompoundDrawables(null,null,drawable,null);
        //--set recycler
        mRecmChildRccv.setLayoutManager(new LinearLayoutManager(getContext()));
        DividerItemDecoration decoration = new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL);
        decoration.setDrawable(ContextCompat.getDrawable(getContext(),R.drawable.recycler_bottom_line));
        mRecmChildRccv.addItemDecoration(decoration);
        mAdapter = new RecmChildAdapter(getContext());
        mRecmChildRccv.setAdapter(mAdapter);
        List<RecmChildBean> list = new ArrayList<>();
        for (int i = 0;i< DeathLayoutData.txtcontent.length;i++){
            RecmChildBean bean = new RecmChildBean();
            bean.txtcontent = DeathLayoutData.txtcontent[i];
            bean.repose = DeathLayoutData.repose[i];
            bean.follow = DeathLayoutData.follow[i];
            list.add(bean);
        }
        mAdapter.setData(list);
        mAdapter.getItemOnClickListener(new ItemOnClickListener() {
            @Override
            public void setItemOnClickListener(View view, int position) {
                Intent intent = new Intent(getContext(), DetailsActivity.class);
                startActivity(intent);
            }
        });

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
