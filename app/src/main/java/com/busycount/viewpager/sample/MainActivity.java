package com.busycount.viewpager.sample;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.busycount.viewpager.banner.Banner;
import com.busycount.viewpager.sample.R;
import com.busycount.viewpager.sample.adapter.TAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Default
 */
public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TAdapter tAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.viewPager);
        tAdapter = new TAdapter();
        tAdapter.setData(null);
        tAdapter.attachViewPager(viewPager);
    }


    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.button1:
                changeData();
                break;
            case R.id.button2:
                Main2Activity.start(this);
                break;
            case R.id.button3:
                BannerActivity.start(this);
                break;
            default:
                break;
        }
    }


    private void changeData() {
        List<String> list = new ArrayList<>();
        Random random = new Random();
        int m = random.nextInt(100);
        for (int i = m; i < m + 10; i++) {
            list.add("" + i);
        }
        tAdapter.setData(list);
    }
}
