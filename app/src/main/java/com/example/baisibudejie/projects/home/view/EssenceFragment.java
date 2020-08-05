package com.example.baisibudejie.projects.home.view;

import android.view.View;
import android.view.ViewGroup;

import androidx.viewpager.widget.ViewPager;

import com.example.baisibudejie.R;
import com.example.baisibudejie.projects.base.view.BaseFragment;
import com.example.baisibudejie.projects.home.adapter.EssenceAdapter;
import com.example.baisibudejie.projects.home.view.navigation.EssenceNavigationBuilder;
import com.example.baisibudejie.utils.ToastUtil;
import com.google.android.material.tabs.TabLayout;

import java.util.Arrays;

public class EssenceFragment extends BaseFragment {
    private TabLayout tab_essence;
    private ViewPager vp_essence;
    @Override
    public int getContentView() {
        return R.layout.fragment_essence;
    }

    @Override
    public void initContentView(View viewContent) {
    initToolBar(viewContent);
    this.tab_essence=(TabLayout)viewContent.findViewById(R.id.tab_essence);
    this.vp_essence=(ViewPager)viewContent.findViewById(R.id.vp_essence);
    }
    private void initToolBar(View viewContent) {
        EssenceNavigationBuilder builder = new EssenceNavigationBuilder(getContext());
        builder.setTitleIcon(R.drawable.icon_splash)
                .setTitleLeftIcon(R.mipmap.essence_left)
                .setTitleRightIcon(R.mipmap.essence_right)
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
        String[] titles=getResources().getStringArray(R.array.essence_video_tab);
        EssenceAdapter adapter=new EssenceAdapter(getFragmentManager(), Arrays.asList(titles));
        this.vp_essence.setAdapter(adapter);
        this.tab_essence.setupWithViewPager(this.vp_essence);
    }
}
