package com.example.baisibudejie.projects.newpost.view;

import android.view.View;

import com.example.baisibudejie.R;
import com.example.baisibudejie.projects.base.view.BaseFragment;

public class NewPostVideoFragment extends BaseFragment {
    private int mType=0;
    private String mTitle;

    public void setmType(int mType) {
        this.mType = mType;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    @Override
    public int getContentView() {
        return R.layout.fragment_video_essence;
    }


    @Override
    public void initContentView(View viewContent) {

    }

}
