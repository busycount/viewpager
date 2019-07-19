package com.busycount.viewpager.banner;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.animation.Interpolator;
import android.widget.Scroller;

import java.lang.reflect.Field;

/**
 * ViewPagerScroller
 * <p>
 * 2019/7/19 | Count.C | Created
 */
public class ViewPagerScroller  extends Scroller {
    private int mDuration = 2000;/*default duration time*/

    /**
     * Set custom duration time.
     * @param duration duration
     */
    public void setScrollDuration(int duration){
        mDuration = duration;
    }


    public ViewPagerScroller(Context context) {
        super(context);
    }

    public ViewPagerScroller(Context context, Interpolator interpolator) {
        super(context, interpolator);
    }

    public ViewPagerScroller(Context context, Interpolator interpolator, boolean flywheel) {
        super(context, interpolator, flywheel);
    }


    @Override
    public void startScroll(int startX, int startY, int dx, int dy) {
        super.startScroll(startX, startY, dx, dy,mDuration);
    }

    @Override
    public void startScroll(int startX, int startY, int dx, int dy, int duration) {
        super.startScroll(startX, startY, dx, dy, mDuration);
    }

}
