package com.example.baisibudejie.projects.attention.view;

import android.view.View;
import android.widget.ListView;

import com.example.baisibudejie.R;
import com.example.baisibudejie.bean.AttentionSubscriptionAdapterBean;
import com.example.baisibudejie.mvp.presenter.impl.MvpBasePresenter;
import com.example.baisibudejie.projects.attention.adapter.AttentionSubscriptionAdapter;
import com.example.baisibudejie.projects.attention.presenter.AttentionSubscriptionPresenter;
import com.example.baisibudejie.projects.base.presenter.BasePresenter;
import com.example.baisibudejie.projects.base.view.BaseFragment;

import java.util.ArrayList;
import java.util.List;
//订阅列表
public class AttentionSubscriptionFragment extends BaseFragment<AttentionSubscriptionPresenter> {
    private int mType=0;
    private String mTitle;

    private AttentionSubscriptionAdapter subscriptionAdapter;
    private List<AttentionSubscriptionAdapterBean> subscriptionAdapterBeanList=new ArrayList<>();


    @Override
    public int getContentView() {
        return R.layout.fragmet_attention_subscription;
    }

    @Override
    public void initContentView(View viewContent) {
        ListView lv_attention=(ListView)viewContent.findViewById(R.id.lv_attention);
        subscriptionAdapter=new AttentionSubscriptionAdapter(getContext(),subscriptionAdapterBeanList);
        lv_attention.setAdapter(subscriptionAdapter);
    }

    public void setmType(int mType) {
        this.mType = mType;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    @Override
    public void initData() {
        loadData(1);
    }

    @Override
    public AttentionSubscriptionPresenter bindPresenter() {
        return new AttentionSubscriptionPresenter(getContext());
    }

    private void loadData(int mType){
        getPresenter().getAttentionSubscriptionList(mType, new BasePresenter.OnUIThreadListener<List<AttentionSubscriptionAdapterBean>>() {
            @Override
            public void onResult(List<AttentionSubscriptionAdapterBean> result) {
                if (result!=null){
                    //刷新适配器
                    subscriptionAdapterBeanList.addAll(result);
                    subscriptionAdapter.notifyDataSetChanged();
                }
            }
        });
    }
}
