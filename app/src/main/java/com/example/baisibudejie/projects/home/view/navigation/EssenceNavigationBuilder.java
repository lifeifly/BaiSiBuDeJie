package com.example.baisibudejie.projects.home.view.navigation;

import android.content.Context;

import com.example.baisibudejie.R;
import com.example.baisibudejie.projects.base.view.navigation.NavigationBuilderAdapter;

public class EssenceNavigationBuilder extends NavigationBuilderAdapter {
    public EssenceNavigationBuilder(Context context) {
        super(context);
    }

    @Override
    public int getLayoutId() {
        return R.layout.toolbar_essence_layout;
    }
}
