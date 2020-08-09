package com.example.baisibudejie.projects.attention.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.baisibudejie.projects.attention.view.AttentionSubscriptionFragment;
import com.example.baisibudejie.projects.attention.view.AttentionVideoFragment;
import com.example.baisibudejie.projects.newpost.view.NewPostVideoFragment;

import java.util.List;
//关注适配器--初始化ViewPager，加载Fragment
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
        if (position==0) {
            AttentionSubscriptionFragment fragment = new AttentionSubscriptionFragment();
            String[] title = mTitles.get(position).split(TAB_TAG);
            fragment.setmType(Integer.parseInt(title[1]));
            fragment.setmTitle(title[0]);
            return fragment;
        }
        AttentionVideoFragment fragment = new AttentionVideoFragment();
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
