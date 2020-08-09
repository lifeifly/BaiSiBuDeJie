package com.example.baisibudejie.projects.attention.model;

import android.content.Context;

import com.example.baisibudejie.http.impl.HttpCommand;
import com.example.baisibudejie.http.impl.RequestParam;
import com.example.baisibudejie.http.utils.HttpTask;
import com.example.baisibudejie.http.utils.HttpUtils;
import com.example.baisibudejie.projects.base.model.BaseModel;

public class AttentionSubscriptionModel extends BaseModel {
    private static final String URL_STR="/api/api_open.php";
    public AttentionSubscriptionModel(Context context) {
        super(context);
    }
    public void getAttentionSubscriptionList(int type, HttpUtils.OnHttpResultListener onHttpResultListener){
        RequestParam requestParam=new RequestParam();
        requestParam.put("a","tag_recommend");
        requestParam.put("action","sub");
        requestParam.put("c","topic" );
        requestParam.put("type",type);

        HttpTask httpTask=new HttpTask(getServerUrl().concat(URL_STR),requestParam,onHttpResultListener,new HttpCommand());
        httpTask.execute();
    }
}
