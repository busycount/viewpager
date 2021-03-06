package com.busycount.viewpager.sample;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.busycount.viewpager.banner.Banner;
import com.busycount.viewpager.sample.adapter.BannerAdapter;
import com.busycount.viewpager.sample.widget.PageScaleTransformer;

import java.util.ArrayList;
import java.util.List;

/**
 * Banner
 */
public class BannerActivity extends AppCompatActivity {

    public static void start(Context context) {
        Intent starter = new Intent(context, BannerActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner);
        Banner banner = findViewById(R.id.viewPager);
        banner.setPageTransformer(true, new PageScaleTransformer());
        BannerAdapter bannerAdapter = new BannerAdapter(getSupportFragmentManager(), getData());
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
