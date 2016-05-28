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
import com.mydroid.oschina.adapter.MessageCommentAdapter;
import com.mydroid.oschina.base.BaseListFragment;
import com.mydroid.oschina.bean.Active;
import com.mydroid.oschina.bean.ActiveList;
import com.mydroid.oschina.ui.DetailActivity;
import com.mydroid.oschina.util.ApiService;
import com.mydroid.oschina.util.UIUtils;
import com.mydroid.oschina.util.XmlUtils;

import java.util.List;

/**
 * 创建者      Created by Edwin
 * 创建时间    2016/05/15
 * 描述        我的界面-->消息界面-->评论界面
 * <p/>
 * 更新者      Edwin
 * 更新时间    ${TODO}
 * 更新描述    ${TODO}
 */
public class MessageCommentFragment extends BaseListFragment {
    private RequestQueue mRequestQueue;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRequestQueue = Volley.newRequestQueue(getContext());
    }

    @NonNull
    @Override
    protected BaseAdapter getListAdapter() {
        return new MessageCommentAdapter();
    }

    @Override
    protected void requestData() {
        ApiService.getMessageCenterDataRemind(mRequestQueue, listener, 3);
    }

    @Override
    protected Object parseData(String data) {
        return XmlUtils.toBean(ActiveList.class, data.getBytes());
    }

    @Override
    protected void updateUI(Object obj) {
        ActiveList commentList = (ActiveList) obj;
        List<Active> actives = commentList.getActivelist();
        ((MessageCommentAdapter) baseListAdapter).updateData(actives);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        super.onItemClick(parent, view, position, id);
        Intent intent = new Intent(UIUtils.getContext(), DetailActivity.class);
        startActivity(intent);
    }
}
