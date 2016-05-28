package com.mydroid.oschina.fragment;

import android.widget.BaseAdapter;

import com.android.volley.RequestQueue;
import com.mydroid.oschina.adapter.TweetsHotMessageAdapter;
import com.mydroid.oschina.bean.Tweet;
import com.mydroid.oschina.util.ApiService;

import java.util.List;

/**
 * 创建者     叶庆荣
 * 创建时间   2016/5/11 21:15
 * 描述	      热门动弹页面
 * <p/>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述
 */
public class HotTweetFragment extends TweetsListFragment{

    @Override
    protected void upDataUI(List<Tweet> list) {
        ((TweetsHotMessageAdapter)baseListAdapter).updateData(list);
    }

    @Override
    public BaseAdapter getBaseAdapter() {
        return new TweetsHotMessageAdapter();
    }

    @Override
    protected void getTweetsList(RequestQueue queue) {
        ApiService.getHotTweetList(queue, listener, 0);
    }
}
