package com.example.baisibudejie.mvp.presenter.impl;

import android.content.IntentFilter;

import com.example.baisibudejie.mvp.presenter.MvpPresenter;
import com.example.baisibudejie.mvp.view.MvpView;

public abstract class MvpBasePresenter<V extends MvpView> implements MvpPresenter<V> {
    private V view;
    @Override
    public void attachView(V view) {
        this.view=view;
    }

    @Override
    public void detachView() {
        if (view!=null){
            view=null;
        }
    }
}
