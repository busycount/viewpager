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

    private final View itemView;

    public VpHolder(View itemView) {
        this.itemView = itemView;
        initView(itemView);
    }

    public VpHolder(LayoutInflater inflater, ViewGroup container, int layoutId) {
        this(inflater.inflate(layoutId, container, false));
    }

    protected View getView() {
        return itemView;
    }

    protected abstract void initView(View itemView);

    protected abstract void onBindData(T data);
}
