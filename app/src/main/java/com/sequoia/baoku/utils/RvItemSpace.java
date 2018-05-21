package com.sequoia.baoku.utils;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * @author Administrator.
 * @date 2018/5/12.
 * @funtion
 */
public class RvItemSpace extends RecyclerView.ItemDecoration {

    private int space;
    public RvItemSpace(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.left = space;
        outRect.right = space;
        outRect.bottom = space;

    }
}
