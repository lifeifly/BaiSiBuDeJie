package com.example.baisibudejie.mvp.view.impl;

public  abstract class MvpBaseView<M> implements MvpAbstractView<M>{

    @Override
    public void showLoading(boolean pullToRefresh) {

    }

    @Override
    public void showContent() {

    }

    @Override
    public void showError(Exception e, boolean pullToRefresh) {

    }

    @Override
    public void showData(M data) {

    }
}
