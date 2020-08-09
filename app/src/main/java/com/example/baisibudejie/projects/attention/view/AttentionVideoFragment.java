package com.example.baisibudejie.projects.attention.view;

import android.view.View;
import android.widget.TextView;

import com.example.baisibudejie.R;
import com.example.baisibudejie.projects.base.view.BaseFragment;
//关注列表
public class AttentionVideoFragment extends BaseFragment {
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
        return R.layout.fragment_atttetion_list;
    }


    @Override
    public void initContentView(View viewContent) {

    }

}
