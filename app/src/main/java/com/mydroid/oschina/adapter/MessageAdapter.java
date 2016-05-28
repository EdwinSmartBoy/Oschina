package com.mydroid.oschina.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mydroid.oschina.R;
import com.mydroid.oschina.bean.News;
import com.mydroid.oschina.util.UIUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @创建时间 Administrator on 2016/5/14 0014.
 */
public class MessageAdapter extends BaseAdapter {
    List<News> newsArray = new ArrayList<>();

    /**
     * 设置数据内容
     *
     * @param list
     */
    public void updateData(List<News> list) {
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
//        TextView textView = new TextView(parent.getContext());
//        textView.setText(tweetsArray.get(position).getTitle());

        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();

            convertView = View.inflate(UIUtils.getContext(), R.layout.item_comp, null);

            holder.tvtitle = (TextView) convertView.findViewById(R.id.tv_title);
            holder.tvcontent = (TextView) convertView.findViewById(R.id.tv_content);
            holder.userName = (TextView) convertView.findViewById(R.id.tv_user_name);
            holder.compTime = (TextView) convertView.findViewById(R.id.tv_time);
            holder.compNum = (TextView) convertView.findViewById(R.id.tv_comp_num);
            convertView.setTag(holder);

        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        News news = newsArray.get(position);

        holder.tvtitle.setText(news.getTitle());
        holder.tvcontent.setText(news.getBody());
        holder.userName.setText(news.getAuthor());
        holder.compTime.setText(news.getPubDate());
        holder.compNum.setText(news.getCommentCount()+"");
        return convertView;
    }

    class ViewHolder{
        TextView tvtitle;
        TextView tvcontent;
        TextView userName;
        TextView compTime;
        TextView compNum;

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
