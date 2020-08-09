package com.example.baisibudejie.projects.newpost.view.navigation;

import android.content.Context;

import com.example.baisibudejie.R;
import com.example.baisibudejie.projects.base.view.navigation.NavigationBuilderAdapter;

public class NewPostNavigationBuilder extends NavigationBuilderAdapter {
    public NewPostNavigationBuilder(Context context) {
        super(context);
    }

    @Override
    public int getLayoutId() {
        return R.layout.toolbar_newpost_layout;
    }
}
