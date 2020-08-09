package com.example.baisibudejie.projects.base.presenter;

import android.content.Context;

import com.example.baisibudejie.mvp.presenter.MvpPresenter;
import com.example.baisibudejie.mvp.presenter.impl.MvpBasePresenter;
import com.example.baisibudejie.mvp.view.MvpView;
import com.example.baisibudejie.projects.base.model.BaseModel;
import com.google.gson.Gson;

public abstract class BasePresenter<V extends BaseModel> extends MvpBasePresenter {
    private Context context;
    private Gson gson;
    private V model;

    public BasePresenter(Context context) {
        this.context = context;
        this.gson = new Gson();
        this.model = bindModel();
    }

    public Context getContext() {
        return context;
    }

    public Gson getGson() {
        return gson;
    }

    public V getModel() {
        return model;
    }

    public abstract V bindModel();

    public interface OnUIThreadListener<T> {
        public void onResult(T result);
    }
}
