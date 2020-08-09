package com.example.baisibudejie.projects.mine.view.item;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.baisibudejie.R;

public class DefaultItemBuilder extends AbsItemBuilder {
    private int leftIconRes;
    private int rightIconRes;
    private String leftText;
    private int leftTextRes;
    private View.OnClickListener onClickListener;

    public DefaultItemBuilder(Context context) {
        super(context);
    }

    @Override
    public int getContentView() {
        return R.layout.item_build_default;
    }

    public DefaultItemBuilder setLeftIcon(int leftIconRes) {
        this.leftIconRes = leftIconRes;
        return this;
    }

    public DefaultItemBuilder setRightIconRes(int rightIconRes) {
        this.rightIconRes = rightIconRes;
        return this;
    }

    public DefaultItemBuilder setLeftText(String text) {
        this.leftText = text;
        return this;
    }

    public DefaultItemBuilder setLeftTextRes(int leftTextRes) {
        this.leftTextRes = leftTextRes;
        return this;
    }

    public DefaultItemBuilder setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
        return this;
    }
    @Override
    public View buildAndBind(ViewGroup parent) {
        View view = super.buildAndBind(parent);
        ImageView iv_left = (ImageView) view.findViewById(R.id.iv_left);
        if (leftIconRes >= 0){
            iv_left.setImageResource(leftIconRes);
            iv_left.setVisibility(View.VISIBLE);
        }else{
            iv_left.setVisibility(View.GONE);
        }
        TextView tv_title = (TextView) view.findViewById(R.id.tv_title);
        if (TextUtils.isEmpty(String.valueOf(leftTextRes))){
            tv_title.setVisibility(View.INVISIBLE);
        }else {
            tv_title.setText(leftTextRes);
            tv_title.setVisibility(View.VISIBLE);
        }
        if (onClickListener != null){
            view.setOnClickListener(onClickListener);
        }
        return view;
    }
}
