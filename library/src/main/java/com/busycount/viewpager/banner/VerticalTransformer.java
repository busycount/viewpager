package com.busycount.viewpager.banner;

import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * VerticalTransformer
 * <p>
 * 2019/7/19 | Count.C | Created
 */
public class VerticalTransformer implements ViewPager.PageTransformer {
    @Override
    public void transformPage(@NonNull View view, float position) {
//        float alpha = 0;
//        if (0 <= position && position <= 1) {
//            alpha = 1 - position;
//        } else if (-1 < position && position < 0) {
//            alpha = position + 1;
//        }
//        view.setAlpha(alpha);
        view.setTranslationX(view.getWidth() * -position);
        float yPosition = position * view.getHeight();
        view.setTranslationY(yPosition);
    }
}
