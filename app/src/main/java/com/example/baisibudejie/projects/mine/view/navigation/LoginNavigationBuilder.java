package com.example.baisibudejie.projects.mine.view.navigation;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.example.baisibudejie.R;
import com.example.baisibudejie.projects.base.view.navigation.NavigationBuilderAdapter;

public class LoginNavigationBuilder extends NavigationBuilderAdapter {
    private View.OnClickListener titleOnClickListener;

    public LoginNavigationBuilder(Context context){
        super(context);
    }

    @Override
    public int getLayoutId() {
        return R.layout.toolbar_login_layout;
    }

    public LoginNavigationBuilder setTitleOnClickListener(View.OnClickListener titleOnClickListener) {
        this.titleOnClickListener = titleOnClickListener;
        return this;
    }

    @Override
    public void createAndBind(ViewGroup parent) {
        super.createAndBind(parent);
        setImageViewStyle(R.id.iv_left,getLeftIconRes(),getLeftIconOnClickListener());
        setTitleTextView(R.id.iv_title,getTitle(),titleOnClickListener);
    }
}
