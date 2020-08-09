package com.example.baisibudejie.projects.essence.view;

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.andview.refreshview.XRefreshView;
import com.andview.refreshview.XRefreshViewFooter;
import com.example.baisibudejie.R;
import com.example.baisibudejie.bean.PostListBean;
import com.example.baisibudejie.mvp.presenter.impl.MvpBasePresenter;
import com.example.baisibudejie.projects.base.presenter.BasePresenter;
import com.example.baisibudejie.projects.base.view.BaseFragment;
import com.example.baisibudejie.projects.essence.adapter.EssenceVideoAdapter;
import com.example.baisibudejie.projects.essence.presenter.EssenceVideoPresenter;
import com.example.baisibudejie.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

public class EssenxeVideoFragment extends BaseFragment {
    private RecyclerView recyclerView;
    private XRefreshView xRefreshView;
    private EssenceVideoAdapter videoAdapter;
    private List<PostListBean.PostList> postList = new ArrayList<>();

    private int mType = 0;
    private String mTitle;
    private EssenceVideoPresenter presenter;
    public void setmType(int mType) {
        this.mType = mType;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    @Override
    public MvpBasePresenter bindPresenter() {
        presenter = new EssenceVideoPresenter(getContext());
        return presenter;
    }

    @Override
    public int getContentView() {
        return R.layout.fragment_video_essence;
    }

    @Override
    public void initData() {
        loadData(true);
    }

    @Override
    public void initContentView(View viewContent) {
        xRefreshView = (XRefreshView) viewContent.findViewById(R.id.xrefreshview);
        //设置是否可以下拉刷新
        xRefreshView.setPullRefreshEnable(true);
        //设置是否可以上拉加载
        xRefreshView.setPullLoadEnable(true);
        //设置刷新完成以后，headerview固定的时间
        xRefreshView.setPinnedTime(1000);
        //静默加载模式不能设置footview
        //设置支持自动刷新
        xRefreshView.setAutoLoadMore(true);
        //设置静默加载时提前加载的item个数
       xRefreshView.setPreLoadCount(2);

        recyclerView = (RecyclerView) viewContent.findViewById(R.id.recycler_view_test_rv);
        recyclerView.setHasFixedSize(true);
        //设置RecyclerView中item的显示的样式，是网格布局还是线性等
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        videoAdapter = new EssenceVideoAdapter(getContext(), postList);
        recyclerView.setAdapter(videoAdapter);
        //设置上拉加载更多的显示的视图
        videoAdapter.setCustomLoadMoreView(new XRefreshViewFooter(getContext()));
//组件下拉刷新的动作监听器
        xRefreshView.setXRefreshViewListener(new XRefreshView.SimpleXRefreshListener() {
            //下拉刷新
            @Override
            public void onRefresh() {
                loadData(true);
            }

            //上拉加载
            @Override
            public void onLoadMore(boolean isSlience) {
                loadData(false);
            }
        });
    }

    private void loadData(final boolean isDownRefresh) {
        presenter.getEssenceList(mType, isDownRefresh, new BasePresenter.OnUIThreadListener<List<PostListBean.PostList>>() {

            @Override
            public void onResult(List<PostListBean.PostList> result) {
                if (isDownRefresh){
                    xRefreshView.stopRefresh();
                }else {
                    xRefreshView.stopLoadMore();
                }
                if (result == null) {
                    ToastUtil.showToast(getContext(), "加载失败");
                } else {
                    ToastUtil.showToast(getContext(), "加载成功");
                //刷新UI
                    //如果是下拉刷新，清空数据
                if (isDownRefresh){
                    postList.clear();
                }
                postList.addAll(result);
                videoAdapter.notifyDataSetChanged();

                }
            }
        });
    }
}
