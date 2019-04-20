package com.busycount.viewpager.sample.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

/**
 * BannerIndicator
 * <p>
 * 2019/4/20 | Count.C | Created
 */
public class BannerIndicator extends View {
    public BannerIndicator(Context context) {
        this(context, null);
    }

    public BannerIndicator(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BannerIndicator(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public BannerIndicator(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private int count;
    private int select;

    private Paint paint;

    private int indicatorPadding;
    private int indicatorSize;

    private void init() {
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        indicatorPadding = getPx(5);
        indicatorSize = getPx(8);
    }

    private int getPx(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, getContext().getResources().getDisplayMetrics());
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(getMeasureSize(widthMeasureSpec, getTargetWidth()), getMeasureSize(heightMeasureSpec, getTargetHeight()));
    }

    private int getTargetWidth() {
        return count * indicatorSize + (count + 1) * indicatorPadding;
    }

    private int getTargetHeight() {
        return indicatorPadding * 2 + indicatorSize;
    }

    private int getMeasureSize(int measureSpec, int defSize) {
        int mode = MeasureSpec.getMode(measureSpec);
        int size = MeasureSpec.getSize(measureSpec);
        if (mode == MeasureSpec.EXACTLY) {
            return size;
        } else if (mode == MeasureSpec.AT_MOST) {
            return Math.min(size, defSize);
        } else {
            return defSize;
        }
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int radius = indicatorSize / 2;
        int cx = indicatorPadding + radius;
        int cy = getHeight() / 2;

        for (int i = 0; i < count; i++) {
            if (i == select) {
                paint.setColor(Color.RED);
            } else {
                paint.setColor(Color.WHITE);
            }
            canvas.drawCircle(cx, cy, radius, paint);
            cx += indicatorPadding + indicatorSize;
        }
    }


    public void setCount(int count) {
        this.count = count;
        requestLayout();
    }

    public void setSelect(int select) {
        this.select = select;
        invalidate();
    }

}