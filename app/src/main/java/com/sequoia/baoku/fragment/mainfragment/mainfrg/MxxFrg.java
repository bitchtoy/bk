package com.sequoia.baoku.fragment.mainfragment.mainfrg;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.sequoia.baoku.R;
import com.sequoia.baoku.base.BaseFragment;

/**
 * @author Administrator.
 * @date 2018/5/10.
 * @funtion
 */
public class MxxFrg extends BaseFragment {


    public static MxxFrg getInstance(){
        return new MxxFrg();
    }

    @Override
    protected int setView() {
        return R.layout.main_xx_frg;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

    }
}
