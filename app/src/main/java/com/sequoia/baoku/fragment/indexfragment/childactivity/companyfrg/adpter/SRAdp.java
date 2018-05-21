package com.sequoia.baoku.fragment.indexfragment.childactivity.companyfrg.adpter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sequoia.baoku.R;

import java.util.List;

/**
 * @author Administrator.
 * @date 2018/5/19.
 * @funtion
 */
public class SRAdp extends RecyclerView.Adapter<SRAdp.SRVH> {
    private Context mContext;
    public SRAdp(Context context) {
        mContext = context;

    }

    @NonNull
    @Override
    public SRVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_result,parent,false);

        return new SRVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SRVH holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public static class SRVH extends RecyclerView.ViewHolder{
        public SRVH(View itemView) {
            super(itemView);
        }
    }
}
