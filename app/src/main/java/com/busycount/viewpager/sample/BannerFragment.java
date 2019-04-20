package com.busycount.viewpager.sample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * BannerFragment
 * <p>
 * 2019/4/20 | Count.C | Created
 */
public class BannerFragment extends Fragment {
    private static final String K_DATA = "k_data";

    String str;

    public static BannerFragment newInstance(String str) {
        Bundle args = new Bundle();
        args.putString(K_DATA, str);
        BannerFragment fragment = new BannerFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            str = getArguments().getString(K_DATA);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.item, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView textView = view.findViewById(R.id.textView);
        textView.setBackgroundColor(Color.CYAN);
        textView.setText(str);
    }
}
