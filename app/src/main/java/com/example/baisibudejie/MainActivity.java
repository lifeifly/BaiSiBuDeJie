package com.example.baisibudejie;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTabHost;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.baisibudejie.projects.attention.view.AttentionFragment;
import com.example.baisibudejie.projects.essence.view.NewPostFragment;
import com.example.baisibudejie.projects.home.view.EssenceFragment;
import com.example.baisibudejie.projects.mine.view.MyFragment;
import com.example.baisibudejie.projects.publish.view.PublishFragment;
import com.example.baisibudejie.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<TabItem> tabItemsList;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //android6.0及以上选哟动态申请网络权限
        initTabData();
        initTabHost();
    }

    //初始化Tab数据
    private void initTabData() {
        tabItemsList = new ArrayList<TabItem>();
        //添加首页标签选项
        tabItemsList.add(new TabItem(R.mipmap.bdj_main_bottom_home_page_normal,
                R.mipmap.bdj_main_bottom_home_page_press, R.string.main_home_text, EssenceFragment.class));
        //添加精华
        tabItemsList.add(new TabItem(R.mipmap.bdj_main_bottom_community_normal,
                R.mipmap.bdj_main_bottom_community_press, R.string.main_essence_text, NewPostFragment.class));
        //添加发布
        tabItemsList.add(new TabItem(R.mipmap.bdj_main_bottom_publish_normal,
                R.mipmap.bdj_main_bottom_publish_normal, R.string.main_publish_text, PublishFragment.class));
        //添加关注
        tabItemsList.add(new TabItem(R.mipmap.bdj_main_bottom_attention_normal,
                R.mipmap.bdj_main_bottom_attention_press, R.string.main_attention_text, AttentionFragment.class));
        //添加我的
        tabItemsList.add(new TabItem(R.mipmap.bdj_main_bottom_my_normal,
                R.mipmap.bdj_main_bottom_my_press, R.string.main_mine_text, MyFragment.class));
    }

    //初始化主页选项卡视图
    @RequiresApi(api = Build.VERSION_CODES.M)
    private void initTabHost() {
        //获取FragmentTabHost
        FragmentTabHost tabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        //绑定TabHost(绑定我们的tabContent)
        tabHost.setup(this, getSupportFragmentManager(),android.R.id.tabcontent);
        //去掉分割线
        tabHost.getTabWidget().setDividerDrawable(null);
        for (int i = 0; i < tabItemsList.size(); i++) {
            final TabItem tabItem = tabItemsList.get(i);
            //将Fragment添加到FragmentTabHost组件上
            /**newtabspec:代表Tab的名字
             * setIndicator:图片，本次采用布局文件（tab的样式自己做）
             */
            TabHost.TabSpec tabSpec = tabHost.newTabSpec(tabItem.getTitleString())
                    .setIndicator(tabItem.getView());
            //添加Fragment
            /**tabSpec:选项卡
             * tabItem.getFragmentClass()：具体的Fragment类
             * tabItem.getBundle():给Fragment传递的参数
             */
            tabHost.addTab(tabSpec, tabItem.getFragmentClass(), tabItem.getBundle());
            //给tab的按钮设置背景
            tabHost.getTabWidget().getChildAt(i).setBackgroundColor(getColor(R.color.main_bottom_bg));
            //为FragmentTabHost添加监听，实现切换选项卡
            tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
                @Override
                public void onTabChanged(String tabId) {
                    ToastUtil.showToast(MainActivity.this, tabId);
                    //循环重置Tab样式
                    for (int i = 0; i < tabItemsList.size(); i++) {
                        //判断选中的TabId是哪个Tab
                        TabItem tabItem1 = tabItemsList.get(i);
                        if (tabItem1.getTitleString().equals(tabId)) {
                            //选中设置为选中状态
                            tabItem1.setCheckde(true);
                        } else {
                            //没有选中，设置为正常
                            tabItem1.setCheckde(false);
                        }
                    }
                }
            });
            //默认选中第一个Tab
            if (i == 0) {
                tabItem.setCheckde(true);
            }
        }
    }

    //代表每个tab
    class TabItem {
        //自定义的tab选项布局加载的View
        private View view;
        //自定义的tab选项上的两个组件
        private ImageView imageView;
        private TextView textView;

        //正常情况下显示的图片
        private int imageNormal;
        //选中情况下显示的图片
        private int imagePress;
        //tab的名字
        private int title;
        private String titleString;
        private Class<? extends Fragment> fragmentClass;
        //需要传给tabHost中的类的参数
        private Bundle bundle;

        public TabItem(int imageNormal, int imagePress, int title, Class<? extends Fragment> fragmentClass) {
            this.imageNormal = imageNormal;
            this.imagePress = imagePress;
            this.title = title;
            this.fragmentClass = fragmentClass;
        }

        public int getImageNormal() {
            return imageNormal;
        }

        public int getImagePress() {
            return imagePress;
        }

        public int getTitle() {
            return title;
        }

        public String getTitleString() {
            if (title == 0) {
                return "";
            }
            if (TextUtils.isEmpty(titleString)) {
                titleString = getString(title);
            }
            return titleString;
        }

        public Class<? extends Fragment> getFragmentClass() {
            return fragmentClass;
        }

        public Bundle getBundle() {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putString("title", getTitleString());
            return bundle;
        }

        //切换tab样式的方法
        @RequiresApi(api = Build.VERSION_CODES.M)
        public void setCheckde(boolean isChecked) {
            if (imageView != null) {
                if (isChecked) {
                    imageView.setImageResource(imagePress);
                } else {
                    imageView.setImageResource(imageNormal);
                }
            }
            if (textView != null && title != 0) {
                if (isChecked) {
                    textView.setTextColor(getColor(R.color.main_bottom_text_select));
                } else {
                    textView.setTextColor(getColor(R.color.main_bottom_text_normal));
                }
            }
        }

        public View getView() {
            if (this.view == null) {
                this.view = getLayoutInflater().inflate(R.layout.tabhost_item_layout, null);
                textView = this.view.findViewById(R.id.tab_tv_text);
                imageView = this.view.findViewById(R.id.tab_iv_image);
                //判断资源是否存在，不存在就隐藏
                if (this.title == 0) {
                    this.textView.setVisibility(View.GONE);
                } else {
                    this.textView.setVisibility(View.VISIBLE);
                    this.textView.setText(getTitleString());
                }
                //绑定图片默认资源
                this.imageView.setImageResource(imageNormal);
            }
            return view;
        }
    }
}
