package com.sequoia.baoku.fragment.indexfragment.childactivity.companyfrg.adpter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sequoia.baoku.R;

import java.util.List;

/**
 * @author Administrator.
 * @date 2018/5/19.
 * @funtion
 */
public class KWAdp extends RecyclerView.Adapter<KWAdp.KWH> {
    private Context mContext;
    private List<String> mList;
    public KWAdp(Context context,List<String> list) {
        mContext = context;
        mList = list;
    }

    @NonNull
    @Override
    public KWH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_key_words,parent,false);
        return new KWH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KWH holder, int position) {
         holder.tv.setText(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class KWH extends RecyclerView.ViewHolder{
        TextView tv;


        public KWH(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.key_words_item_tv);
        }
    }
}
