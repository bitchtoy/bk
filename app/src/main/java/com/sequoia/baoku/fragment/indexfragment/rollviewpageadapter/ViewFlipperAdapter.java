package com.sequoia.baoku.fragment.indexfragment.rollviewpageadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.sequoia.baoku.R;

import java.util.List;

/**
 * @author Administrator.
 * @date 2018/4/28.
 * @funtion
 */
//字幕滚动 消息轮播
public class ViewFlipperAdapter extends BaseAdapter {
    private Context mContext = null;
    private LayoutInflater mLayoutInflater = null;
    private List<String> mStringList = null;

    public ViewFlipperAdapter(Context context, List<String> stringList) {
        mContext = context;
        mStringList = stringList;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mStringList.size();
    }

    @Override
    public Object getItem(int i) {
        return mStringList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
       FlippterViewHolder holder = null;

       if (view == null){
           holder = new FlippterViewHolder();
           view = mLayoutInflater.inflate(R.layout.index_flipper_item_view,null,false);
           holder.mTextView = view.findViewById(R.id.flipper_view_text);
           view.setTag(holder);
       }else {
          holder = (FlippterViewHolder) view.getTag();
       }
        holder.mTextView.setText(mStringList.get(i));
        return view;
    }
    private class FlippterViewHolder{
        TextView mTextView;
        

    }
}
