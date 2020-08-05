package com.example.baisibudejie.projects.mine.view.navigation;

import android.content.Context;

import com.example.baisibudejie.R;
import com.example.baisibudejie.projects.base.view.navigation.NavigationBuilderAdapter;

public class MineNavigationBuilder extends NavigationBuilderAdapter {
    public MineNavigationBuilder(Context context) {
        super(context);
    }

    @Override
    public int getLayoutId() {
        return R.layout.toolbar_mine_layout;
    }
}
