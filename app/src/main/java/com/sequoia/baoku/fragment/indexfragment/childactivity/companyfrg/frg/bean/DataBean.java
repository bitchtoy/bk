package com.sequoia.baoku.fragment.indexfragment.childactivity.companyfrg.frg.bean;

import com.sequoia.baoku.common.MultipleItem;

/**
 * @author Administrator.
 * @date 2018/5/19.
 * @funtion
 */
public class DataBean extends MultipleItem {
    public String data;
    public int type;

    @Override
    public int getItemType() {
        return 5003;
    }
}
