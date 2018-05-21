package com.sequoia.baoku.activity.login_registration;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.jaeger.library.StatusBarUtil;
import com.sequoia.baoku.R;
import com.sequoia.baoku.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author Administrator.
 * @date 2018/4/25.
 * @funtion
 */

public class AgreementActivity extends BaseActivity {


    @BindView(R.id.back_button)
    ImageButton mBackButton;
    @BindView(R.id.tool_bar_title)
    TextView mToolBarTitle;
    @BindView(R.id.agreement_content_text)
    TextView mAgreementContentText;

    @Override
    public void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_agreement);
        ButterKnife.bind(this);
        initToolBar();

    }

    private void initToolBar() {
        StatusBarUtil.setTranslucent(AgreementActivity.this);
        mToolBarTitle.setText(R.string.agreement_tool_bar_title);
        mBackButton.setImageResource(R.drawable.narmal_tool_bar_back);

    }


    @OnClick(R.id.back_button)
    public void onViewClicked() {
        finish();
    }
}
