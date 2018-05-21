package com.sequoia.baoku.fragment.communityfragment;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import com.jaeger.library.StatusBarUtil;
import com.sequoia.baoku.R;
import com.sequoia.baoku.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Administrator.
 * @date 2018/5/21.
 * @funtion
 */
public class DetailsActivity extends BaseActivity {
    @BindView(R.id.back_button)
    ImageButton back_button;
    @BindView(R.id.message)
    TextView message;
    @BindView(R.id.tool_bar_img_one)
    ImageButton tool_bar_img_one;

    @Override
    public void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_community_details_layout);
        ButterKnife.bind(this);
        StatusBarUtil.setTranslucent(this);
        initLayout();
    }

    private void initLayout() {
        back_button.setImageResource(R.drawable.scback);
        message.setText("1个评论");
        tool_bar_img_one.setImageResource(R.drawable.share_gary);

    }
}
