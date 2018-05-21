package com.sequoia.baoku.activity.login_registration;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
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

public class NarmalLoginActivity extends BaseActivity {


    @BindView(R.id.back_button)
    ImageButton mBackButton;
    @BindView(R.id.tool_bar_title)
    TextView mToolBarTitle;
    @BindView(R.id.narmal_phone_numbar)
    EditText mNarmalPhoneNumbar;
    @BindView(R.id.narmal_login_possword)
    EditText mNarmalLoginPossword;
    @BindView(R.id.narmal_login_btn)
    Button mNarmalLoginBtn;
    @BindView(R.id.forget_pass_word_text)
    TextView mForgetPassWordText;
    @BindView(R.id.narmal_agreement_check_box)
    CheckBox mNarmalAgreementCheckBox;
    @BindView(R.id.narmal_agreement_check_image)
    ImageView mNarmalAgreementCheckImage;


    @Override
    public void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_narmal_login);
        ButterKnife.bind(this);
        initToolBar();
    }

    private void initToolBar() {
        StatusBarUtil.setTranslucent(NarmalLoginActivity.this);
        mToolBarTitle.setText(R.string.app_narmal_login_tool_bar_title);
        mBackButton.setImageResource(R.drawable.narmal_tool_bar_back);

    }



    @OnClick({R.id.back_button, R.id.narmal_phone_numbar, R.id.narmal_login_possword, R.id.narmal_login_btn, R.id.forget_pass_word_text, R.id.narmal_agreement_check_box, R.id.narmal_agreement_check_image})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back_button:
                finish();
                break;
            case R.id.narmal_phone_numbar:
                break;
            case R.id.narmal_login_possword:
                break;
            case R.id.narmal_login_btn:
                Intent index = new Intent(NarmalLoginActivity.this, IndexActivity.class);
                startActivity(index);
                break;
            case R.id.forget_pass_word_text:
                break;
            case R.id.narmal_agreement_check_box:
                break;
            case R.id.narmal_agreement_check_image:
                Intent agreement = new Intent(NarmalLoginActivity.this, AgreementActivity.class);
                startActivity(agreement);
                break;
            default:
                break;
        }
    }
}
