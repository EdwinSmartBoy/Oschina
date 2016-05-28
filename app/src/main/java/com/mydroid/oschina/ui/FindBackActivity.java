package com.mydroid.oschina.ui;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.mydroid.oschina.R;
import com.mydroid.oschina.bean.FindBackPage;

import org.kymjs.kjframe.utils.StringUtils;

import java.lang.ref.WeakReference;


/**
 * 创建者     九天玄尘
 * 创建时间   2016/5/13 15:17
 * 描述	     这是发现界面中,朋友圈,活动 ,扫一扫, 摇一摇等Fragment所依附的Activity
 * <p/>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public class FindBackActivity extends AppCompatActivity {


    /**
     * 创建者     九天玄尘
     * 创建时间   2016/5/15 18:01
     * 描述	      ${TODO}
     * <p/>
     * 更新者     $Author$
     * 更新时间   $Date$
     * 更新描述   ${TODO}
     */
    public final static String BUNDLE_KEY_PAGE = "BUNDLE_KEY_PAGE";
    public final static String BUNDLE_KEY_ARGS = "BUNDLE_KEY_ARGS";
    private static final String TAG = "FLAG_TAG";
    protected WeakReference<Fragment> mFragment;
    protected int mPageValue = -1;
    private TextView mTvActionTitle;
    private android.support.v7.app.ActionBar mActionBar;
    private LayoutInflater mInflater;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (!hasActionBar()) {
            // supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        }
        if (getLayoutId() != 0) {
            setContentView(getLayoutId());
        }
        mActionBar = getSupportActionBar();
        mInflater = getLayoutInflater();
        if (hasActionBar()) {
            initActionBar(mActionBar);
        }

        setContentView(getLayoutId());
        initView();
        initData();
        initListener();
    }


    private int getLayoutId() {
        return R.layout.activity_find_back;
    }

    private void initView() {


    }

    private void initData() {

        if (mPageValue == -1) {
            mPageValue = getIntent().getIntExtra(BUNDLE_KEY_PAGE, 0);
        }
        initFromIntent(mPageValue, getIntent());
    }

    private void initListener() {
    }


    protected boolean hasBackButton() {
        return true;
    }

    protected void initFromIntent(int pageValue, Intent data) {
        /*if (data == null) {
            throw new RuntimeException(
                    "you must provide a page info to display");
        }*/
        FindBackPage page = FindBackPage.getPageByValue(pageValue);
        if (page == null) {
            throw new IllegalArgumentException("can not find page by value:"
                    + pageValue);
        }

        setActionBarTitle(page.getTitle());

        try {
            Fragment fragment = (Fragment) page.getClz().newInstance();

            Bundle args = data.getBundleExtra(BUNDLE_KEY_ARGS);
            if (args != null) {
                fragment.setArguments(args);
            }

            FragmentTransaction trans = getSupportFragmentManager()
                    .beginTransaction();
            trans.replace(R.id.container, fragment, TAG);
            trans.commitAllowingStateLoss();

            mFragment = new WeakReference<Fragment>(fragment);
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException(
                    "generate fragment error. by value:" + pageValue);
        }
    }



    /**
     * 设置ActionBar的标题
     *
     * @param title
     */
    public void setActionBarTitle(String title) {
        if (StringUtils.isEmpty(title)) {
            title = getString(R.string.app_name);
        }
        if (hasActionBar() && mActionBar != null) {
            if (mTvActionTitle != null) {
                mTvActionTitle.setText(title);
            }
            mActionBar.setTitle(title);
        }
    }

    protected boolean hasActionBar() {
        return true;
    }

    protected View inflateView(int resId) {
        return mInflater.inflate(resId, null);
    }


    /**
     * 初始化ActionBar
     *
     * @param actionBar
     */
    protected void initActionBar(android.support.v7.app.ActionBar actionBar) {
        if (actionBar == null)
            return;
        if (hasBackButton()) {
            mActionBar.setDisplayHomeAsUpEnabled(true);
            mActionBar.setHomeButtonEnabled(true);
        } else {
            actionBar.setDisplayOptions(android.support.v7.app.ActionBar.DISPLAY_SHOW_TITLE);
            actionBar.setDisplayUseLogoEnabled(false);
            int titleRes = getActionBarTitle();
            if (titleRes != 0) {
                actionBar.setTitle(titleRes);
            }
        }
    }

    protected int getActionBarTitle() {
        return R.string.app_name;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;

            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
