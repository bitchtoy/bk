package com.sequoia.baoku.fragment.indexfragment.childactivity.psfrg;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.sequoia.baoku.R;
import com.sequoia.baoku.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author Administrator.
 * @date 2018/5/14.
 * @funtion
 */
public class PSFrg extends BaseFragment implements RadioGroup.OnCheckedChangeListener {


    @BindView(R.id.ps_rb_yw)
    RadioButton yw;
    @BindView(R.id.ps_rb_zj)
    RadioButton zj;
    @BindView(R.id.ps_rb_yl)
    RadioButton yl;
    @BindView(R.id.ps_rb_rs)
    RadioButton rs;
    @BindView(R.id.ps_rb_lc)
    RadioButton lc;
    @BindView(R.id.ps_rg)
    RadioGroup ps_rg;
    Unbinder unBinder;
    @BindView(R.id.xiao_fei_lei_xing)
    LinearLayout xflx;
    @BindView(R.id.yi_wai_xian)
    LinearLayout ywx;
    @BindView(R.id.zhong_ji_xian)
    LinearLayout zjx;
    @BindView(R.id.yi_liao_xian)
    LinearLayout ylx;
    @BindView(R.id.ren_shou_xian)
    LinearLayout rsx;
    @BindView(R.id.li_cai_xian)
    LinearLayout lcx;


    public static PSFrg getInstance() {
        return new PSFrg();
    }

    @Override
    protected int setView() {
        return R.layout.ps_prodect_search_frg;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        unBinder = ButterKnife.bind(this, view);
        initLayout();
    }

    private void initLayout() {

        ps_rg.setOnCheckedChangeListener(this);
        yw.setChecked(true);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unBinder.unbind();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.ps_rb_yw:
                xflx.setVisibility(View.VISIBLE);
                ywx.setVisibility(View.VISIBLE);
                zjx.setVisibility(View.GONE);
                ylx.setVisibility(View.GONE);
                rsx.setVisibility(View.GONE);
                lcx.setVisibility(View.GONE);
                break;
            case R.id.ps_rb_zj:
                xflx.setVisibility(View.VISIBLE);
                ywx.setVisibility(View.GONE);
                zjx.setVisibility(View.VISIBLE);
                ylx.setVisibility(View.GONE);
                rsx.setVisibility(View.GONE);
                lcx.setVisibility(View.GONE);
                break;
            case R.id.ps_rb_yl:
                xflx.setVisibility(View.GONE);
                ywx.setVisibility(View.GONE);
                zjx.setVisibility(View.GONE);
                ylx.setVisibility(View.VISIBLE);
                rsx.setVisibility(View.GONE);
                lcx.setVisibility(View.GONE);
                break;
            case R.id.ps_rb_rs:
                xflx.setVisibility(View.VISIBLE);
                ywx.setVisibility(View.GONE);
                zjx.setVisibility(View.GONE);
                ylx.setVisibility(View.GONE);
                rsx.setVisibility(View.VISIBLE);
                lcx.setVisibility(View.GONE);
                break;
            case R.id.ps_rb_lc:
                xflx.setVisibility(View.GONE);
                ywx.setVisibility(View.GONE);
                zjx.setVisibility(View.GONE);
                ylx.setVisibility(View.GONE);
                rsx.setVisibility(View.GONE);
                lcx.setVisibility(View.VISIBLE);
                break;
            default:
                break;
        }
    }
}
