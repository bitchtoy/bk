package com.sequoia.baoku.fragment.indexfragment.childactivity.companyfrg;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jaeger.library.StatusBarUtil;
import com.sequoia.baoku.R;
import com.sequoia.baoku.base.BaseActivity;
import com.sequoia.baoku.fragment.indexfragment.childactivity.companyfrg.adpter.KWAdp;
import com.sequoia.baoku.fragment.indexfragment.childactivity.companyfrg.adpter.SAVPAdp;
import com.sequoia.baoku.fragment.indexfragment.childactivity.companyfrg.frg.AllFrg;
import com.sequoia.baoku.fragment.indexfragment.childactivity.companyfrg.frg.CustomerFrg;
import com.sequoia.baoku.fragment.indexfragment.childactivity.companyfrg.frg.NoticeFrg;
import com.sequoia.baoku.fragment.indexfragment.childactivity.companyfrg.frg.ProdactFrg;
import com.sequoia.baoku.fragment.indexfragment.childactivity.companyfrg.frg.UserFrg;
import com.sequoia.baoku.fragment.indexfragment.childactivity.companyfrg.frg.WDFrg;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author Administrator.
 * @date 2018/5/19.
 * @funtion
 */
public class SearchActivity extends BaseActivity implements SearchView.OnQueryTextListener {


    @BindView(R.id.ib)
    ImageButton backBtn;
    @BindView(R.id.sv)
    SearchView sv;
    @BindView(R.id.search_activity_tab)
    TabLayout tablayout;
    @BindView(R.id.search_activity_vp)
    ViewPager viewPage;
    @BindView(R.id.init_view)
    LinearLayout init_view;
    @BindView(R.id.key_words_rv)
    RecyclerView key_words_rv;
    @BindView(R.id.key_words_list_view)
    LinearLayout key_words_list_view;
    private static final String TAG = "SearchActivity";
    @BindView(R.id.search_btn)
    TextView search_btn;
    private SAVPAdp vp_adapter = null;
    private KWAdp mKWAdp = null;
    private static String keyword;
    private static final String[] key_words_result = {"国泰康宁终身重疾（2012版）",
            "国泰防癌疾病", "国泰鑫如意（白金版）", "国泰鸿运少儿（分红型）", "国泰福禄双喜（分红型）",
            "国泰福满医生（分红型）", "国泰瑞鑫（分红型）", "国泰英才少儿"};

    @Override
    public void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_search_layout);
        ButterKnife.bind(this);
        initLayout();
    }

    private void initLayout() {
        StatusBarUtil.setTranslucent(this);
        sv.setIconified(false);
        sv.setIconifiedByDefault(false);
        tablayout.addTab(tablayout.newTab());
        tablayout.addTab(tablayout.newTab());
        tablayout.addTab(tablayout.newTab());
        tablayout.addTab(tablayout.newTab());
        tablayout.addTab(tablayout.newTab());
        tablayout.addTab(tablayout.newTab());
        initVP();
        tablayout.setupWithViewPager(viewPage);
        tablayout.getTabAt(0).setText("全部");
        tablayout.getTabAt(1).setText("产品");
        tablayout.getTabAt(2).setText("用户");
        tablayout.getTabAt(3).setText("问答");
        tablayout.getTabAt(4).setText("通知");
        tablayout.getTabAt(5).setText("客户");
        sv.setOnQueryTextListener(this);

    }

    private void initVP() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(AllFrg.getInstance());
        fragments.add(ProdactFrg.getInstance());
        fragments.add(UserFrg.getInstance());
        fragments.add(WDFrg.getInstance());
        fragments.add(NoticeFrg.getInstance());
        fragments.add(CustomerFrg.getInstance());
        vp_adapter = new SAVPAdp(getSupportFragmentManager(), fragments);
        viewPage.setAdapter(vp_adapter);
    }

    @OnClick({R.id.ib})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ib:
                finish();
                break;
            default:
                break;

        }

    }

    //searchview 监听
    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {

        keyword = newText;
        key_words_list_view.setVisibility(View.VISIBLE);
        init_view.setVisibility(View.GONE);
        initKeyWordsList();
        if (newText.equals("")) {
            key_words_list_view.setVisibility(View.GONE);
            init_view.setVisibility(View.VISIBLE);

        }


        return false;
    }

    private void initKeyWordsList() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < key_words_result.length; i++) {
            list.add(key_words_result[i]);
        }
        mKWAdp = new KWAdp(this, list);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        key_words_rv.setLayoutManager(manager);
        key_words_rv.setAdapter(mKWAdp);
    }

    @OnClick(R.id.search_btn)
    public void onClick(View v) {
       switch (v.getId()){
           case R.id.search_btn:
               if (keyword == null) {toast("请输入关键字");}
               else {
                   Log.d(TAG,keyword);
                   Intent sr =new Intent(SearchActivity.this, SResultActivity.class);
                   startActivity(sr);
               }
               break;
           default:
               break;
       }
    }
}
