package com.busycount.viewpager;

import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Viewpager holder
 * <p>
 * 2018/12/18 | Count.C | Created
 */
public abstract class VpHolder<T> {
    private View itemView;

    public VpHolder(LayoutInflater inflater, ViewGroup container) {
        itemView = inflater.inflate(setLayoutId(), container, false);
    }

    public View getView() {
        return itemView;
    }

    @LayoutRes
    public abstract int setLayoutId();

    public abstract void onBindData(T data);
}
