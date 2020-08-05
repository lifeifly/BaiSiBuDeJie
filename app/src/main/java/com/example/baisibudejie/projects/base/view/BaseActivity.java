package com.example.baisibudejie.projects.base.view;

import com.example.baisibudejie.mvp.presenter.impl.MvpBasePresenter;
import com.example.baisibudejie.mvp.view.impl.MvpActivity;
//是我们项目的Activity
public abstract class BaseActivity<P extends MvpBasePresenter> extends MvpActivity<P> {
}
