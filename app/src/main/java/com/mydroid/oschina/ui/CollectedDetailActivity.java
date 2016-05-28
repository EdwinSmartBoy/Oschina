package com.mydroid.oschina.ui;

import android.webkit.WebSettings;
import android.webkit.WebView;

import com.mydroid.oschina.R;
import com.mydroid.oschina.base.BaseActivity;
import com.mydroid.oschina.bean.Constants;

/**
 * 创建者     林伯任
 * 创建时间   2016/5/14 23:12
 * 描述	      ${TODO}
 * <p/>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public class CollectedDetailActivity extends BaseActivity {


    private WebView mWebView;

    @Override
    public int getLayoutId() {
        return R.layout.activity_collected_detail;
    }

    @Override
    protected void initView() {
        mWebView = (WebView) findViewById(R.id.coll_detail_webview);
        WebSettings webSettings = mWebView.getSettings();

        webSettings.setJavaScriptEnabled(true);

    }

    /**
     * 初始化数据
     */
    @Override
    protected void initData() {

        //拿到传过来的url
        String detailUrl = getIntent().getStringExtra(Constants.KEY_COLL_DETAIL);
        //显示url
        mWebView.loadUrl(detailUrl);

    }

    @Override
    protected void initEvent() {

    }


}
