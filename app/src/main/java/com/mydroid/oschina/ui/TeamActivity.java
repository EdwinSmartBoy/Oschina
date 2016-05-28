package com.mydroid.oschina.ui;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.mydroid.oschina.R;

/**
 * 创建者     林伯任
 * 创建时间   2016/5/17 16:54
 * 描述	      ${TODO}
 * <p/>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public class TeamActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pager_loading);

       android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        //设置返回按钮可见
        actionBar.setDisplayHomeAsUpEnabled(true);
        //设置
        actionBar.setDisplayShowHomeEnabled(true);
        //设置标题
        actionBar.setTitle("团队");

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
                //点击了actionbar上面的返回按钮  就关闭自己
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
