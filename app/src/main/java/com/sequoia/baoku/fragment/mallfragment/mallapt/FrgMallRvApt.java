package com.sequoia.baoku.fragment.mallfragment.mallapt;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sequoia.baoku.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator.
 * @date 2018/5/11.
 * @funtion
 */
public class FrgMallRvApt extends RecyclerView.Adapter<FrgMallRvApt.HgrvHolder> {
     private List<String> mList = new ArrayList<>();
     private Context mContext;
     private LayoutInflater mInflater;
     public FrgMallRvApt(RecyclerView recyclerView){
         mContext = recyclerView.getContext();
         mInflater = LayoutInflater.from(mContext);
     }
     public void setDatas(List<String> list){
         if (mList!= null){
             mList.clear();
             mList.addAll(list);
             notifyDataSetChanged();
         }
     }
    @NonNull
    @Override
    public HgrvHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View view = mInflater.inflate(R.layout.frg_mall_rv_item,parent,false);
         return new HgrvHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HgrvHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public static class HgrvHolder extends RecyclerView.ViewHolder{

        public HgrvHolder(View itemView) {
            super(itemView);
        }
    }
}
