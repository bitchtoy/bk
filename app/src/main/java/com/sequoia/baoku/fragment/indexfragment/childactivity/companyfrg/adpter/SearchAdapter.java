package com.sequoia.baoku.fragment.indexfragment.childactivity.companyfrg.adpter;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.sequoia.baoku.R;
import com.sequoia.baoku.common.MultipleItem;
import com.sequoia.baoku.fragment.indexfragment.childactivity.companyfrg.frg.bean.DataBean;

import java.util.List;

/**
 * @author Administrator.
 * @date 2018/5/19.
 * @funtion
 */
public class SearchAdapter extends BaseMultiItemQuickAdapter<MultipleItem,BaseViewHolder> {
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public SearchAdapter(List<MultipleItem> data) {
        super(data);
        addItemType(5003, R.layout.item_search);
    }

    @Override
    protected void convert(BaseViewHolder helper, MultipleItem item) {
         int layoutType = helper.getItemViewType();
         switch (layoutType){
             case 5003 :
                 DataBean dataBean = (DataBean) item;
                 helper.setText(R.id.search_item,dataBean.data);
                 break;
              default:
                  break;
         }
    }
}
