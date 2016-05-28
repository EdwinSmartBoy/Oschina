package com.mydroid.oschina.ui;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.mydroid.oschina.R;
import com.mydroid.oschina.base.BaseActivity;
import com.mydroid.oschina.fragment.MessageFragment;

/**
 * 创建者      Created by Edwin
 * 创建时间    2016/05/13
 * 描述        MyFragment的消息跳转界面
 * <p/>
 * 更新者      Edwin
 * 更新时间    ${TODO}
 * 更新描述    ${TODO}
 */
public class MessageActivity extends BaseActivity {

    private FrameLayout mFlContent;

    @Override
    protected void initView() {
        mFlContent = (FrameLayout) findViewById(R.id.fl_content);

        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fl_content, new MessageFragment());
        fragmentTransaction.commit();

        //初始化actionbar
        initActionBar();
    }

    private void initActionBar() {
        ActionBar actionBar = getSupportActionBar();
        //设置返回按钮可见
        actionBar.setDisplayHomeAsUpEnabled(true);
        //设置
        actionBar.setDisplayShowHomeEnabled(true);
        //设置标题
        actionBar.setTitle("消息中心");
    }

    @Override
    protected void initData() {

        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setTitle("消息中心");
        //设置显示系统后退按钮
        supportActionBar.setDisplayHomeAsUpEnabled(true);

    }

    @Override
    protected void initEvent() {
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_message;
    }

    /**
     * actionBar的点击事件  是固定的.
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
