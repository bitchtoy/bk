package com.sequoia.baoku.utils;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author Administrator.
 * @date 2018/5/21.
 * @funtion
 */
public class FloationActionBehavie extends FloatingActionButton.Behavior {

    int buttonHeight;

    public FloationActionBehavie(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.buttonHeight = FloatBtnTranslation.getFloatHeight(context);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, FloatingActionButton child, View dependency) {
        return super.layoutDependsOn(parent, child, dependency)||dependency instanceof AppBarLayout;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, FloatingActionButton child, View dependency) {
        if (dependency instanceof AppBarLayout){
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams)
                    child.getLayoutParams();
            int fabBottomMargin = layoutParams.bottomMargin;
            int distanceToScroll = child.getHeight()+fabBottomMargin;
            float ratio= dependency.getY()/buttonHeight;
            child.setTranslationY(-distanceToScroll*ratio);
        }
        return true;
    }
}
