package com.sequoia.baoku.fragment.mallfragment.mallfrg;

import android.os.Bundle;
import android.view.View;

import com.sequoia.baoku.R;
import com.sequoia.baoku.base.BaseFragment;

/**
 * @author Administrator.
 * @date 2018/5/11.
 * @funtion
 */
public class GoodsFrgTwo extends BaseFragment {
    public static GoodsFrgTwo getInstance(){
        return new GoodsFrgTwo();
    }
    @Override
    protected int setView() {
        return R.layout.frg_mall_splmtw;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

    }
}
