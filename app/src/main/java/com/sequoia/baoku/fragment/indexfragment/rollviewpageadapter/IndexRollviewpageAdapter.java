package com.sequoia.baoku.fragment.indexfragment.rollviewpageadapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.LoopPagerAdapter;
import com.sequoia.baoku.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Administrator.
 * @date 2018/4/27.
 * @funtion
 */

public class IndexRollviewpageAdapter extends LoopPagerAdapter {
    private int[] imgUrl = {R.drawable.banner1,R.drawable.banner1,R.drawable.banner1,R.drawable.banner1};

    public void getImgUrl(){

        notifyDataSetChanged();
    }

    public IndexRollviewpageAdapter(RollPagerView viewPager) {
        super(viewPager);
    }


    @Override
    public View getView(ViewGroup container, int position) {
        ImageView imageView = new ImageView(container.getContext());
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
            imageView.setImageResource(imgUrl[position]);

        return imageView;
    }

    @Override
    public int getRealCount() {
        if (imgUrl != null){
            return imgUrl.length;
        }
       return 0;
    }
}
