package com.busycount.viewpager.sample;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.busycount.viewpager.VpAdapter;
import com.busycount.viewpager.VpHolder;

/**
 * TAdapter
 * <p>
 * 2018/12/18 | Count.C | Created
 */
public class TAdapter extends VpAdapter<String> {
    @Override
    protected VpHolder<String> onCreateHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        return new THolder(inflater, container);
    }

    class THolder extends VpHolder<String> {

        TextView textView;

        public THolder(LayoutInflater inflater, ViewGroup container) {
            super(inflater, container);
            textView = getView().findViewById(R.id.textView);
        }

        @Override
        public int setLayoutId() {
            return R.layout.item;
        }

        @Override
        public void onBindData(String data) {
            textView.setText(data);
            textView.setBackgroundColor(Color.CYAN);
        }
    }
}
