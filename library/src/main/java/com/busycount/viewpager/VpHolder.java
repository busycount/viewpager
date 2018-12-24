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
        initView(itemView);
    }

    protected View getView() {
        return itemView;
    }

    @LayoutRes
    protected abstract int setLayoutId();

    protected abstract void initView(View itemView);

    protected abstract void onBindData(T data);
}
