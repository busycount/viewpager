package com.busycount.viewpager.sample;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
        List<String> list = new ArrayList<>();
        Random random = new Random();
        int m = random.nextInt(100);
        for (int i = m; i < m + 10; i++) {
            list.add("" + i);
        }
        tAdapter.setData(list);
    }

}
