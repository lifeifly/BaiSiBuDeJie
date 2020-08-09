package com.example.baisibudejie.projects.attention.presenter;

import android.content.Context;
import android.text.TextUtils;

import com.example.baisibudejie.bean.AttentionSubscriptionAdapterBean;
import com.example.baisibudejie.http.utils.HttpUtils;
import com.example.baisibudejie.projects.attention.model.AttentionSubscriptionModel;
import com.example.baisibudejie.projects.base.presenter.BasePresenter;
import com.example.baisibudejie.utils.GsonUtils;
import com.google.gson.Gson;

import java.util.List;

public class AttentionSubscriptionPresenter extends BasePresenter<AttentionSubscriptionModel> {
    public AttentionSubscriptionPresenter(Context context) {
        super(context);
    }

    @Override
    public AttentionSubscriptionModel bindModel() {
        return new AttentionSubscriptionModel(getContext());
    }

    public void getAttentionSubscriptionList(int type, final OnUIThreadListener<List<AttentionSubscriptionAdapterBean>> onUIThreadListener) {
        getModel().getAttentionSubscriptionList(type, new HttpUtils.OnHttpResultListener() {
            @Override
            public void onResult(String result) {
                if (TextUtils.isEmpty(result)) {
                    onUIThreadListener.onResult(null);
                } else {
                    List<AttentionSubscriptionAdapterBean> list = GsonUtils.getList(result, AttentionSubscriptionAdapterBean.class);
                    onUIThreadListener.onResult(list);
                }
            }
        });
    }
}
