package com.mydroid.oschina.ui;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.mydroid.oschina.R;
import com.mydroid.oschina.dialog.MyDialog;
import com.mydroid.oschina.fragment.LeftNemuFragment;
import com.mydroid.oschina.util.MainTab;


public class MainActivity extends AppCompatActivity implements
        View.OnClickListener, View.OnTouchListener, TabHost.OnTabChangeListener {

    FrameLayout mFlHomefragment;

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private FrameLayout mFl_content;
    private FragmentTabHost mTabHost;
    private ImageView mIv_plus;
    private FrameLayout mLeftMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置界面布局
        setContentView(R.layout.activity_main);
        //初始化界面
        initView();
        //初始化ActionBar
        initActionBar();
        //初始化数据
        initData();
    }

    /**
     * @desc 初始化数据
     */
    private void initData() {

    }

    /**
     * @desc 初始化界面
     */
    private void initView() {

        //获取界面组件
        mLeftMenu = (FrameLayout) findViewById(R.id.left_menu);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.main_drawer_layout);
        mFl_content = (FrameLayout) findViewById(R.id.fl_content);
        mTabHost = (FragmentTabHost) findViewById(R.id.tabhost);
        mIv_plus = (ImageView) findViewById(R.id.iv_plussign);

        //替换左侧的菜单
        getSupportFragmentManager().beginTransaction().replace(R.id.left_menu,new LeftNemuFragment()).commit();

        //初始化底部tabhost
        mTabHost.setup(this, getSupportFragmentManager(), R.id.fl_content);
        //去掉tabs之间的线
        if (android.os.Build.VERSION.SDK_INT > 10) {
            mTabHost.getTabWidget().setShowDividers(0);
        }
        //初始化tab
        initTab();

        // 中间按键图片触发
        mIv_plus.setOnClickListener(this);
        mIv_plus.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {



                return true;
            }
        });
        //设置默认选择综合按钮
        mTabHost.setCurrentTab(0);
        //监听tab状态变化
        mTabHost.setOnTabChangedListener(this);
    }

    private void initTab() {
        MainTab[] values = MainTab.values();
        for (int i = 0; i < values.length; i++) {

            //找到每个枚举的对象
            MainTab mainTab = values[i];
            //创建一个新的选项卡
            TabHost.TabSpec tabSpec = mTabHost.newTabSpec(mainTab.getResName());
            View indicator = LayoutInflater.from(this).inflate(R.layout.tab_indicator, null);
            TextView title = (TextView) indicator.findViewById(R.id.tab_title);
            Drawable drawable = this.getResources().getDrawable(mainTab.getResIcon());
            title.setCompoundDrawablesWithIntrinsicBounds(null, drawable, null, null);
            if (i == 2) {
                indicator.setVisibility(View.INVISIBLE);
            }
            title.setText(mainTab.getResName());
            tabSpec.setIndicator(indicator);
            tabSpec.setContent(new TabHost.TabContentFactory() {

                @Override
                public View createTabContent(String tag) {
                    return new View(MainActivity.this);
                }
            });


            Bundle bundle = new Bundle();
            bundle.putString("key", "content: " + mainTab.getResName());
            // 2. 把新的选项卡添加到TabHost中
            mTabHost.addTab(tabSpec, mainTab.getClazz(), bundle);

            mTabHost.getTabWidget().getChildAt(i).setOnTouchListener(this);

        }
    }


    /**
     * @desc 设置ActionBar
     */
    private void initActionBar() {
        //V7兼容包下的ActionBar
        ActionBar supportActionBar = getSupportActionBar();
        //设置标题栏
        supportActionBar.setTitle("开源中国");
        //设置显示系统后退按钮
        supportActionBar.setDisplayHomeAsUpEnabled(true);
        //设置按钮
        initActionBarDrawerToggle();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }

    @Override
    public void onClick(View v) {

        MyDialog dialog = new MyDialog(this);

        dialog.show();

    }

    @Override
    public void onTabChanged(String tabId) {

    }

    /**
     * @desc 设置回退按钮
     */
    private void initActionBarDrawerToggle() {

        //获取回退按钮的对象
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);

        //设置按钮的同步
        mToggle.syncState();

        //设置拖动侧滑菜单栏时能够按钮能够跟着改变状态
        mDrawerLayout.addDrawerListener(mToggle);
    }

    /**
     * @param item
     * @return
     * @desc 设置按钮的点击事件
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                //当点击按钮时,让侧滑菜单跟着一起开启或关闭
                mToggle.onOptionsItemSelected(item);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == event.KEYCODE_BACK) {

        }
        return super.onKeyDown(keyCode, event);
    }
}
