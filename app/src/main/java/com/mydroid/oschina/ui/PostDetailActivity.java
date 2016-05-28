package com.mydroid.oschina.ui;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;

import com.mydroid.oschina.NetworkApi.ApiHttpClient;
import com.mydroid.oschina.R;
import com.mydroid.oschina.bean.News;
import com.mydroid.oschina.bean.NewsDetail;
import com.mydroid.oschina.bean.OschinaIntent;
import com.mydroid.oschina.util.WebViewUtils;
import com.mydroid.oschina.util.XmlUtils;

/**
 * @创建时间 Administrator on 2016/5/16 0016.
 */
public class PostDetailActivity extends AppCompatActivity {




    private ActionBar     mActionBar;
    public  WebView       mNewsDetailWebView;
    private String        mUrl;
    private NewsDetail    mNews;
    private StringBuilder mSb;


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

        mUrl = getIntent().getStringExtra(OschinaIntent.EXTRA_NEWS_DETAIL);

        System.out.println("post---post= "+mUrl);

        ApiHttpClient.get(mUrl, new ApiHttpClient.OnHttpResultHandler() {

            @Override
            public void onSuccess(String respose) {

                mNews = XmlUtils.toBean(NewsDetail.class, respose.getBytes());

                System.out.println("post--mNes="+mNews);
                getData();
            }

            @Override
            public void onError(Throwable e) {

                //                e.printStackTrace();
            }
        });
    }


    private void getData() {

        News news = mNews.getNews();
        System.out.println("news.getTitle= " + news.getTitle());

        mSb = new StringBuilder();
        mSb.append("<h3>" + news.getTitle() + "</h3>");
        String pubDate = news.getPubDate();
        String[] split = pubDate.split(" ");
        pubDate = split[0];

        mSb.append(pubDate + "&nbsp&nbsp&nbsp&nbsp&nbsp" + "<a href='#'>" + news.getAuthor() + "</a>");
        mSb.append(news.getBody());
       /* mSb.append(news.getSoftwareName() + "</br>");

        List<News.Relative> relatives = news.getRelatives();
        for (News.Relative relative : relatives) {
            mSb.append("<a href='+" + relative.getUrl() + "+'>" + relative.getTitle() + "</a>" + "</br></br>");
        }
*/
        WebViewUtils.loadWebViewData(mNewsDetailWebView, mSb.toString());
    }


    private void init() {
        // 获取ActionBar
        mActionBar = getSupportActionBar();

        mActionBar.setTitle("资讯详情");// 设置主title部分
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
/*
    private ActionBar     mActionBar;
    public  WebView       mNewsDetailWebView;
    private String        mUrl;
    private PostDetail    mNews;
    private StringBuilder mSb;


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

        mUrl = getIntent().getStringExtra(OschinaIntent.EXTRA_NEWS_DETAIL);


        ApiHttpClient.get(mUrl, new ApiHttpClient.OnHttpResultHandler() {

            @Override
            public void onSuccess(String respose) {

                mNews = XmlUtils.toBean(PostDetail.class, respose.getBytes());

                getData();
            }

            @Override
            public void onError(Throwable e) {

                //                e.printStackTrace();
            }
        });
    }

    private void getData() {
        Post news = mNews.getPost();
        System.out.println("news.getTitle= " + news.getTitle());

        mSb = new StringBuilder();
        mSb.append("<h3>" + news.getTitle() + "</h3>");
        String pubDate = news.getPubDate();
        String[] split = pubDate.split(" ");
        pubDate = split[0];

        mSb.append(pubDate + "&nbsp&nbsp&nbsp&nbsp&nbsp" + "<a href='#'>" + news.getAuthor() + "</a>");
        mSb.append(news.getBody());
       *//* mSb.append(news.getSoftwareName() + "</br>");

        List<News.Relative> relatives = news.getRelatives();
        for (News.Relative relative : relatives) {
            mSb.append("<a href='+" + relative.getUrl() + "+'>" + relative.getTitle() + "</a>" + "</br></br>");
        }
*//*
        WebViewUtils.loadWebViewData(mNewsDetailWebView, mSb.toString());
    }


    private void init() {
        // 获取ActionBar
        mActionBar = getSupportActionBar();

        mActionBar.setTitle("资讯详情");// 设置主title部分
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
    }*/
}
