package com.mydroid.oschina.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.mydroid.oschina.NetworkApi.ApiHttpClient;
import com.mydroid.oschina.adapter.NewsAdapter;
import com.mydroid.oschina.base.BaseListFragment;
import com.mydroid.oschina.bean.Constants;
import com.mydroid.oschina.bean.News;
import com.mydroid.oschina.bean.NewsList;
import com.mydroid.oschina.bean.OschinaIntent;
import com.mydroid.oschina.ui.NewsDetailActivity;
import com.mydroid.oschina.util.ApiService;
import com.mydroid.oschina.util.UIUtils;
import com.mydroid.oschina.util.XmlUtils;

import java.util.List;

/**
 * @创建时间 Administrator on 2016/5/12 0012.
 */
public class ZHMessageFragment extends BaseListFragment {

    private RequestQueue mQueue;
    private NewsAdapter mAdapter;
    private NewsList mNewsList;

    //定义四种状态
    public static final int STATE_lOADING = 0;
    public static final int STATE_EMPTY = 1;
    public static final int STATE_ERROR = 2;
    public static final int STATE_SUCCESS = 3;
    public int mCurrentState = STATE_SUCCESS;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mQueue = Volley.newRequestQueue(getContext());
        mAdapter = new NewsAdapter();
        i = 0;
    }

    @NonNull
    @Override
    protected BaseAdapter getListAdapter() {
        if (mCurrentState == STATE_SUCCESS) {
            return mAdapter;
        }
        return null;
    }

    @Override
    protected void requestData() {
        ApiService.getNewsList(mQueue, listener, 0);
        mCurrentState = STATE_SUCCESS;
    }

    @Override
    protected Object parseData(String data) {
        NewsList newsList = XmlUtils.toBean(NewsList.class, data.getBytes());
        // System.out.print(newsList.getList().get(1).getTitle());
        return newsList;
    }

    @Override
    protected void updateUI(Object obj) {
        mNewsList = (NewsList) obj;
        List<News> list = mNewsList.getList();
        ((NewsAdapter) baseListAdapter).updateData(list);
    }

    /**
     * 触发去加载更多的数据
     *
     * @param view
     * @param firstVisibleItem
     * @param visibleItemCount
     * @param totalItemCount
     */
    int i = 0;

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        super.onScroll(view, firstVisibleItem, visibleItemCount, totalItemCount);
        boolean isBottom = firstVisibleItem + visibleItemCount == totalItemCount;
        if (isBottom) {
            i++;
            loadMoreData();
        }
    }

    /**
     * 从网络去加载更多的数据.
     */
    private void loadMoreData() {
        //加载下一页的数据
        //ApiService.getNewsList(mQueue,listener,getPage(1));
        if (i > 3) {
            // Toast.makeText(UIUtils.getContext(), "没有更多数据了", Toast.LENGTH_SHORT).show();
            return;
        }
        String url = "oschina/list/news/page" + i + ".xml";
        ApiHttpClient.get(url, new ApiHttpClient.OnHttpResultHandler() {
            @Override
            public void onSuccess(String respose) {
                List<News> newsList = XmlUtils.toBean(NewsList.class, respose.getBytes()).getList();
                //LogUtils.e(respose);
                mAdapter.setData(newsList);
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onError(Throwable e) {
                Toast.makeText(UIUtils.getContext(), "网络加载出错", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //        super.onItemClick(parent, view, position, id);
        News news = (News) parent.getItemAtPosition(position);
        String iid = Constants.NEWS_DETAIL + news.getId() + ".xml";

        Intent intent = new Intent(UIUtils.getContext(), NewsDetailActivity.class);
        intent.putExtra(OschinaIntent.EXTRA_NEWS_DETAIL, iid);
        startActivity(intent);
    }
}
