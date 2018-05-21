package com.sequoia.baoku.utils;

import android.content.Context;
import android.content.res.TypedArray;

import com.sequoia.baoku.R;

/**
 * @author Administrator.
 * @date 2018/5/21.
 * @funtion
 */
public class FloatBtnTranslation {
    public static int getFloatHeight(Context context){
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(new int[]{
                R.attr.actionBarSize} );
        int toolbarHeight = (int) typedArray.getDimension(0,0);
        typedArray.recycle();
        return toolbarHeight;

    }
}
