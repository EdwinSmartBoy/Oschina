package com.mydroid.oschina.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.BaseAdapter;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.mydroid.oschina.adapter.RecentAdapter;
import com.mydroid.oschina.base.BaseListFragment;
import com.mydroid.oschina.bean.Event;
import com.mydroid.oschina.bean.EventList;
import com.mydroid.oschina.util.ApiService;
import com.mydroid.oschina.util.XmlUtils;

import java.util.List;

/**
 * @创建时间 Administrator on 2016/5/17 0017.
 */
public class RecentEventFragment extends BaseListFragment{


    private RequestQueue mQueue;
    private RecentAdapter mAdapter;

    int i = 0;
    private EventList mEventList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mQueue = Volley.newRequestQueue(getContext());
        mAdapter = new RecentAdapter();
        i = 0;
    }


    @NonNull
    @Override
    protected BaseAdapter getListAdapter() {
        return mAdapter;
    }

    @Override
    protected void requestData() {

        ApiService.getRecEventList(mQueue, listener, 0);
    }

    @Override
    protected Object parseData(String data) {
        EventList eventList = XmlUtils.toBean(EventList.class, data.getBytes());

        return eventList;
    }

    @Override
    protected void updateUI(Object obj) {
        mEventList = (EventList) obj;
        List<Event> list = mEventList.getList();
        ((RecentAdapter)baseListAdapter).updateData(list);
    }


}
