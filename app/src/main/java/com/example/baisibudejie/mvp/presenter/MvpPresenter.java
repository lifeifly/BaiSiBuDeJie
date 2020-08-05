package com.example.baisibudejie.mvp.presenter;

import com.example.baisibudejie.mvp.view.MvpView;

public interface MvpPresenter<V extends MvpView>{
    //绑定View
    public void attachView(V view);
    //解绑View
    public void detachView();
}
