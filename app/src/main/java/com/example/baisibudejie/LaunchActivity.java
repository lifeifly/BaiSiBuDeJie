package com.example.baisibudejie;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class LaunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        //属性动画
        /**target 你要对哪个View绑定动画，对imageView绑定动画
         *propertyNmae 你要执行什么动画属性名称  例如缩放、平移
         *第三个参数  动画的变化范围（例如缩放0.0-1.0之间）
         *
         */
        View target = findViewById(R.id.iv_splash);
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(target, "alpha", 0.0f, 1.0f);
        //设置动画执行时间(一般为2~3秒)
        objectAnimator.setDuration(2000);
        //启动动画
        objectAnimator.start();
        //动画完毕后添加事件结束监听器开启MainActivity
        //这种方法没用的方法太多可以采用适配器
//        objectAnimator.addListener(new Animator.AnimatorListener() {
//            @Override
//            public void onAnimationStart(Animator animation) {
//
//            }
//            //动画结束后执行
//            @Override
//            public void onAnimationEnd(Animator animation) {
//                startActivity(new Intent(LaunchActivity.this,MainActivity.class));
//            }
//
//            @Override
//            public void onAnimationCancel(Animator animation) {
//
//            }
//
//            @Override
//            public void onAnimationRepeat(Animator animation) {
//
//            }
//        });

        //这样只需重写要用的End方法
        objectAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                startActivity(new Intent(LaunchActivity.this, MainActivity.class));
            }
        });
    }
}
