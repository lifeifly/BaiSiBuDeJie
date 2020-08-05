package com.example.baisibudejie.projects.attention.view;

import android.view.View;
import android.widget.TextView;

import com.example.baisibudejie.R;
import com.example.baisibudejie.projects.base.view.BaseFragment;

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
        return R.layout.fragment_video_essence;
    }


    @Override
    public void initContentView(View viewContent) {
        TextView textView=(TextView)viewContent.findViewById(R.id.tv_content);
        textView.setText(this.mTitle);
    }

}
