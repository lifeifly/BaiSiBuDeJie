package com.example.baisibudejie.projects.base.presenter;

import android.content.Context;

import com.example.baisibudejie.mvp.presenter.MvpPresenter;
import com.example.baisibudejie.mvp.presenter.impl.MvpBasePresenter;
import com.example.baisibudejie.mvp.view.MvpView;
import com.google.gson.Gson;

public abstract class BasePresenter<V extends MvpView> extends MvpBasePresenter<V> {
    private Context context;
    private Gson gson;
    public BasePresenter(Context context){
        this.context=context;
        this.gson=new Gson();
    }
    public Context getContext(){
        return context;
    }
    public Gson getGson(){
        return gson;
    }
    public interface OnUIThreadListener<T>{
        public void onResult(T result);
    }
}
