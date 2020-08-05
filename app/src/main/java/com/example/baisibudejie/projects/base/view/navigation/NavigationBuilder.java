package com.example.baisibudejie.projects.base.view.navigation;

import android.view.View;
import android.view.ViewGroup;

//构建ToolBar---Builder设计模式
public interface NavigationBuilder {
    public NavigationBuilder setTitle(String title);

    public NavigationBuilder setTitle(int title);

    public NavigationBuilder setTitleIcon(int iconRes);

    public NavigationBuilder setTitleLeftIcon(int iconRes);

    public NavigationBuilder setTitleRightIcon(int iconRes);

    public NavigationBuilder setLeftIconOnClickListener(View.OnClickListener listener);

    public NavigationBuilder setRightIconOnClickListener(View.OnClickListener listener);

    public void createAndBind(ViewGroup parent);
}
