package com.example.baisibudejie;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

public class LaunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        //android6.0及以上需要动态申请权限
        // 你们平时做启动页
        // 总结：
        // 有四种解决方案（企业级开发主要就是这四种方案）
        // 第一种方案：属性动画ObjectAnimator实现－－－－
        // 第二种方案：补间动画实现(例如：TranslateAnimation、ScaleAnimation、AlphaAnimation、RotateAnimation)
        // 第三种方案：定时器Timer实现
        // 第四种方案：Handler+Thread实现－－－AsyncTask封装
        // 今天采用第一种方案
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
