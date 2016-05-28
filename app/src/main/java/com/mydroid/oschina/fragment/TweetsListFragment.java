package com.mydroid.oschina.fragment;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.mydroid.oschina.base.BaseListFragment;
import com.mydroid.oschina.bean.Tweet;
import com.mydroid.oschina.bean.TweetsList;
import com.mydroid.oschina.ui.DetailActivity;
import com.mydroid.oschina.util.UIUtils;
import com.mydroid.oschina.util.XmlUtils;

import java.util.List;

/**
 * 创建者     叶庆荣
 * 创建时间   2016/5/15 22:30
 * 描述	      ${TODO}
 * <p/>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public abstract class TweetsListFragment extends BaseListFragment {
    @NonNull
    @Override
    protected BaseAdapter getListAdapter() {
        return getBaseAdapter();
    }

    @Override
    protected void requestData() {
        RequestQueue queue = Volley.newRequestQueue(getContext());
        getTweetsList(queue);
    }


    @Override
    protected Object parseData(String data) {
        TweetsList tweetsList = XmlUtils.toBean(TweetsList.class, data.getBytes());
        return tweetsList;
    }

    @Override
    protected void updateUI(Object obj) {
        TweetsList tweetsList = (TweetsList) obj;
        List<Tweet> list = tweetsList.getList();
       upDataUI(list);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        super.onItemClick(parent, view, position, id);
        Toast.makeText(UIUtils.getContext(), getClass().getSimpleName(), Toast.LENGTH_SHORT).show();
        startActivity(new Intent(UIUtils.getContext(), DetailActivity.class));
    }

    /**
     * 让子类的adapter去实现UI更新
     * 样式: ((TweetsNewsMessageAdapter)baseListAdapter).updateData(list);
     */
    protected abstract void upDataUI(List<Tweet> list);

    /**
     * 不知道是什么adapter,让子类去实现
     * 样式:new TweetsNewsMessageAdapter()
     * @return adapter
     */
    public abstract BaseAdapter getBaseAdapter();
    /**
     * 样式:ApiService.getNewsTweetList(queue, listener, 0);
     * 获取子类数据集合的Url地址
     * @param queue
     */
    protected abstract void getTweetsList(RequestQueue queue);
}
