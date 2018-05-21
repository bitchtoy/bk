package com.sequoia.baoku.fragment.indexfragment.childactivity.companyfrg;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.sequoia.baoku.R;
import com.sequoia.baoku.base.BaseFragment;
import com.sequoia.baoku.fragment.indexfragment.childactivity.companyfrg.bean.CLBean;
import com.sequoia.baoku.fragment.indexfragment.childactivity.companyfrg.adpter.CSAdp;
import com.sequoia.baoku.utils.SideIndexBar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author Administrator.
 * @date 2018/5/14.
 * @funtion
 */
public class CSFrg extends BaseFragment implements SideIndexBar.OnIndexTouchedChangedListener {

    @BindView(R.id.cs_slide_bar)
    SideIndexBar slidebar;
    @BindView(R.id.cs_rv)
    RecyclerView rv;
    Unbinder mUnbinder;
    @BindView(R.id.cp_overlay)
    TextView cp_overlay;
    private CSAdp mAdapter = null;

    private String[] datas = {"平安人寿", "中国人寿", "人寿保险", "太平洋人寿",
            "新华人寿", "泰康人寿", "太平人寿", "友邦人寿", "人保人寿", "安盛保险", "同方全球", "华夏人寿", "福德生命", "阳光保险"};
    private String[] company_list = {"爱家代理", "安邦财险", "安邦人寿", "安诚保险",
            "百年人寿", "北大方正人寿", "平安人寿", "中国人寿", "人寿保险", "太平洋人寿",
            "新华人寿", "泰康人寿", "太平人寿", "友邦人寿", "人保人寿", "安盛保险", "同方全球",
            "华夏人寿", "福德生命", "阳光保险","爱家代理", "安邦财险", "安邦人寿", "安诚保险",
            "百年人寿", "北大方正人寿", "平安人寿", "中国人寿", "人寿保险", "太平洋人寿",
            "新华人寿", "泰康人寿", "太平人寿", "友邦人寿", "人保人寿", "安盛保险", "同方全球",
            "华夏人寿", "福德生命", "阳光保险"
    };
    private String[] pinyin = {"A","A","A","A","B","B","P","Z","R","T","X","T","T","Y","R","A"
    ,"T","H","F","Y","A","A","A","A","B","B","P","Z","R","T","X","T","T","Y","R","A"
            ,"T","H","F","Y"};

    public static CSFrg getInstance() {
        return new CSFrg();
    }

    @Override
    protected int setView() {
        return R.layout.ps_company_search_frg;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        mUnbinder = ButterKnife.bind(this, view);
        initLayout();
}

    private void initLayout() {
        LinearLayoutManager manager = new LinearLayoutManager(mActivity);
        rv.setLayoutManager(manager);
        List<CLBean> list = new ArrayList<>();
        List<String> fcBeanList = new ArrayList<>();
        for (int i=0;i<datas.length;i++){
            fcBeanList.add(datas[i]);
        }
        for (int i = 0; i < company_list.length; i++) {
            CLBean companyBean = new CLBean();
            companyBean.setPinyin(pinyin[i]);
            companyBean.setCompanyName(company_list[i]);
            list.add(companyBean);
        }
        Collections.sort(list, new Comparator<CLBean>() {
            @Override
            public int compare(CLBean o1, CLBean o2) {
                return o1.pinyin.compareTo(o2.pinyin) ;
            }
        });

        mAdapter = new CSAdp(getContext(),list,fcBeanList,manager);
        rv.setAdapter(mAdapter);
        slidebar.setOverlayTextView(cp_overlay).setOnIndexChangedListener(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }

    @Override
    public void onIndexChanged(String index, int position) {
     mAdapter.scrollToPosition(index);


    }
}
