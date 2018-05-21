package com.sequoia.baoku.fragment.indexfragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterViewFlipper;
import android.widget.TextView;

import com.jude.rollviewpager.RollPagerView;
import com.sequoia.baoku.R;
import com.sequoia.baoku.base.BaseFragment;
import com.sequoia.baoku.common.OnRequest;
import com.sequoia.baoku.fragment.indexfragment.childactivity.PSActivity;
import com.sequoia.baoku.fragment.indexfragment.indexservice.IndexFragService;
import com.sequoia.baoku.fragment.indexfragment.rollviewpageadapter.IndexRollviewpageAdapter;
import com.sequoia.baoku.fragment.indexfragment.rollviewpageadapter.ViewFlipperAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Response;


/**
 * @author Administrator.
 * @date 2018/4/26.
 * @funtion
 */

public class IndexFragment extends BaseFragment {
    @BindView(R.id.index_fragment_rollviewpage)
    RollPagerView bannerPage;
    Unbinder unbinder;
    @BindView(R.id.index_frag_flipper_view)
    AdapterViewFlipper mIndexFragFlipperView;
    @BindView(R.id.index_frag_evaluate)
    TextView indexFragEvaluate;
    //网络请求监听
    private OnRequest indexFragRequest = null;
    //网络请求service
    private IndexFragService mIndexFragService = null;
    //轮播的adater
    private IndexRollviewpageAdapter bannerAdapter = null;
    private ViewFlipperAdapter mFlipperAdapter = null;

    //fragment的单例
    public static IndexFragment getInstanceIndexFragment() {
        return new IndexFragment();
    }

    //轮播 间隔 时间
    private static final int BANNER_PLAY_TIME = 3000;

    @Override
    protected int setView() {
        return R.layout.fragment_index_layout;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        unbinder = ButterKnife.bind(this, view);
        initView();
    }

    private void initView() {

        indexFragRequest = new OnRequest<String>() {
            @Override
            public void OnRequestSuccess(Call<String> call, Response<String> response) {


            }

            @Override
            public void OnRequestFail(Call<String> call, Throwable throwable) {

            }

        };
        mIndexFragService = IndexFragService.getInstanceIndexFragService();
        mIndexFragService.requestIndexFragApi(indexFragRequest);
        //初始化 轮播
        initBanner();
    }

    //初始化 轮播
    private void initBanner() {
        //消息 轮播 临时的 死数据
        List<String> message = new ArrayList<>();
        message.add("父母必看！熊孩子暑假的正确打开方式");
        message.add("父母必看！熊孩子暑假的正确打开方式");
        message.add("父母必看！熊孩子暑假的正确打开方式");
        message.add("父母必看！熊孩子暑假的正确打开方式");
        message.add("父母必看！熊孩子暑假的正确打开方式");
        mFlipperAdapter = new ViewFlipperAdapter(getContext(), message);
        mIndexFragFlipperView.setAdapter(mFlipperAdapter);


        //初始化 轮播
        bannerPage.setPlayDelay(BANNER_PLAY_TIME);
        bannerPage.setAdapter(bannerAdapter = new IndexRollviewpageAdapter(bannerPage));


    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.index_frag_evaluate)
    public void onViewClicked() {
        toast("456542");

    }

    @OnClick(R.id.frg_index_ps)
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.frg_index_ps) {
            Intent ps = new Intent(mActivity, PSActivity.class);
            startActivity(ps);
        }
    }
}
