package com.sequoia.baoku.fragment.indexfragment.childactivity.companyfrg.frg;

import android.os.Bundle;
import android.view.View;

import com.sequoia.baoku.R;
import com.sequoia.baoku.base.BaseActivity;
import com.sequoia.baoku.base.BaseFragment;

/**
 * @author Administrator.
 * @date 2018/5/19.
 * @funtion
 */
public class NoticeFrg extends BaseFragment {

    public static NoticeFrg getInstance(){
        return new NoticeFrg();
    }
    @Override
    protected int setView() {
        return R.layout.frg_all_layout;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

    }
}
