package com.example.baisibudejie.mvp.view.impl;

import com.example.baisibudejie.mvp.view.MvpView;

//请求数据，刷新UI界面监听（标准），就是loading页
public interface MvpAbstractView<M> extends MvpView {
    //显示加载中的视图（监听加载类型）
    public void showLoading(boolean pullToRefresh);
    //显示ContentView
    public void showContent();
    //显示错误信息
    public void showError(Exception e,boolean pullToRefresh);
    //绑定数据
    public void showData(M data);
}
