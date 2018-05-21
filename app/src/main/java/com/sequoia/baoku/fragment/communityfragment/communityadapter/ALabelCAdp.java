package com.sequoia.baoku.fragment.communityfragment.communityadapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sequoia.baoku.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator.
 * @date 2018/5/21.
 * @funtion
 */
public class ALabelCAdp extends RecyclerView.Adapter<ALabelCAdp.AlCVH> {
    private Context mContext;
    private List<String> lables = new ArrayList<>();
    public ALabelCAdp(RecyclerView recyclerView) {
        mContext = recyclerView.getContext();
    }
    public void setLables(List<String> lists){
        if (lists == null){
            lables.addAll(lists);
            notifyDataSetChanged();
        }
    }
    @NonNull
    @Override
    public AlCVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View label = LayoutInflater.from(mContext).inflate(R.layout.item_label_check, parent, false);
        return new AlCVH(label);
    }

    @Override
    public void onBindViewHolder(@NonNull AlCVH holder, int position) {
        holder.labelTV.setText(lables.get(position));

    }

    @Override
    public int getItemCount() {
        return lables.size();
    }

    public static class AlCVH extends RecyclerView.ViewHolder {
        TextView labelTV;
        public AlCVH(View itemView) {
            super(itemView);
            labelTV = itemView.findViewById(R.id.label_check_tv);
        }
    }
}
