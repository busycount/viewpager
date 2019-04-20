package com.busycount.viewpager.banner;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.busycount.viewpager.R;

/**
 * Banner
 * 原理：3-1-2-3-1
 * <p>
 * 2019/4/20 | Count.C | Created
 */
public class Banner extends ViewPager {
    public Banner(@NonNull Context context) {
        this(context, null);
    }

    public Banner(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    private int currentIndex;
    private BaseBannerAdapter bannerAdapter;
    private OnPageSelectListener onPageSelectListener;
    private boolean isStart;
    private long duration;


    private void init(@Nullable AttributeSet attrs) {

        TypedArray ta = getContext().obtainStyledAttributes(attrs, R.styleable.Banner);
        duration = ta.getInteger(R.styleable.Banner_duration, 3000);
        ta.recycle();
        if (duration < 1500) {
            duration = 1500;
        }


        addOnPageChangeListener(new OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                onBannerSelect(i);
                currentIndex = i;
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    private void onBannerSelect(int position) {
        if (bannerAdapter == null) {
            return;
        }
        if (position == 0) {
            setFix(bannerAdapter.getCount() - 2);
        } else if (position == bannerAdapter.getCount() - 1) {
            setFix(1);
        } else {
            if (onPageSelectListener != null) {
                onPageSelectListener.onPageSelected(position - 1);
            }
        }
    }

    public void setBannerAdapter(@NonNull BaseBannerAdapter bannerAdapter) {
        this.bannerAdapter = bannerAdapter;
        setAdapter(bannerAdapter);
        setCurrentItem(1);
        if (bannerAdapter.getCount() > 1) {
            startFlipping();
        }
    }

    /**
     * banner 修正页面
     */
    private void setFix(final int position) {
        postDelayed(new Runnable() {
            @Override
            public void run() {
                setCurrentItem(position, false);
            }
        }, 200);
    }


    /**
     * 开始轮播
     */
    public void startFlipping() {
        if (!isStart) {
            runFlipping();
        }
    }

    /**
     * 停止轮播
     */
    public void stopFlipping() {
        isStart = false;
        removeCallbacks(runnable);
    }

    /**
     * 执行轮播
     */
    private void runFlipping() {
        isStart = true;
        postDelayed(runnable, duration);
    }

    /**
     * 轮播任务
     */
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            setCurrentItem(currentIndex + 1, true);
            runFlipping();
        }
    };

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                stopFlipping();
                break;
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                startFlipping();
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    protected void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
        if (visibility == VISIBLE) {
            startFlipping();
        } else {
            stopFlipping();
        }
    }


    public interface OnPageSelectListener {
        void onPageSelected(int page);
    }

    public void setOnPageSelectListener(OnPageSelectListener onPageSelectListener) {
        this.onPageSelectListener = onPageSelectListener;
    }
}