package com.mydroid.oschina.adapter;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mydroid.oschina.bean.Favorite;
import com.mydroid.oschina.util.UIUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建者     林伯任
 * 创建时间   2016/5/14 22:52
 * 描述	      ${TODO}
 * <p/>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public class MyBlogAdapter extends BaseAdapter {

    List<Favorite> newsArray = new ArrayList<>();

    /**
     * 设置数据内容
     *
     * @param list
     */
    public void updateData(List<Favorite> list) {
        newsArray.clear();
        newsArray.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return newsArray.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView = new TextView(UIUtils.getContext());
        Favorite news = newsArray.get(position);

        textView.setText(news.getTitle());
        textView.setPadding(8, 8, 8, 8);
        textView.setTextColor(Color.BLACK);
        convertView = textView;
        return convertView;
    }


    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
}
