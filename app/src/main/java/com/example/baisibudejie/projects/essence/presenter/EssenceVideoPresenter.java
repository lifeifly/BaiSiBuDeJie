package com.example.baisibudejie.projects.essence.presenter;

import android.content.Context;
import android.text.TextUtils;

import com.example.baisibudejie.bean.PostListBean;
import com.example.baisibudejie.http.utils.HttpUtils;
import com.example.baisibudejie.projects.base.model.BaseModel;
import com.example.baisibudejie.projects.base.presenter.BasePresenter;
import com.example.baisibudejie.projects.essence.model.EssenceVideoModel;

import java.util.List;

//MVP中的P层，处理数据返回之后的逻辑
//例如数据解析等业务逻辑
public class EssenceVideoPresenter extends BasePresenter<EssenceVideoModel> {
    private int page = 0;
    private String maxtime = null;//下拉刷新需要的时间

    public EssenceVideoPresenter(Context context) {
        super(context);
    }

    @Override
    public EssenceVideoModel bindModel() {
        return new EssenceVideoModel(getContext());
    }

    //定义解析方法
    public void getEssenceList(int type,
                               final boolean isDownRefresh,
                               final OnUIThreadListener<List<PostListBean.PostList>> onUIThreadListener) {
        if (isDownRefresh){
            //清空数据
            maxtime=null;
        }
        //执行网络请求
        getModel().getEssenceList(type, page, maxtime, new HttpUtils.OnHttpResultListener() {
            @Override
            public void onResult(String result) {
                if (TextUtils.isEmpty(result)) {
                    //等于空，通知UI线程返回null
                    onUIThreadListener.onResult(null);
                } else {
                    //不等于null解析数据
                    PostListBean postListBean = getGson().fromJson(result, PostListBean.class);
                    //处理分页逻辑--UI只负责显示数据，不要做任何与网络相关的逻辑处理
                    if (postListBean!=null&&postListBean.getInfo()!=null){
                        maxtime=postListBean.getInfo().getMaxtime();
                    }
                    if (isDownRefresh){
                        page=0;
                    }else {
                        page++;
                    }
                    onUIThreadListener.onResult(postListBean.getList());
                }
            }
        });
    }

}
