package com.mydroid.oschina.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.mydroid.oschina.NetworkApi.ApiHttpClient;
import com.mydroid.oschina.adapter.TweetsNewsMessageAdapter;
import com.mydroid.oschina.bean.Tweet;
import com.mydroid.oschina.bean.TweetsList;
import com.mydroid.oschina.util.ApiService;
import com.mydroid.oschina.util.UIUtils;
import com.mydroid.oschina.util.XmlUtils;

import java.util.List;

/**
 * 创建者     叶庆荣
 * 创建时间   2016/5/11 21:15
 * 描述	      最新动弹页面
 * <p/>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public class NewTweetFragment extends TweetsListFragment {

    private TweetsNewsMessageAdapter mAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAdapter = new TweetsNewsMessageAdapter();
        i = 0;


    }

    @Override
    protected void upDataUI(List<Tweet> list) {
        ((TweetsNewsMessageAdapter) baseListAdapter).updateData(list);
    }

    @Override
    public BaseAdapter getBaseAdapter() {
        return mAdapter;
    }

    @Override
    protected void getTweetsList(RequestQueue queue) {
        ApiService.getNewsTweetList(queue, listener, 0);
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
        //http://188.188.4.41:8080/oschina/list/tweet_list/page3.xml
        String url = "oschina/list/tweet_list/page" + i + ".xml";
        ApiHttpClient.get(url, new ApiHttpClient.OnHttpResultHandler() {
            @Override
            public void onSuccess(String respose) {
                List<Tweet> list = XmlUtils.toBean(TweetsList.class, respose.getBytes()).getList();
                //LogUtils.e(respose);
                mAdapter.setData(list);
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onError(Throwable e) {
                Toast.makeText(UIUtils.getContext(), "网络加载出错", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
