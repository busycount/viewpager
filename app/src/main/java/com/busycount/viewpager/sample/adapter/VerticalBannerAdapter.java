package com.busycount.viewpager.sample.adapter;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.busycount.viewpager.banner.BaseBannerAdapter;
import com.busycount.viewpager.sample.fragments.BannerFragment;
import com.busycount.viewpager.sample.fragments.VerticalBannerFragment;

import java.util.List;

/**
 * BannerAdapter
 * <p>
 * 2019/4/20 | Count.C | Created
 */
public class VerticalBannerAdapter extends BaseBannerAdapter<String> {

    public VerticalBannerAdapter(FragmentManager fm, @NonNull List<String> list) {
        super(fm, list);
    }

    @Override
    public Fragment getItem(int position, String data) {
        return VerticalBannerFragment.newInstance(position, data);
    }
}
