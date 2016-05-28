package com.mydroid.oschina.ui;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.mydroid.oschina.R;
import com.mydroid.oschina.base.BaseActivity;
import com.mydroid.oschina.widget.CustomerScrollView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 创建者     CAI
 * 创建时间   2016/5/17 17:57
 * 描述	      ${TODO}
 * <p/>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public class UserDesActivity extends BaseActivity {


    @InjectView(R.id.iv_face)
    CircleImageView mIvFace;
    @InjectView(R.id.user_name)
    TextView mUserName;
    @InjectView(R.id.iv_sex)
    ImageView mIvSex;
    @InjectView(R.id.ly_des)
    CustomerScrollView mLyDes;

    @Override
    public int getLayoutId() {
        return R.layout.user_desc;
    }

    @Override
    protected void initView() {
        ButterKnife.inject(this);

        //初始化ActionBar
        initActionBar();

    }

    @Override
    protected void initData() {


    }

    @Override
    protected void initEvent() {

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.inject(this);
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
        actionBar.setTitle("我的资料");
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
