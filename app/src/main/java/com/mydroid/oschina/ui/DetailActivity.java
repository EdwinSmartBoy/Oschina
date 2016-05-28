package com.mydroid.oschina.ui;


import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.mydroid.oschina.R;
import com.mydroid.oschina.base.BaseActivity;
import com.mydroid.oschina.util.UIUtils;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * 创建者     叶庆荣
 * 创建时间   2016/5/15 18:58
 * 描述	      详情页面
 * <p/>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public class DetailActivity extends BaseActivity {

    @InjectView(R.id.fl_detail)
    FrameLayout mFlDetail;
    @InjectView(R.id.tv_detail)
    TextView mTvDetail;

    @Override
    protected void initView() {
        ButterKnife.inject(this);
    }

    @Override
    protected void initData() {

        ActionBar supportActionBar = getSupportActionBar();

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        if (title == null) {
            supportActionBar.setTitle("动弹详情");
        } else {
            supportActionBar.setTitle(title);
        }
        //设置后退按钮
        supportActionBar.setDisplayHomeAsUpEnabled(true);


        mTvDetail.setText(DetailActivity.class.getSimpleName());
        mTvDetail.setTextColor(Color.RED);
        mTvDetail.setGravity(Gravity.CENTER);

        mTvDetail.setTextSize(30);

        mTvDetail.setText(DetailActivity.class.getSimpleName());
        mTvDetail.setTextColor(Color.RED);
        mTvDetail.setGravity(Gravity.CENTER);
        mTvDetail.setTextSize(30);

        ListView listView = new ListView(UIUtils.getContext());
        listView.setAdapter(setTweetsAdapter());
        mFlDetail.addView(listView);

    }

    /**
     * 这里详情页面让子类去设置adapter
     *
     * @return adapter
     */
    public ListAdapter setTweetsAdapter() {
        return null;
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
