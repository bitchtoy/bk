package com.sequoia.baoku.fragment.indexfragment.childactivity.companyfrg;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sequoia.baoku.R;
import com.sequoia.baoku.base.BaseActivity;
import com.sequoia.baoku.fragment.indexfragment.childactivity.companyfrg.adpter.SRAdp;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Administrator.
 * @date 2018/5/20.
 * @funtion
 */
public class BRActivity extends BaseActivity {


    @BindView(R.id.back_button)
    ImageButton back_button;
    @BindView(R.id.tool_bar_title)
    TextView tool_bar_title;
    @BindView(R.id.tool_bar_right)
    TextView tool_bar_right;
    @BindView(R.id.br_should_gone)
    LinearLayout br_should_gone;
    @BindView(R.id.result_rv)
    RecyclerView result_rv;
    private SRAdp mAdp = null;
    @Override
    public void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_search_result);
        ButterKnife.bind(this);
        initLayout();
    }

    private void initLayout() {
        back_button.setImageDrawable(getResources().getDrawable(R.drawable.scback));
        tool_bar_title.setText("最近浏览");
        tool_bar_right.setText("清空");
        tool_bar_right.setTextColor(getResources().getColor(R.color.validata_btn));
        br_should_gone.setVisibility(View.GONE);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        result_rv.setLayoutManager(manager);
        mAdp = new SRAdp(this);
        result_rv.setAdapter(mAdp);

    }
}
