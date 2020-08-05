package com.example.baisibudejie.projects.attention.view.navigation;

import android.content.Context;

import com.example.baisibudejie.R;
import com.example.baisibudejie.projects.base.view.navigation.NavigationBuilderAdapter;

public class AttentionNavigationBuilder extends NavigationBuilderAdapter {
    public AttentionNavigationBuilder(Context context) {
        super(context);
    }

    @Override
    public int getLayoutId() {
        return R.layout.toolbar_attention_layout;
    }
}
