package com.example.baisibudejie.mvp.view.impl;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.baisibudejie.mvp.presenter.impl.MvpBasePresenter;
import com.example.baisibudejie.mvp.view.MvpView;

//将MVP架构集成到Activity
public abstract class MvpActivity<P extends MvpBasePresenter> extends AppCompatActivity implements MvpView {
    //MVP架构P是动态的
   protected P presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter=bindPresenter();
        //我的presenter是不是关联View
        if (presenter!=null){
            presenter.attachView(this);
        }
    }
    //具体的实现我不知道，我让别人实现
    public abstract P bindPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Activity销毁的时候解除绑定
        if (presenter!=null){
            presenter.detachView();
        }
    }
}
