package com.example.baisibudejie.projects.essence.model;

import android.content.Context;
import android.text.TextUtils;

import com.example.baisibudejie.http.impl.HttpCommand;
import com.example.baisibudejie.http.impl.RequestParam;
import com.example.baisibudejie.http.utils.HttpTask;
import com.example.baisibudejie.http.utils.HttpUtils;
import com.example.baisibudejie.projects.base.model.BaseModel;

//M层
/*
请求网络数据
加载本地数据
加载SD卡数据等待
 */
public class EssenceVideoModel extends BaseModel {
    public EssenceVideoModel(Context context){
        super(context);

    }
    private String getUrl(){
       return getServerUrl().concat("/api/api_open.php");
    }
    //定义访问精华接口
    //第一：定义Url
    //第二定义接口
    /**
     * 获取精华列表
     * @param type---数据类型(例如:图片  视频  音频  妹子等等)
     * @param page---页码
     * @param maxtime--用于加载更多
     * @param listener---数据回调监听
     */
    public void getEssenceList(int type, int page, String maxtime, HttpUtils.OnHttpResultListener listener){
        RequestParam param=new RequestParam();
        param.put("a","list");
        param.put("c","data");
        param.put("type",type);
        param.put("page",page);
        param.put("maxtime",maxtime);
        if (!TextUtils.isEmpty(maxtime)){
            param.put("maxtime",maxtime);
        }
        //发送请求
        HttpTask httpTask=new HttpTask(getUrl(),
                param,
                listener,
                new HttpCommand());
        httpTask.execute();
    }
}
