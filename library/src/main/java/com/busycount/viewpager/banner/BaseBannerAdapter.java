package com.busycount.viewpager.banner;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * BaseBannerAdapter
 * <p>
 * 2019/4/20 | Count.C | Created
 */
public abstract class BaseBannerAdapter<T> extends FragmentStatePagerAdapter {
    private List<T> data;
    private List<T> wrapData = new ArrayList<>();

    public BaseBannerAdapter(FragmentManager fm, @NonNull List<T> list) {
        super(fm);
        this.data = list;
        if (list.size() > 1) {
            wrapData.add(list.get(list.size() - 1));
            wrapData.addAll(list);
            wrapData.add(list.get(0));
        } else {
            wrapData.addAll(list);
        }
    }

    @Override
    public int getCount() {
        return wrapData.size();
    }

    @Override
    public Fragment getItem(int position) {
        return getItem(position, wrapData.get(position));
    }

    public abstract Fragment getItem(int position, T data);

    public List<T> getData() {
        return data;
    }
}
