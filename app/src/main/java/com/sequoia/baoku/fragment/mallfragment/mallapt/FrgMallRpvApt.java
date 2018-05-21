package com.sequoia.baoku.fragment.mallfragment.mallapt;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.LoopPagerAdapter;
import com.sequoia.baoku.R;

/**
 * @author Administrator.
 * @date 2018/5/11.
 * @funtion
 */
public class FrgMallRpvApt extends LoopPagerAdapter {
    private static int[] img = {R.drawable.banner1,R.drawable.hg_banner,R.drawable.banner1};
    public FrgMallRpvApt(RollPagerView viewPager) {
        super(viewPager);
    }

    @Override
    public View getView(ViewGroup container, int position) {
        ImageView imageView = new ImageView(container.getContext());
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT
        , ViewGroup.LayoutParams.MATCH_PARENT));
        imageView.setImageResource(img[position]);
        return imageView;
    }

    @Override
    public int getRealCount() {
        return img.length;
    }
}
