package com.example.baisibudejie.projects.mine.view;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.baisibudejie.R;
import com.example.baisibudejie.bean.UserBean;
import com.example.baisibudejie.mvp.presenter.impl.MvpBasePresenter;
import com.example.baisibudejie.projects.base.presenter.BasePresenter;
import com.example.baisibudejie.projects.base.view.BaseActivity;
import com.example.baisibudejie.projects.base.view.BaseFragment;
import com.example.baisibudejie.projects.mine.presenter.LoginPresenter;
import com.example.baisibudejie.projects.mine.view.navigation.LoginNavigationBuilder;
import com.example.baisibudejie.utils.ToastUtil;

public class LoginActivity extends BaseActivity {
    private LoginPresenter loginPresenter;

    private EditText et_phone;
    private EditText et_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    @Override
    public MvpBasePresenter bindPresenter() {
        loginPresenter = new LoginPresenter(this);
        return loginPresenter;
    }
public void initToolBar(){
    LinearLayout ll_login=(LinearLayout)findViewById(R.id.ll_login);
    LoginNavigationBuilder builder=new LoginNavigationBuilder(this);
    builder.setTitleLeftIcon(R.drawable.login_close_selector)
            .setTitle(R.string.login_and_register_text)
            .setLeftIconOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
    builder.createAndBind(ll_login);
}
    private void initView() {
        et_phone = (EditText) findViewById(R.id.et_phone);
        et_password = (EditText) findViewById(R.id.et_password);
        findViewById(R.id.bt_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.login(et_phone.getText().toString(),
                        et_password.getText().toString(),
                        new BasePresenter.OnUIThreadListener<UserBean>() {
                    @Override
                    public void onResult(UserBean result) {
                        if (result==null){
                            ToastUtil.showToast(LoginActivity.this,"登录失败");
                        }else {
                            ToastUtil.showToast(LoginActivity.this,"登录成功");
                        }
                    }
                });
            }
        });
    }
}
