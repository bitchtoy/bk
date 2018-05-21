package com.sequoia.baoku.fragment.communityfragment.communityadapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sequoia.baoku.R;
import com.sequoia.baoku.common.ItemOnClickListener;
import com.sequoia.baoku.fragment.communityfragment.communitybean.RecmChildBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator.
 * @date 2018/5/6.
 * @funtion
 */

public class RecmChildAdapter extends Adapter<RecmChildAdapter.RecmChildHolder> {
    private Context mContext;
    private List<RecmChildBean> mList = new ArrayList<>();
    public ItemOnClickListener mItemOnClickListener;
    public RecmChildAdapter(Context context) {
        mContext = context;
    }
    public void setData(List<RecmChildBean> lists){
        if (mList != null){
            mList.clear();
            mList.addAll(lists);
            notifyDataSetChanged();
        }
    }

    @NonNull
    @Override
    public RecmChildHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View view = LayoutInflater.from(mContext).inflate(R.layout.recm_child_item_layout,parent,false);
        return new RecmChildHolder(view,mItemOnClickListener) ;
    }

    @Override
    public void onBindViewHolder(@NonNull RecmChildHolder holder, int position) {
        holder.txtCtd.setText(mList.get(position).txtcontent);
        holder.rps.setText(mList.get(position).repose);
        holder.flw.setText(mList.get(position).follow);







    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class RecmChildHolder extends ViewHolder implements View.OnClickListener {
        TextView txtCtd;
        TextView rps;
        TextView flw;
        RecyclerView pinglunp;
        ItemOnClickListener mListener;
        public RecmChildHolder(View itemView,ItemOnClickListener mItemOnClickListener) {
            super(itemView);
            txtCtd = itemView.findViewById(R.id.recm_child_recm_content);
            rps = itemView.findViewById(R.id.recm_child_recm_response);
            flw = itemView.findViewById(R.id.recm_child_recm_follow);
            pinglunp = itemView.findViewById(R.id.user_ping_lun);
            itemView.setOnClickListener(this);
            mListener = mItemOnClickListener;
        }

        @Override
        public void onClick(View v) {
           mListener.setItemOnClickListener(v,getPosition());
        }
    }
    public void getItemOnClickListener(ItemOnClickListener listener){
        mItemOnClickListener = listener;
    }
}
