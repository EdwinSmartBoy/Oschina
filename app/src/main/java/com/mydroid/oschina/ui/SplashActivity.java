package com.mydroid.oschina.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.mydroid.oschina.NetworkApi.ApiHttpClient;
import com.mydroid.oschina.NetworkApi.NetWorkApi;
import com.mydroid.oschina.R;
import com.mydroid.oschina.bean.NewsList;
import com.mydroid.oschina.util.LogUtils;
import com.mydroid.oschina.util.XmlUtils;

/**
 * 创建者     林伯任
 * 创建时间   2016/5/12 17:53
 * 描述	      ${TODO}
 * <p/>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public class SplashActivity extends AppCompatActivity {

    private View mSplashBg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initView();

        //模拟数据
        NetWorkApi.getNewsList(0, 1, new ApiHttpClient.OnHttpResultHandler() {
            @Override
            public void onSuccess(String respose) {

                LogUtils.e("==========");
                NewsList newsList = XmlUtils.toBean(NewsList.class, respose.getBytes());
                LogUtils.e(newsList.getList().get(2).getTitle()+"==========");
                System.out.println(newsList.getList().get(0).getTitle()+"erqwwww");
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }

    /**
     * 休眠两秒之后跳转到MianActivity并销毁自身
     */
    private void initView() {

        new Thread() {
            @Override
            public void run() {
                SystemClock.sleep(1500);
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        }.start();
    }
}
