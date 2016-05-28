package com.mydroid.oschina.ui;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;

import com.mydroid.oschina.NetworkApi.ApiHttpClient;
import com.mydroid.oschina.R;
import com.mydroid.oschina.bean.Blog;
import com.mydroid.oschina.bean.BlogDetail;
import com.mydroid.oschina.bean.OschinaIntent;
import com.mydroid.oschina.util.WebViewUtils;
import com.mydroid.oschina.util.XmlUtils;

/**
 * @创建时间 Administrator on 2016/5/15 0015.
 */
public class BlogDetailActivity extends AppCompatActivity {


    private ActionBar     mActionBar;
    public  WebView       mNewsDetailWebView;
    private String        mUrl;

    private StringBuilder mSb;
    private BlogDetail mBlogDetail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);

        //        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        init();
        initView();
        initData();

    }

    private void initView() {
        mNewsDetailWebView = (WebView) findViewById(R.id.wv_news_detail);
    }


    public void initData() {

        mUrl = getIntent().getStringExtra(OschinaIntent.EXTRA_BLOGS_DETAIL);

        System.out.println("blog--mUrl= "+mUrl);
        ApiHttpClient.get(mUrl, new ApiHttpClient.OnHttpResultHandler() {


            @Override
            public void onSuccess(String respose) {

                mBlogDetail = XmlUtils.toBean(BlogDetail.class, respose.getBytes());

                getData();
            }

            @Override
            public void onError(Throwable e) {

                //                e.printStackTrace();
            }
        });
    }

    private void getData() {
        Blog blog = mBlogDetail.getBlog();
        System.out.println("blog.getTitle= " + blog.getTitle());

        mSb = new StringBuilder();
        mSb.append("<h3>" + blog.getTitle() + "</h3>");
        String pubDate = blog.getPubDate();
        String[] split = pubDate.split(" ");
        pubDate = split[0];

        mSb.append(pubDate + "&nbsp&nbsp&nbsp&nbsp&nbsp" + "<a href='#'>" + blog.getAuthor() + "</a>");
        mSb.append(blog.getBody());
    /*    mSb.append(blog.getSoftwareName() + "</br>");

        List<News.Relative> relatives = blog.getRelatives();
        for (News.Relative relative : relatives) {
            mSb.append("<a href='+" + relative.getUrl() + "+'>" + relative.getTitle() + "</a>" + "</br></br>");
        }*/

        WebViewUtils.loadWebViewData(mNewsDetailWebView, mSb.toString());
    }


    private void init() {
        // 获取ActionBar
        mActionBar = getSupportActionBar();

        mActionBar.setTitle("博客详情");// 设置主title部分
        mActionBar.setIcon(R.drawable.ic_launcher);// 设置应用图标
        mActionBar.setDisplayShowTitleEnabled(true);// 设置菜单 标题是否可见
        mActionBar.setDisplayHomeAsUpEnabled(true);// 设置back按钮是否可见

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.news_top_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.news_top_menu:
                //点击时,刷新数据
                WebViewUtils.loadWebViewData(mNewsDetailWebView, mSb.toString());
                break;
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
