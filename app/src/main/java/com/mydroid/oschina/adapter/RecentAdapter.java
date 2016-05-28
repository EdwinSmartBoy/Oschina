package com.mydroid.oschina.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.mydroid.oschina.bean.Event;
import com.mydroid.oschina.holder.EventHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * @创建时间 Administrator on 2016/5/17 0017.
 */
public class RecentAdapter extends BaseAdapter{

    List<Event> newsArray = new ArrayList<>();

    /**
     * 设置数据内容
     *
     * @param list
     */
    public void updateData(List<Event> list) {
        //newsArray.clear();
        newsArray.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return newsArray.size();
    }

    @Override
    public Object getItem(int position) {
        return newsArray.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        EventHolder eventHolder = null;
        if (convertView == null) {
            eventHolder = new EventHolder();
        }else{
            eventHolder = (EventHolder) convertView.getTag();
        }

        Event news = newsArray.get(position);

        eventHolder.setDataAndRefleshHolderView(news);

        return eventHolder.mHolderView;


    }



    public void setData(List<Event> data) {
        newsArray.addAll(data);
        System.out.println(newsArray.size()+"+++++++++++++++++++++++++++++++");
        notifyDataSetChanged();
    }
}
