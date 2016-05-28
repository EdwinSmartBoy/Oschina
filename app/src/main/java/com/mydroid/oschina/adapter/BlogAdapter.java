package com.mydroid.oschina.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.mydroid.oschina.bean.Blog;
import com.mydroid.oschina.holder.BlogHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * @创建时间 Administrator on 2016/5/14 0014.
 */
public class BlogAdapter extends BaseAdapter {

    List<Blog> newsArray = new ArrayList<>();

    /**
     * 设置数据内容
     * @param list
     */
    public void updateData(List<Blog> list) {
        newsArray.clear();
        newsArray.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        if (newsArray != null) {
            return newsArray.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        BlogHolder blogHolder = null;
        if (convertView == null) {
            blogHolder = new BlogHolder();
        }else{
            blogHolder = (BlogHolder) convertView.getTag();
        }

        Blog blog = newsArray.get(position);

        blogHolder.setDataAndRefreshHolderView(blog);

        return blogHolder.mHolderView;
    }

    public void setData(List<Blog> data) {
        newsArray.addAll(data);
        notifyDataSetChanged();
    }
}
