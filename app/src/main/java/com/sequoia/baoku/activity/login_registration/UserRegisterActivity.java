package com.sequoia.baoku.activity.login_registration;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.jaeger.library.StatusBarUtil;
import com.sequoia.baoku.R;
import com.sequoia.baoku.activity.index.IndexActivity;
import com.sequoia.baoku.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author Administrator.
 * @date 2018/4/25.
 * @funtion
 */

public class UserRegisterActivity extends BaseActivity {


    @BindView(R.id.back_button)
    ImageButton mBackButton;
    @BindView(R.id.tool_bar_title)
    TextView mToolBarTitle;
    @BindView(R.id.setting_password_next_step_btn)
    Button mSettingPasswordNextStepBtn;

    @Override
    public void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_user_register);
        ButterKnife.bind(this);
        initToolBar();


    }

    private void initToolBar() {
        StatusBarUtil.setTranslucent(UserRegisterActivity.this);
        mToolBarTitle.setText(R.string.user_register_tool_bar_title);
        mBackButton.setImageResource(R.drawable.narmal_tool_bar_back);
    }


    @OnClick({R.id.back_button, R.id.setting_password_next_step_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back_button:
                finish();
                break;
            case R.id.setting_password_next_step_btn:
                Intent intent = new Intent(UserRegisterActivity.this, IndexActivity.class);
                startActivity(intent);

                break;
            default:
                break;
        }
    }
}
