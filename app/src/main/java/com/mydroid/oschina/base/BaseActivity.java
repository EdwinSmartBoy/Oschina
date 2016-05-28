package com.mydroid.oschina.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * 创建者     林伯任
 * 创建时间   2016/5/13 11:29
 * 描述	      ${TODO}
 * <p/>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        //初始化控件
        initView();
        //初始化数据
        initData();
        //初始化事件
        initEvent();
    }

    /**
     * 一下四个方法为子类必备方法  因此这里定为抽象方法
     */
    public abstract int getLayoutId();

    protected abstract void initView();

    protected abstract void initData();

    protected abstract void initEvent();


}
