package com.example.baisibudejie.mvp.view.impl;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.baisibudejie.mvp.presenter.impl.MvpBasePresenter;
import com.example.baisibudejie.mvp.view.MvpView;

public abstract class MvpFagment<P extends MvpBasePresenter> extends Fragment implements MvpView {
    protected P presenter;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //绑定视图
        presenter = bindPresenter();
        if (presenter != null) {
            presenter.attachView(this);
        }
    }

    public abstract P bindPresenter();

    public P getPresenter() {
        return presenter;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (presenter != null) {
            presenter.detachView();
        }
    }
}
