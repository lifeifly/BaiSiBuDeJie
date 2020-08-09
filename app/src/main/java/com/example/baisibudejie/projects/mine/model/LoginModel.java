package com.example.baisibudejie.projects.mine.model;

import android.content.Context;

import com.example.baisibudejie.http.impl.HttpCommand;
import com.example.baisibudejie.http.impl.RequestParam;
import com.example.baisibudejie.http.utils.HttpTask;
import com.example.baisibudejie.http.utils.HttpUtils;
import com.example.baisibudejie.projects.base.model.BaseModel;

public class LoginModel extends BaseModel {

    public LoginModel(Context context) {
        super(context);
    }
    public void login(String username, String password, HttpUtils.OnHttpResultListener onHttpResultListener){
        RequestParam requestParam=new RequestParam();
        requestParam.put("username",username);
        requestParam.put("password",password);
        HttpTask httpTask=new HttpTask("http://192.168.57.1:8080/Dream/LoginServlet", requestParam,onHttpResultListener,new HttpCommand()){};
        httpTask.execute();
    }
}
