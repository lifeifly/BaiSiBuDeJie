package com.example.baisibudejie.projects.essence.view;

import android.view.View;
import android.view.ViewGroup;

import androidx.viewpager.widget.ViewPager;

import com.example.baisibudejie.R;
import com.example.baisibudejie.projects.base.view.BaseFragment;
import com.example.baisibudejie.projects.essence.adapter.NewPostAdapter;
import com.example.baisibudejie.projects.essence.view.navigation.NewPostNavigationBuilder;
import com.example.baisibudejie.projects.home.adapter.EssenceAdapter;
import com.example.baisibudejie.utils.ToastUtil;
import com.google.android.material.tabs.TabLayout;

import java.util.Arrays;

public class NewPostFragment extends BaseFragment {
    private TabLayout tab_newpost;
    private ViewPager vp_newpost;
    @Override
    public int getContentView() {
        return R.layout.fragment_newpost;
    }


    @Override
    public void initContentView(View viewContent) {
        initToolBar(viewContent);
        this.tab_newpost=(TabLayout)viewContent.findViewById(R.id.tab_newpost);
        this.vp_newpost=(ViewPager)viewContent.findViewById(R.id.vp_newpost);
    }

    private void initToolBar(View viewContent) {
        NewPostNavigationBuilder builder = new NewPostNavigationBuilder(getContext());
        builder.setTitleIcon(R.drawable.icon_splash)
                .setTitleLeftIcon(R.mipmap.newpost_left)
                .setLeftIconOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ToastUtil.showToast(getContext(),"点击了");
                    }
                })
                .setRightIconOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ToastUtil.showToast(getContext(),"点击了");
                    }
                });

        builder.createAndBind((ViewGroup) viewContent);
    }
    @Override
    public void initData() {
        String[] titles=getResources().getStringArray(R.array.newpost_video_tab);
        NewPostAdapter adapter=new NewPostAdapter(getFragmentManager(), Arrays.asList(titles));
        this.vp_newpost.setAdapter(adapter);
        this.tab_newpost.setupWithViewPager(this.vp_newpost);
    }
}
