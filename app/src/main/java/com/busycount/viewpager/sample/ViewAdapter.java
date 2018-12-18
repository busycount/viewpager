package com.busycount.viewpager.sample;

import android.database.DataSetObserver;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * ViewAdapter
 * <p>
 * 2018/12/12 | Count.C | Created
 */
public class ViewAdapter extends PagerAdapter {

    private List<String> oldList = new ArrayList<>();
    private List<String> dataList = new ArrayList<>();
    private SparseArray<View> viewArray = new SparseArray<>();

    public void setDataList(List<String> dataList) {
        oldList.clear();
        oldList.addAll(this.dataList);
        this.dataList.clear();
        if (dataList != null) {
            this.dataList.addAll(dataList);
        }
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

//    @Override
//    public int getItemPosition(@NonNull Object object) {
//        if (object instanceof View) {
//            int position = (int) ((View) object).getTag(R.id.viewpager_position);
//            if (position > oldList.size() || position > dataList.size() || oldList.size() == 0 || dataList
//                    .size() == 0) {
//                return POSITION_NONE;
//            }
//            String oleData = oldList.get(position);
//            String newData = dataList.get(position);
//            if (oleData.equals(newData)) {
//                return POSITION_UNCHANGED;
//            } else {
//                return POSITION_NONE;
//            }
//        } else {
//            return POSITION_NONE;
//        }
//    }


    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }

    int i = 0;

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = getView(container, position);
        setData(view, position);
        container.addView(view);
        return view;
    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        initInflater(container);
        container.removeView((View) object);
    }

    private LayoutInflater inflater;

    private void initInflater(@NonNull View view) {
        if (inflater == null) {
            inflater = LayoutInflater.from(view.getContext());
        }
    }

    private View getView(@NonNull ViewGroup viewGroup, int position) {
        initInflater(viewGroup);
        int cacheIndex = position % 5;
        View view = viewArray.get(cacheIndex);
        if (view == null) {
            view = inflater.inflate(R.layout.item, viewGroup, false);
            viewArray.put(cacheIndex, view);
        }
        return view;
    }

    private void setData(View view, int position) {
        view.setTag(R.id.viewpager_position, position);
        TextView textView = view.findViewById(R.id.textView);
        textView.setText(dataList.get(position));
        textView.setBackgroundColor(Color.CYAN);
    }
}
