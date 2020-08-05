package com.example.baisibudejie.projects.base.model;

import android.content.Context;

import com.example.baisibudejie.mvp.model.MvpModel;

public abstract class BaseModel implements MvpModel {
    private Context context;


    public BaseModel() {

    }

    public BaseModel(Context context) {
        this.context = context;
    }
public String getServerUrl(){
        return "http://api.budejie.com";
}
}
