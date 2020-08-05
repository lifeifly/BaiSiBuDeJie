package com.example.baisibudejie.projects.attention.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.baisibudejie.projects.essence.view.NewPostVideoFragment;

import java.util.List;

public class AttentionAdapter extends FragmentStatePagerAdapter {
    private static final String TAB_TAG = "@dream@";
    private List<String> mTitles;

    public AttentionAdapter(@NonNull FragmentManager fm, List<String> mTitles) {
        super(fm);
        this.mTitles = mTitles;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        NewPostVideoFragment fragment = new NewPostVideoFragment();
        String[] title = mTitles.get(position).split(TAB_TAG);
        fragment.setmType(Integer.parseInt(title[1]));
        fragment.setmTitle(title[0]);
        return fragment;
    }

    @Override
    public int getCount() {
        return mTitles.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position).split(TAB_TAG)[0];
    }
}