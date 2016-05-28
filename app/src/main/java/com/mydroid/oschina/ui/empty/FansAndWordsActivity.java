package com.mydroid.oschina.ui.empty;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.TextView;

import com.mydroid.oschina.R;
import com.mydroid.oschina.base.BaseActivity;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * 创建者     陈长旋
 * 创建时间   2016/05/17
 * 描述	      消息中的留言和粉丝界面的详情跳转
 * <p/>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public class FansAndWordsActivity extends BaseActivity {
    @InjectView(R.id.tv_detail)
    TextView mTvDetail;

    @Override
    protected void initView() {
        ButterKnife.inject(this);
    }

    @Override
    protected void initData() {

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");

        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setTitle(title);
        //设置后退按钮
        supportActionBar.setDisplayHomeAsUpEnabled(true);


        mTvDetail.setText(FansAndWordsActivity.class.getSimpleName());
        mTvDetail.setTextColor(Color.RED);
        mTvDetail.setGravity(Gravity.CENTER);

        mTvDetail.setTextSize(30);
    }

    @Override
    protected void initEvent() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.detail_activity;
    }

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
