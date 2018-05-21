package com.sequoia.baoku.activity.login_registration;

import android.content.Intent;
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
import com.sequoia.baoku.activity.login_registration.service.LoginService;
import com.sequoia.baoku.base.BaseActivity;
import com.sequoia.baoku.common.OnRequest;
import com.sequoia.baoku.utils.CountDownTimeUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author Administrator.
 * @date 2018/4/23.
 * @funtion
 */

public class FastLoginActivity extends BaseActivity {

    @BindView(R.id.tool_bar_title)
    TextView mToolBarTitle;
    @BindView(R.id.tool_bar_right)
    TextView mToolBarRight;
    @BindView(R.id.phone_numbar)
    EditText mPhoneNumbar;
    @BindView(R.id.validata_unmbar)
    EditText mValidataUnmbar;
    @BindView(R.id.get_validata_code_buton)
    Button mGetValidataCodeButon;
    @BindView(R.id.fast_login_button)
    Button mFastLoginButton;
    @BindView(R.id.wechat_login_button)
    ImageButton mWechatLoginButton;
    @BindView(R.id.fast_agreement_check_box)
    CheckBox mAgreementCheckBox;
    @BindView(R.id.fast_agreement_check_image)
    ImageView mFastAgreementCheckImage;
    private LoginService mLoginService = null;
    private OnRequest mLoginListen = null;
    private CountDownTimeUtils mTimeUtils = null;
    @Override
    public void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_fast_login);
        ButterKnife.bind(this);
        //初始化titleBar
        initToolBar();
        initLayoutView();
        mTimeUtils = new CountDownTimeUtils(1000*60L,1000,mGetValidataCodeButon);

    }

    private void initLayoutView() {
    }

    //初始化titleBar
    private void initToolBar() {
        StatusBarUtil.setTranslucent(FastLoginActivity.this);
        mToolBarTitle.setText(R.string.app_fast_login_tool_bar_title);
        mToolBarRight.setText(R.string.app_fast_login_tool_bar_right);

    }


    @OnClick({R.id.tool_bar_right, R.id.fast_login_button,R.id.fast_agreement_check_image,R.id.get_validata_code_buton})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tool_bar_right:
                Intent userLogin = new Intent(FastLoginActivity.this, NarmalLoginActivity.class);
                startActivity(userLogin);
                break;
            case R.id.fast_login_button:
                Intent userRegister = new Intent(FastLoginActivity.this, UserRegisterActivity.class);
                startActivity(userRegister);
                break;
            case R.id.fast_agreement_check_image:
                Intent agreement = new Intent(FastLoginActivity.this, AgreementActivity.class);
                startActivity(agreement);
                break;
            case R.id.get_validata_code_buton:
                mTimeUtils.start();
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mLoginService != null){
            mLoginService.cancle();
        }
    }
}
