package com.busycount.viewpager.sample;

import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * PageScaleTransformer
 * <p>
 * 2018/12/27 | Count.C | Created
 */
public class PageScaleTransformer implements ViewPager.PageTransformer {

    private static final float scale = 0.8f;

    @Override
    public void transformPage(@NonNull View view, float v) {
        if (v < -0.4) {
            view.setScaleX(scale);
            view.setScaleY(scale);
        } else if (v < 0) {
            float scaleT = 1f + v / 2;
            view.setScaleX(scaleT);
            view.setScaleY(scaleT);
        } else if (v <= 0.6) {
            view.setScaleX(1);
            view.setScaleY(1);
        } else if (v <= 1) {
            float scaleT = 1.3f - v / 2;
            view.setScaleX(scaleT);
            view.setScaleY(scaleT);
        } else {
            view.setScaleX(scale);
            view.setScaleY(scale);
        }

    }
}
