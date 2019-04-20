package com.busycount.viewpager.sample.widget;

import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.busycount.viewpager.sample.R;

/**
 * PageScaleTransformer
 * <p>
 * 2018/12/27 | Count.C | Created
 */
public class PageScaleTransformer implements ViewPager.PageTransformer {

    private static final String TAG = "-test-";

    private static final float scale = 0.8f;

    /***
     *  67  -v-> 2.3181818
     *  66  -v-> 1.3181819
     *   65  -v-> 0.3181818
     *   68  -v-> 3.3181818
     *   69  -v-> 4.318182
     */


    @Override
    public void transformPage(@NonNull View view, float v) {
        TextView tv = view.findViewById(R.id.textView);
        Log.d(TAG, "transformPage: " + tv.getText().toString() + "  -v-> " + v);
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
