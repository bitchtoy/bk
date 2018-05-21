package com.sequoia.baoku.fragment.indexfragment.childactivity.companyfrg.adpter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.sequoia.baoku.R;

import java.util.List;

/**
 * @author Administrator.
 * @date 2018/5/16.
 * @funtion
 */
public class FCCAdp extends BaseQuickAdapter<String,BaseViewHolder> {


    public FCCAdp(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.fast_checked_company_item,item);
    }
}
