package com.mydroid.oschina.ui;

import android.support.v7.app.ActionBar;
import android.view.MenuItem;

import com.mydroid.oschina.R;
import com.mydroid.oschina.base.BaseActivity;
import com.mydroid.oschina.fragment.FollowFansFragment;

/**
 * 创建者     林伯任
 * 创建时间   2016/5/13 11:24
 * 描述	      此界面为我的界面-->关注和粉丝
 * <p/>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public class FollowFansActivity extends BaseActivity {

    /**
     * 加载布局--FrameLayout
     *
     */
    @Override
    public int getLayoutId() {
        return R.layout.activity_follow_fans;
    }

    /**
     * 用CollectedFragment代替Activity 去添加内容
     */
    @Override
    protected void initView() {
        FollowFansFragment followFansFragment = new FollowFansFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.follow_fans_root, followFansFragment).commit();

        initActionBar();
    }
    @Override
    protected void initData() {
    }

    @Override
    protected void initEvent() {
    }

    /**
     * 初始化Actionbar
     */
    private void initActionBar() {
        ActionBar actionBar = getSupportActionBar();
        //设置返回按钮可见
        actionBar.setDisplayHomeAsUpEnabled(true);
        //设置
        actionBar.setDisplayShowHomeEnabled(true);
        //设置标题
        actionBar.setTitle("关注/粉丝");
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
