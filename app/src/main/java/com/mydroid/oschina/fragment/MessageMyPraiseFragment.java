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
import com.mydroid.oschina.adapter.MessageMyPraiseAdapter;
import com.mydroid.oschina.base.BaseListFragment;
import com.mydroid.oschina.bean.TweetLike;
import com.mydroid.oschina.bean.TweetLikeList;
import com.mydroid.oschina.ui.DetailActivity;
import com.mydroid.oschina.util.ApiService;
import com.mydroid.oschina.util.UIUtils;
import com.mydroid.oschina.util.XmlUtils;

import java.util.List;

/**
 * 创建者      Created by Edwin
 * 创建时间    2016/05/15
 * 描述        我的界面-->消息界面-->赞过我的界面
 * <p/>
 * 更新者      Edwin
 * 更新时间    ${TODO}
 * 更新描述    ${TODO}
 */
public class MessageMyPraiseFragment extends BaseListFragment {

    private RequestQueue mRequestQueue;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRequestQueue = Volley.newRequestQueue(UIUtils.getContext());
    }

    @NonNull
    @Override
    protected BaseAdapter getListAdapter() {
        return new MessageMyPraiseAdapter();
    }

    @Override
    protected void requestData() {
        ApiService.getMessageCenterDataMyPraise(mRequestQueue, listener);
    }

    @Override
    protected Object parseData(String data) {
        return XmlUtils.toBean(TweetLikeList.class, data.getBytes());
    }

    @Override
    protected void updateUI(Object obj) {
        TweetLikeList tweetLikeList = (TweetLikeList) obj;
        List<TweetLike> list = tweetLikeList.getList();
        ((MessageMyPraiseAdapter) baseListAdapter).updateData(list);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        super.onItemClick(parent, view, position, id);
        Intent intent = new Intent(UIUtils.getContext(), DetailActivity.class);
        startActivity(intent);
    }


}
