package com.busycount.viewpager;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Viewpager Adapter
 * <p>
 * 2018/12/18 | Count.C | Created
 */
public abstract class VpAdapter<T> extends PagerAdapter {

    private List<T> dataList = new ArrayList<>();
    private SparseArray<VpHolder<T>> holderArray = new SparseArray<>();
    private int cacheSize = 1;
    private LayoutInflater inflater;

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        return getHolderView(container, position);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        VpHolder holder = getHolder(position);
        if (holder != null) {
            container.removeView(holder.getView());
        } else {
            container.removeView((View) object);
        }
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }

    private View getHolderView(@NonNull ViewGroup container, int position) {
        VpHolder<T> holder = getHolder(position);
        if (holder == null) {
            if (inflater == null) {
                inflater = LayoutInflater.from(container.getContext());
            }
            holder = onCreateHolder(inflater, container);
            holderArray.put(position % cacheSize, holder);
        }
        holder.onBindData(dataList.get(position));
        View view = holder.getView();
        container.addView(view);
        return view;
    }

    private VpHolder<T> getHolder(int position) {
        return holderArray.get(position % cacheSize);
    }

    protected abstract VpHolder<T> onCreateHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup container);

    public final void attachViewPager(ViewPager viewPager) {
        this.cacheSize = 2 * (viewPager.getOffscreenPageLimit() + 1);
        viewPager.setAdapter(this);
    }

    public final void setData(List<T> newData) {
        dataList.clear();
        if (newData != null) {
            dataList.addAll(newData);
        }
        notifyDataSetChanged();
    }
}
