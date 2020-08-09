package com.example.baisibudejie.projects.attention.view;

import android.view.View;
import android.view.ViewGroup;

import androidx.viewpager.widget.ViewPager;

import com.example.baisibudejie.R;
import com.example.baisibudejie.projects.attention.adapter.AttentionAdapter;
import com.example.baisibudejie.projects.attention.view.navigation.AttentionNavigationBuilder;
import com.example.baisibudejie.projects.base.view.BaseFragment;
import com.example.baisibudejie.utils.ToastUtil;
import com.google.android.material.tabs.TabLayout;

import java.util.Arrays;

public class AttentionFragment extends BaseFragment {
    private ViewPager vp_attention;
    private TabLayout tl_attention;
    @Override
    public int getContentView() {
        return R.layout.fragment_attention;
    }



    @Override
    public void initContentView(View viewContent) {
        initToolBar(viewContent);
        vp_attention=(ViewPager)viewContent.findViewById(R.id.vp_attention);
        tl_attention=(TabLayout)viewContent.findViewById(R.id.tab_attention);
    }

    private void initToolBar(View viewContent) {
        AttentionNavigationBuilder builder = new AttentionNavigationBuilder(getContext());
        builder.setTitleLeftIcon(R.drawable.main_newpost_audit_btn_selector)
                .setLeftIconOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ToastUtil.showToast(getContext(), "点击了");
                    }
                });

        builder.createAndBind((ViewGroup) viewContent);
    }

    @Override
    public void initData() {
        String[] titles=getResources().getStringArray(R.array.attention_video_tab);
        AttentionAdapter adapter=new AttentionAdapter(getFragmentManager(), Arrays.asList(titles));
        vp_attention.setAdapter(adapter);
        tl_attention.setupWithViewPager(vp_attention);
    }
}
