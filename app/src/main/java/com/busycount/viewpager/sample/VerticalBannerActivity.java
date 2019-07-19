package com.busycount.viewpager.sample;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.busycount.viewpager.banner.Banner;
import com.busycount.viewpager.sample.adapter.VerticalBannerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Vertical Banner
 */
public class VerticalBannerActivity extends AppCompatActivity {

    public static void start(Context context) {
        Intent starter = new Intent(context, VerticalBannerActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner_vertical);
        Banner banner = findViewById(R.id.viewPager);
        VerticalBannerAdapter bannerAdapter = new VerticalBannerAdapter(getSupportFragmentManager(), getData());
        banner.setOnPageSelectListener(new Banner.OnPageSelectListener() {
            @Override
            public void onPageSelected(int page) {
                Log.d("-test-", "page - " + page);
            }
        });
        banner.setBannerAdapter(bannerAdapter);
    }

    private List<String> getData() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add("" + i);
        }
        return list;
    }

}
