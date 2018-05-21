package com.sequoia.baoku.fragment.indexfragment.childactivity.companyfrg;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jaeger.library.StatusBarUtil;
import com.sequoia.baoku.R;
import com.sequoia.baoku.base.BaseActivity;
import com.sequoia.baoku.fragment.indexfragment.childactivity.companyfrg.adpter.SRAdp;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author Administrator.
 * @date 2018/5/19.
 * @funtion
 */
public class SResultActivity extends BaseActivity {
    @BindView(R.id.back_button)
    ImageButton back_button;
    @BindView(R.id.tool_bar_title)
    TextView tool_bar_title;
    @BindView(R.id.result_rv)
    RecyclerView result_rv;
    private SRAdp mSRAdp = null;


    @Override
    public void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_search_result);
        ButterKnife.bind(this);
        StatusBarUtil.setTranslucent(this);
        initLayout();

    }

    private void initLayout() {
        back_button.setImageDrawable(getResources().getDrawable(R.drawable.scback));
        tool_bar_title.setText("搜索结果");
        LinearLayoutManager m = new LinearLayoutManager(this);
        result_rv.setLayoutManager(m);
        mSRAdp = new SRAdp(this);
        result_rv.setAdapter(mSRAdp);
    }

    @OnClick(R.id.back_button)
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_button:
                finish();
                break;
            default:
                break;
        }
    }
}
