package com.sequoia.baoku.fragment.indexfragment.childactivity.companyfrg.adpter;


import android.content.Context;
import android.support.annotation.NonNull;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sequoia.baoku.R;
import com.sequoia.baoku.fragment.indexfragment.childactivity.companyfrg.bean.CLBean;


import java.util.List;


/**
 * @author Administrator.
 * @date 2018/5/16.
 * @funtion
 */
public class CSAdp extends RecyclerView.Adapter<CSAdp.BaseViewHolder> {
    private static final int FAST_CHECKED = 5001;
    private static final int COMPANY_LIST = 5002;
    private Context mContext;
    private List<CLBean> mCLBeans;
    private List<String> mFCBeans;
    private LinearLayoutManager mManager;

    public CSAdp(Context mContext, List<CLBean> mCLBeans, List<String> fcBeans, LinearLayoutManager manager) {
        this.mContext = mContext;
        this.mCLBeans = mCLBeans;
        mManager = manager;
        mFCBeans = fcBeans;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case FAST_CHECKED:
                view = LayoutInflater.from(mContext).inflate(R.layout.company_search_layout, parent, false);
                return new FCViewHolder(view);
            default:
               view = LayoutInflater.from(mContext).inflate(R.layout.company_search_list_item, parent, false);
               return new CLViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        if (holder == null) return;
        if (holder instanceof CLViewHolder) {
            int itemPosition = holder.getAdapterPosition();
            if (itemPosition == 1) {
                ((CLViewHolder) holder).pinyin.setText(mCLBeans.get(itemPosition).getPinyin());
            } else if (!mCLBeans.get(position).pinyin.equals(mCLBeans.get(position - 1).pinyin)) {
                ((CLViewHolder) holder).pinyin.setText(mCLBeans.get(position).getPinyin());
            } else {
                ((CLViewHolder) holder).pinyin.setText("");
            }
            ((CLViewHolder) holder).companyName.setText(mCLBeans.get(position).getCompanyName());
            ((CLViewHolder) holder).companyDescribe.setText("公司简介");
        }
        if (holder instanceof FCViewHolder){
           GridLayoutManager manager = new GridLayoutManager(mContext,3);
           ((FCViewHolder) holder).fcRV.setLayoutManager(manager);
            FCCAdp adp = new FCCAdp(R.layout.company_search_layout_item,mFCBeans);
            ((FCViewHolder) holder).fcRV.setAdapter(adp);
        }
    }

    @Override
    public int getItemCount() {
        return mCLBeans == null ? 0:mCLBeans.size();
    }
    static class BaseViewHolder extends RecyclerView.ViewHolder {

         BaseViewHolder(View itemView) {
            super(itemView);
        }
    }
    public static class FCViewHolder extends BaseViewHolder{
         RecyclerView fcRV;
         FCViewHolder(View itemView) {
            super(itemView);
            fcRV = itemView.findViewById(R.id.fast_checked_rv);
        }
    }
    public static class CLViewHolder extends BaseViewHolder {
        TextView pinyin;
        TextView companyName;
        TextView companyDescribe;

         CLViewHolder(View view) {
            super(view);
            pinyin = itemView.findViewById(R.id.cl_pin_yin);
            companyName = itemView.findViewById(R.id.cl_item_company_name);
            companyDescribe = itemView.findViewById(R.id.cl_item_company_introduction);
        }
    }

    public void scrollToPosition(String index) {
        int size = mCLBeans.size();
        for (int i = 1; i < size; i++) {
            if (TextUtils.equals(index, mCLBeans.get(i).pinyin)) {
                mManager.scrollToPositionWithOffset(i, 0);
                return;
            }
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return FAST_CHECKED;
        }
        return super.getItemViewType(position);
    }

}
