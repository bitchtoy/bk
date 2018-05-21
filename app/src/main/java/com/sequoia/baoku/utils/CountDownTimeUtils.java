package com.sequoia.baoku.utils;

import android.graphics.Typeface;
import android.os.CountDownTimer;
import android.widget.Button;

import com.sequoia.baoku.R;

/**
 * @author Administrator.
 * @date 2018/4/25.
 * @funtion
 */

public class CountDownTimeUtils extends CountDownTimer {
    private Button mButton;

    public CountDownTimeUtils(long millisInFuture, long countDownInterval,Button button) {
        super(millisInFuture, countDownInterval);
        mButton = button;
    }

    @Override
    public void onTick(long l) {
        mButton.setClickable(false);
        mButton.setText("重新发送"+l/1000+"s");
        mButton.setTextSize(14);
    }

    @Override
    public void onFinish() {
        mButton.setClickable(true);
        mButton.setText(R.string.get_validata_code);
    }
}
