package com.busycount.viewpager.sample.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.busycount.viewpager.sample.R;

/**
 * BannerFragment
 * <p>
 * 2019/4/20 | Count.C | Created
 */
public class VerticalBannerFragment extends Fragment {
    private static final String K_DATA = "k_data";
    private static final String K_DATA_INDEX = "k_data_index";

    String str;
    int position;

    public static VerticalBannerFragment newInstance(int position, String str) {
        Bundle args = new Bundle();
        args.putString(K_DATA, str);
        args.putInt(K_DATA_INDEX, position);
        VerticalBannerFragment fragment = new VerticalBannerFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            str = getArguments().getString(K_DATA);
            position = getArguments().getInt(K_DATA_INDEX);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        log("onCreateView");
        return inflater.inflate(R.layout.item_match, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView textView = view.findViewById(R.id.textView);
        textView.setBackgroundColor(Color.CYAN);
        textView.setText(str);
        log("onViewCreated");
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        log("onActivityCreated");
    }

    @Override
    public void onPause() {
        super.onPause();
        log("onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        log("onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        log("onDestroyView");
    }

    private void log(String action) {
//        if ("0".equals(str) || "1".equals(str)) {
        Log.d("-test-", position + " : " + str + " -> " + action);
//        }
    }
}
