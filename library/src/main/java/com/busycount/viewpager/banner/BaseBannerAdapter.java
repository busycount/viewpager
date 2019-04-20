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
    private List<T> list;
    private List<T> list_wrap = new ArrayList<>();

    public BaseBannerAdapter(FragmentManager fm, @NonNull List<T> list) {
        super(fm);
        this.list = list;
        if (list.size() > 1) {
            list_wrap.add(list.get(list.size() - 1));
            list_wrap.addAll(list);
            list_wrap.add(list.get(0));
        } else {
            list_wrap.addAll(list);
        }
    }

    @Override
    public int getCount() {
        return list_wrap.size();
    }

    @Override
    public Fragment getItem(int i) {
        return getItem(i, list_wrap.get(i));
    }

    public abstract Fragment getItem(int i, T data);

    public List<T> getData() {
        return list;
    }
}
