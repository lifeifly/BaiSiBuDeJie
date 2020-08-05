package com.example.baisibudejie.projects.mine.view;

import android.view.View;
import android.view.ViewGroup;

import com.example.baisibudejie.R;
import com.example.baisibudejie.projects.base.view.BaseFragment;
import com.example.baisibudejie.projects.essence.view.navigation.NewPostNavigationBuilder;
import com.example.baisibudejie.projects.mine.view.navigation.MineNavigationBuilder;
import com.example.baisibudejie.utils.ToastUtil;

public class MyFragment extends BaseFragment {
    @Override
    public int getContentView() {
        return R.layout.fragment_my;
    }

    @Override
    public void initContentView(View viewContent) {
    initToolBar(viewContent);
    }

    private void initToolBar(View viewContent) {
        MineNavigationBuilder builder = new MineNavigationBuilder(getContext());
        builder.setTitleIcon(R.drawable.icon_splash)
                .setTitleLeftIcon(R.mipmap.mine_left)
                .setTitleRightIcon(R.mipmap.def)
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
}
