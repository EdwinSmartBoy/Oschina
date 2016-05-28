package com.mydroid.oschina.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.mydroid.oschina.bean.News;
import com.mydroid.oschina.holder.NewsHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * @创建时间 Administrator on 2016/5/14 0014.
 */
public class NewsAdapter extends BaseAdapter {

    List<News> newsArray = new ArrayList<>();

    /**
     * 设置数据内容
     *
     * @param list
     */
    public void updateData(List<News> list) {
        //newsArray.clear();
        newsArray.addAll(list);
        notifyDataSetChanged();
    }


    @Override
    public int getCount() {
//        System.out.println(newsArray.size()+"getCount_+++");
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


        NewsHolder newsHolder = null;
        if (convertView == null) {
            newsHolder = new NewsHolder();
        }else{
            newsHolder = (NewsHolder) convertView.getTag();
        }

        News news = newsArray.get(position);

        newsHolder.setDataAndRefleshHolderView(news);

        return newsHolder.mHolderView;

    }


    public void setData(List<News> data) {
        newsArray.addAll(data);
//        System.out.println(newsArray.size()+"+++++++++++++++++++++++++++++++");
        notifyDataSetChanged();
    }
}
