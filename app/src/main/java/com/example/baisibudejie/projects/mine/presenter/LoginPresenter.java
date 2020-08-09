package com.example.baisibudejie.projects.mine.presenter;

import android.content.Context;

import com.example.baisibudejie.bean.UserBean;
import com.example.baisibudejie.http.utils.HttpUtils;
import com.example.baisibudejie.projects.base.presenter.BasePresenter;
import com.example.baisibudejie.projects.mine.model.LoginModel;

public class LoginPresenter extends BasePresenter<LoginModel> {
    public LoginPresenter(Context context) {
        super(context);
    }

    @Override
    public LoginModel bindModel() {
        return new LoginModel(getContext());
    }

    public void login(final String username, String password, final OnUIThreadListener<UserBean> onUIThreadListener){
        getModel().login(username, password, new HttpUtils.OnHttpResultListener() {
            @Override
            public void onResult(String result) {
                //解析model
                if(result==null){
                    onUIThreadListener.onResult(null);
                }else {
                    UserBean userBean=getGson().fromJson(result,UserBean.class);
                    onUIThreadListener.onResult(userBean);
                }
            }
        });
    }
}
