package com.mydroid.oschina.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.mydroid.oschina.adapter.MessageRemindAdapter;
import com.mydroid.oschina.base.BaseListFragment;
import com.mydroid.oschina.bean.Active;
import com.mydroid.oschina.bean.ActiveList;
import com.mydroid.oschina.ui.DetailActivity;
import com.mydroid.oschina.util.ApiService;
import com.mydroid.oschina.util.LogUtils;
import com.mydroid.oschina.util.UIUtils;
import com.mydroid.oschina.util.XmlUtils;

import java.util.List;

/**
 * 创建者      Created by Edwin
 * 创建时间    2016/05/15
 * 描述        我的界面-->消息界面-->@我界面
 * <p/>
 * 更新者      Edwin
 * 更新时间    ${TODO}
 * 更新描述    ${TODO}
 */
public class MessageRemindFragment extends BaseListFragment {

    private static final String TAG = "MessageRemindFragment";
    private RequestQueue mRequestQueue;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRequestQueue = Volley.newRequestQueue(getContext());
    }

    @NonNull
    @Override
    protected BaseAdapter getListAdapter() {
        return new MessageRemindAdapter();
    }

    @Override
    protected void requestData() {
        ApiService.getMessageCenterDataRemind(mRequestQueue, listener, 2);
    }

    @Override
    protected Object parseData(String data) {
        return XmlUtils.toBean(ActiveList.class, data.getBytes());
    }

    @Override
    protected void updateUI(Object obj) {

        ActiveList activeList = (ActiveList) obj;
        List<Active> list = activeList.getActivelist();
        ((MessageRemindAdapter) baseListAdapter).updateData(list);

        /*FavoriteList newsList = (FavoriteList) obj;
        List<Favorite> list = newsList.getFavoritelist();
        ((TopicAdapter)baseListAdapter).updateData(list);*/
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(UIUtils.getContext(), DetailActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        LogUtils.d(TAG, "onItemLongClick " + ",position " + position + ",id " + id);
        showDialog();
        return super.onItemLongClick(parent, view, position, id);
    }

    private void showDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        builder.setTitle("测试的弹窗");
        builder.setMessage("复制");
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

    }
}
