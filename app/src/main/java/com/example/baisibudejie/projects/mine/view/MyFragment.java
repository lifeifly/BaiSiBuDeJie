package com.example.baisibudejie.projects.mine.view;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;

import com.example.baisibudejie.R;
import com.example.baisibudejie.projects.base.view.BaseFragment;
import com.example.baisibudejie.projects.mine.view.item.DefaultItemBuilder;
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
        initItem(viewContent);
    }

    private void initToolBar(View viewContent) {
        MineNavigationBuilder builder = new MineNavigationBuilder(getContext());
        builder.setRightIconOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showToast(getContext(), "点击了");
            }
        });

        builder.createAndBind((ViewGroup) viewContent);
    }

    private void initItem(View viewContent) {
        DefaultItemBuilder defaultItemBuilder = new DefaultItemBuilder(getContext());
        defaultItemBuilder.setLeftIcon(R.drawable.login_unlogin_header)
                .setLeftTextRes(R.string.login_login_text)
                .setRightIconRes(R.drawable.item_jiantou)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getActivity(), LoginActivity.class));
                    }
                });
        defaultItemBuilder.buildAndBind((ViewGroup) viewContent);
    }
}
