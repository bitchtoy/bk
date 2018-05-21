package com.sequoia.baoku.fragment.indexfragment.childactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.jaeger.library.StatusBarUtil;
import com.sequoia.baoku.R;
import com.sequoia.baoku.base.BaseActivity;
import com.sequoia.baoku.fragment.indexfragment.childactivity.companyfrg.CSFrg;
import com.sequoia.baoku.fragment.indexfragment.childactivity.companyfrg.SearchActivity;
import com.sequoia.baoku.fragment.indexfragment.childactivity.psfrg.PSFrg;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author Administrator.
 * @date 2018/5/12.
 * @funtion
 */
public class PSActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {


    @BindView(R.id.back_button)
    ImageButton back_button;
    @BindView(R.id.tool_bar_title)
    TextView tool_bar_title;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.frg_index_ps_rg)
    RadioGroup frg_index_ps_rg;
    @BindView(R.id.frg_index_ps_search)
    ImageButton frg_index_ps_search;
    @BindView(R.id.frg_index_ps_rb_albc)
    RadioButton albc;
    @BindView(R.id.frg_index_ps_rb_agsc)
    RadioButton agsc;
    @BindView(R.id.frg_index_ps_frame)
    FrameLayout frame;
    private PSFrg mPSFrg = null;
    private CSFrg mCSFrg = null;
    private FragmentManager mManager = null;

    @Override
    public void initView(Bundle savedInstanceState) {
        setContentView(R.layout.frg_index_child_ps_layout);
        ButterKnife.bind(this);
        initLayout();
    }

    private void initLayout() {

        StatusBarUtil.setTranslucent(PSActivity.this);
        albc.setTextColor(getResources().getColor(R.color.toolBar));
        mManager = getSupportFragmentManager();

        back_button.setImageResource(R.drawable.back);
        tool_bar_title.setText(R.string.ps_title_bar);
        tool_bar_title.setTextColor(getResources().getColor(R.color.toolBar));
        toolbar.setBackgroundColor(getResources().getColor(R.color.validata_btn));
        frg_index_ps_rg.setOnCheckedChangeListener(PSActivity.this);
        albc.setChecked(true);

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        FragmentTransaction transaction = mManager.beginTransaction();
        hideCurrent(transaction);
        switch (checkedId) {
            case R.id.frg_index_ps_rb_albc:
                albc.setTextColor(getResources().getColor(R.color.toolBar));
                agsc.setTextColor(getResources().getColor(R.color.validata_btn));
                if (mPSFrg == null) {
                    mPSFrg = PSFrg.getInstance();
                    transaction.add(R.id.frg_index_ps_frame, mPSFrg);
                } else {
                    transaction.show(mPSFrg);
                }
                break;
            case R.id.frg_index_ps_rb_agsc:
                albc.setTextColor(getResources().getColor(R.color.validata_btn));
                agsc.setTextColor(getResources().getColor(R.color.toolBar));
                if (mCSFrg == null) {
                    mCSFrg = CSFrg.getInstance();
                    transaction.add(R.id.frg_index_ps_frame, mCSFrg);
                } else {
                    transaction.show(mCSFrg);
                }
                break;
            default:
                break;
        }
        transaction.commit();
    }

    private void hideCurrent(FragmentTransaction transaction) {
        if (mPSFrg != null) {
            transaction.hide(mPSFrg);
        }
        if (mCSFrg != null) {
            transaction.hide(mCSFrg);
        }
    }

    @OnClick({R.id.back_button, R.id.frg_index_ps_search})
    public void onViewClicked(View view) {
        switch (view.getId()){
            case R.id.back_button:
                finish();
                break;
            case  R.id.frg_index_ps_search:
                Intent intent = new Intent(PSActivity.this, SearchActivity.class);
                startActivity(intent);
                break;
            default:
                break;

        }
    }
}
