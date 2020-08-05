package com.example.baisibudejie.projects.home.view;

import android.view.View;
import android.widget.TextView;

import com.example.baisibudejie.R;
import com.example.baisibudejie.bean.PostListBean;
import com.example.baisibudejie.mvp.presenter.impl.MvpBasePresenter;
import com.example.baisibudejie.projects.base.presenter.BasePresenter;
import com.example.baisibudejie.projects.base.view.BaseFragment;
import com.example.baisibudejie.projects.home.presenter.EssenceVideoPresenter;
import com.example.baisibudejie.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

public class EssenxeVideoFragment extends BaseFragment {
    private int mType = 0;
    private String mTitle;
    private EssenceVideoPresenter presenter;
    private List<PostListBean.PostList> postLists = new ArrayList<>();

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
        TextView textView = (TextView) viewContent.findViewById(R.id.tv_content);
        textView.setText(this.mTitle);
    }

    private void loadData(boolean isDownRefresh) {
        presenter.getEssenceList(mType, isDownRefresh, new BasePresenter.OnUIThreadListener<List<PostListBean.PostList>>() {

            @Override
            public void onResult(List<PostListBean.PostList> result) {
                if (result == null) {
                    ToastUtil.showToast(getContext(), "加载失败");
                } else {
                    ToastUtil.showToast(getContext(), "加载成功");
                }
            }
        });
    }
}
