package com.sequoia.baoku.fragment.indexfragment.childactivity.companyfrg.frg;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sequoia.baoku.R;
import com.sequoia.baoku.base.BaseFragment;
import com.sequoia.baoku.common.MultipleItem;
import com.sequoia.baoku.fragment.indexfragment.childactivity.companyfrg.BRActivity;
import com.sequoia.baoku.fragment.indexfragment.childactivity.companyfrg.adpter.SearchAdapter;
import com.sequoia.baoku.fragment.indexfragment.childactivity.companyfrg.frg.bean.DataBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * @author Administrator.
 * @date 2018/5/19.
 * @funtion
 */
public class ProdactFrg extends BaseFragment {
    @BindView(R.id.prodact_show)
    LinearLayout mLayout;
    @BindView(R.id.search_hot_words)
    RecyclerView hotWords;
    Unbinder unBinder;
    @BindView(R.id.browse_record)
    TextView browse_record;

    private SearchAdapter mAdp = null;
    private static String[] hotWord = {"常青树", "多倍保", "多倍保", "乐安健康", "天安"
            , "同方", "华夏", "泰康", "中英"};

    public static ProdactFrg getInstance() {
        return new ProdactFrg();
    }

    @Override
    protected int setView() {
        return R.layout.frg_all_layout;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        unBinder = ButterKnife.bind(this, view);
        initLayout();

    }

    private void initLayout() {
        final List<MultipleItem> items = new ArrayList<>();

        for (int i = 0; i < hotWord.length; i++) {
            DataBean dataBean = new DataBean();
            dataBean.data = hotWord[i];
            items.add(dataBean);
        }
        GridLayoutManager manager = new GridLayoutManager(getContext(), 5);
        hotWords.setLayoutManager(manager);
        mAdp = new SearchAdapter(items);
        hotWords.setAdapter(mAdp);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unBinder.unbind();
    }

    @OnClick(R.id.browse_record)
    public void onClick(View v) {
       switch (v.getId()){
           case R.id.browse_record:
               Intent intent = new Intent(getContext(), BRActivity.class);
               startActivity(intent);
               break;
           default:
               break;
       }
    }
}
