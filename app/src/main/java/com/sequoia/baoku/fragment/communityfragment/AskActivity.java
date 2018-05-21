package com.sequoia.baoku.fragment.communityfragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.sequoia.baoku.R;
import com.sequoia.baoku.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Administrator.
 * @date 2018/5/21.
 * @funtion
 */
public class AskActivity extends BaseActivity {


    @BindView(R.id.back_button)
    ImageButton back_button;
    @BindView(R.id.tool_bar_title)
    TextView tool_bar_title;
    @BindView(R.id.tool_bar_right)
    TextView tool_bar_right;
    @BindView(R.id.user_ask_content)
    EditText user_ask_content;
    @BindView(R.id.edit_string_lenght)
    TextView lenght;
    private static int MAX_LENGTH = 60;
    @BindView(R.id.label_check)
    RecyclerView label_check;

    @Override
    public void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_ask_layout);
        ButterKnife.bind(this);
        initLayout();
    }

    private void initLayout() {
        back_button.setImageResource(R.drawable.scback);
        tool_bar_title.setText("发布问题");
        tool_bar_right.setText("提交");
        tool_bar_right.setTextColor(getResources().getColor(R.color.validata_btn));
        lenght.setText("" + MAX_LENGTH);
        user_ask_content.addTextChangedListener(mWatcher);


    }

    //edit lenght
    TextWatcher mWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            int unm_length = s.length();
            lenght.setText("" + (MAX_LENGTH - unm_length));
        }
    };
}
