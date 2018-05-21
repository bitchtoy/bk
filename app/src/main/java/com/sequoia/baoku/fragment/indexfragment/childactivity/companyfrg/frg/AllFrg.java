package com.sequoia.baoku.fragment.indexfragment.childactivity.companyfrg.frg;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.sequoia.baoku.R;
import com.sequoia.baoku.base.BaseFragment;
import com.sequoia.baoku.common.MultipleItem;
import com.sequoia.baoku.fragment.indexfragment.childactivity.companyfrg.adpter.SearchAdapter;
import com.sequoia.baoku.fragment.indexfragment.childactivity.companyfrg.frg.bean.DataBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author Administrator.
 * @date 2018/5/19.
 * @funtion
 */
public class AllFrg extends BaseFragment {
    @BindView(R.id.prodact_show)
    LinearLayout mLayout;
    @BindView(R.id.search_hot_words)
    RecyclerView hotWords;
    Unbinder unBinder;
    private SearchAdapter mAdp = null;
    private static String[] hotWord = {"百万医疗","家庭保障","保险公司","展业咨询","社保"
            ,"展业","理赔","重疾病","意外"};
    public static AllFrg getInstance(){
        return new AllFrg();
    }

    @Override
    protected int setView() {
        return R.layout.frg_all_layout;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        unBinder = ButterKnife.bind(this,view);
        mLayout.setVisibility(View.GONE);
        initLayout();
    }

    private void initLayout() {
        final List<MultipleItem> items = new ArrayList<>();

        for (int i=0;i<hotWord.length;i++){
            DataBean dataBean = new DataBean();
            dataBean.data = hotWord[i];

            items.add(dataBean);
        }
        GridLayoutManager manager = new GridLayoutManager(getContext(),5);
       

        hotWords.setLayoutManager(manager);
        mAdp = new SearchAdapter(items);
        hotWords.setAdapter(mAdp);


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unBinder.unbind();
    }
}
