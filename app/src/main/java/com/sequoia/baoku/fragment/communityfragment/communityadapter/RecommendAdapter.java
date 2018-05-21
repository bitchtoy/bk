package com.sequoia.baoku.fragment.communityfragment.communityadapter;

import android.content.Context;
import android.support.annotation.NonNull;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sequoia.baoku.R;
import com.sequoia.baoku.fragment.communityfragment.communitybean.RecommendBean;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * @author Administrator.
 * @date 2018/5/5.
 * @funtion
 */

public class RecommendAdapter extends RecyclerView.Adapter<RecommendAdapter.RecommendHolder> {
    private List<RecommendBean> mStrings = new ArrayList<>();
    private Context mContext = null;
    public RecommendAdapter(RecyclerView recyclerView) {
        mContext = recyclerView.getContext();
        if (mStrings.size() == 0){
            RecommendBean bean = new RecommendBean();
            bean.img = R.drawable.more_recommend;
            bean.user = "暂无数据";
            bean.describe = "没有网络出错...";
            mStrings.add(bean);
            notifyDataSetChanged();
        }
    }
    public void setData(List<RecommendBean> list) {
        if (list != null) {
            mStrings.clear();
            mStrings.addAll(list);
            notifyDataSetChanged();
        }

    }
    @NonNull
    @Override
    public RecommendHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.community_frg_recommend, parent, false);
        return new RecommendHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull RecommendHolder holder, int position) {
            Glide.with(mContext).load(mStrings.get(position).img).into(holder.mCircleImageView);
            holder.userName.setText(mStrings.get(position).user);
            holder.descride.setText(mStrings.get(position).describe);
    }

    @Override
    public int getItemCount() {
        return mStrings.size();

    }

    public static class RecommendHolder extends RecyclerView.ViewHolder {
        CircleImageView mCircleImageView;
        TextView userName;
        TextView descride;
        public RecommendHolder(View view) {
            super(view);
            mCircleImageView = view.findViewById(R.id.user_img);
            userName = view.findViewById(R.id.user);
            descride = view.findViewById(R.id.describe);
        }
    }
}

