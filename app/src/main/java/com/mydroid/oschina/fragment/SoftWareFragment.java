package com.mydroid.oschina.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.mydroid.oschina.adapter.SoftWareAdapter;
import com.mydroid.oschina.base.BaseListFragment;
import com.mydroid.oschina.bean.Constants;
import com.mydroid.oschina.bean.Favorite;
import com.mydroid.oschina.bean.FavoriteList;
import com.mydroid.oschina.ui.CollectedDetailActivity;
import com.mydroid.oschina.util.ApiService;
import com.mydroid.oschina.util.UIUtils;
import com.mydroid.oschina.util.XmlUtils;

import java.util.List;

/**
 * 创建者     林伯任
 * 创建时间   2016/5/13 16:07
 * 描述	      我 --> 收藏--> 软件页面
 * <p/>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public class SoftWareFragment extends BaseListFragment {

    private RequestQueue mRequestQueue;
    private SoftWareAdapter mAdapter;
    private FavoriteList mFavoriteList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRequestQueue = Volley.newRequestQueue(getContext());
    }

    @NonNull
    @Override
    protected BaseAdapter getListAdapter() {
        mAdapter = new SoftWareAdapter();
        return mAdapter;
    }

    @Override
    protected void requestData() {
        ApiService.getFavorite(mRequestQueue, listener, 0);
    }

    @Override
    protected Object parseData(String data) {
        mFavoriteList = XmlUtils.toBean(FavoriteList.class, data.getBytes());
        return mFavoriteList;
    }

    @Override
    protected void updateUI(Object obj) {
        FavoriteList newsList = (FavoriteList) obj;
        List<Favorite> list = newsList.getFavoritelist();
        ((SoftWareAdapter) baseListAdapter).updateData(list);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        super.onItemClick(parent, view, position, id);

        //点击的时候跳转到详情页面
        Intent intent = new Intent(UIUtils.getContext(), CollectedDetailActivity.class);
        String url = mFavoriteList.getFavoritelist().get(position).getUrl();
        intent.putExtra(Constants.KEY_COLL_DETAIL, url);
        startActivity(intent);
    }
}
