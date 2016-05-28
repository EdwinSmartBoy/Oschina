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
import com.mydroid.oschina.adapter.BlogAdapter;
import com.mydroid.oschina.base.BaseListFragment;
import com.mydroid.oschina.bean.Blog;
import com.mydroid.oschina.bean.BlogList;
import com.mydroid.oschina.bean.Constants;
import com.mydroid.oschina.bean.OschinaIntent;
import com.mydroid.oschina.ui.BlogDetailActivity;
import com.mydroid.oschina.util.ApiService;
import com.mydroid.oschina.util.UIUtils;
import com.mydroid.oschina.util.XmlUtils;

import java.util.List;

import butterknife.ButterKnife;

/**
 * @创建时间 Administrator on 2016/5/12 0012.
 */
public class ZHBlogsFragment extends BaseListFragment {


    private BlogAdapter mAdapter;
    private RequestQueue mQueue;
    private BlogList mBlogList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //初始化网络队列
        mQueue = Volley.newRequestQueue(getContext());
        //初始化Adapter
        mAdapter = new BlogAdapter();
        //恢复初始化
        i = 0;
    }

    @NonNull
    @Override
    protected BaseAdapter getListAdapter() {
        mAdapter = new BlogAdapter();
        return mAdapter;
    }

    @Override
    protected void requestData() {
        ApiService.getBlogList(queue, listener, 0);

    }

    @Override
    protected Object parseData(String data) {
        BlogList blogList = XmlUtils.toBean(BlogList.class, data.getBytes());
        System.out.print(blogList.getList().get(1).getTitle());
        return blogList;
    }

    @Override
    protected void updateUI(Object obj) {
        mBlogList = (BlogList) obj;
        List<Blog> list = mBlogList.getList();
        ((BlogAdapter) baseListAdapter).updateData(list);
    }

    /**
     * listview的滚动监听
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
        String url = "oschina/list/blog/page" + i + ".xml";
        ApiHttpClient.get(url, new ApiHttpClient.OnHttpResultHandler() {
            @Override
            public void onSuccess(String respose) {
                List<Blog> newsList = XmlUtils.toBean(BlogList.class, respose.getBytes()).getList();
                //LogUtils.e(respose);
                mAdapter.setData(newsList);
            }

            @Override
            public void onError(Throwable e) {
                Toast.makeText(UIUtils.getContext(), "网络加载出错", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //        super.onItemClick(parent, view, position, id);
        String iid = Constants.BLOGS_DETAIL + mBlogList.getList().get(position).getId()+".xml";

        System.out.println("blog----iid= "+iid);
        Intent intent = new Intent(UIUtils.getContext(), BlogDetailActivity.class);
        intent.putExtra(OschinaIntent.EXTRA_BLOGS_DETAIL, iid);
        startActivity(intent);

    }
}
