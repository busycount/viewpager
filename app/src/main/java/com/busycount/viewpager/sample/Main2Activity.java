package com.busycount.viewpager.sample;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.busycount.viewpager.sample.R;
import com.busycount.viewpager.sample.adapter.TAdapter;
import com.busycount.viewpager.sample.widget.PageScaleTransformer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * PageScaleTransformer
 */
public class Main2Activity extends AppCompatActivity {

    public static void start(Context context) {
        Intent starter = new Intent(context, Main2Activity.class);
        context.startActivity(starter);
    }

    private ViewPager viewPager;
    private TAdapter tAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        viewPager = findViewById(R.id.viewPager);
        viewPager.setPageTransformer(true, new PageScaleTransformer());
        tAdapter = new TAdapter();
        tAdapter.setData(null);
        viewPager.setAdapter(tAdapter);
        changeData();
    }


    public void onClick(View view) {
       changeData();
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
