package com.busycount.viewpager;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

/**
 * Cycler
 * <p>
 * 2018/12/28 | Count.C | Created
 */
public class Cycler {

    private static final int DEFAULT_INTERVAL = 3000;

    private int mFlipInterval = DEFAULT_INTERVAL;

    private ViewPager mViewPager;
    private boolean mStarted;
    private boolean mRunning;
    private Handler handler;

    public Cycler(@NonNull ViewPager viewPager) {
        this.mViewPager = viewPager;
        mViewPager.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
            @Override
            public void onViewAttachedToWindow(View v) {
                handler = mViewPager.getHandler();
            }

            @Override
            public void onViewDetachedFromWindow(View v) {
                stop();
            }
        });
    }


    public void setFlipInterval(int interval) {
        this.mFlipInterval = interval;
    }

    public void start() {
        mStarted = true;
        updateRunning();
    }

    public void stop() {
        mStarted = false;
        updateRunning();
    }

    private void updateRunning() {
        if (handler == null) {
            return;
        }
        boolean isVisible = mViewPager.getVisibility() == View.VISIBLE;
        boolean isRunning = isVisible && mStarted;
        if (isRunning != mRunning) {
            if (isRunning) {
                handler.postDelayed(mFlipRunnable, mFlipInterval);
            } else {
                handler.removeCallbacks(mFlipRunnable);
            }
            mRunning = isRunning;
        }
    }

    private void showNext() {
        int size = mViewPager.getChildCount();
        if (size <= 1) {
            return;
        }
        int i = mViewPager.getCurrentItem();
        if (i >= size - 1) {
            i = 0;
        } else {
            i++;
        }
        mViewPager.setCurrentItem(i, i != 0);
    }

    private void t1() {
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    private final Runnable mFlipRunnable = new Runnable() {
        @Override
        public void run() {
            if (mRunning) {
                showNext();
                handler.postDelayed(mFlipRunnable, mFlipInterval);
            }
        }
    };
}
