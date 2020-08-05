package com.example.baisibudejie.projects.base.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.baisibudejie.mvp.presenter.impl.MvpBasePresenter;
import com.example.baisibudejie.mvp.view.impl.MvpFagment;

public abstract class BaseFragment<P extends MvpBasePresenter> extends MvpFagment<P> {
    //我们自己的Fragment需要缓存视图
    private View viewContent;//缓冲视图
    private boolean isInit;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (viewContent == null) {
            viewContent = inflater.inflate(getContentView(),container,false);
            initContentView(viewContent);
        }
        //判断Fragment对应的Activity是否存在这个视图
        ViewGroup parent=(ViewGroup) viewContent.getParent();
        if (parent!=null){
            //如果存在就去除重新添加，这样就可以缓存视图
            parent.removeView(viewContent);
        }

        return viewContent;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (!isInit){
            this.isInit=true;
            initData();
        }
    }

    @Override
    public P bindPresenter() {
        return null;
    }
    public abstract int getContentView();
    public void initData(){}
    public abstract void initContentView(View viewContent);
}
