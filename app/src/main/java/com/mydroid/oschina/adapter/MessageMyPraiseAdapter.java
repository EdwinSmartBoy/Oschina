package com.mydroid.oschina.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mydroid.oschina.R;
import com.mydroid.oschina.bean.TweetLike;
import com.mydroid.oschina.util.UIUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * 创建者      Created by Edwin
 * 创建时间    2016/05/15
 * 描述        我的-->消息中心-->赞过我的
 * <p/>
 * 更新者      Edwin
 * 更新时间    ${TODO}
 * 更新描述    ${TODO}
 */
public class MessageMyPraiseAdapter extends BaseAdapter {

    private List<TweetLike> mTweetLikes = new ArrayList<>();

    public void updateData(List<TweetLike> list) {
        mTweetLikes.clear();
        mTweetLikes.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        if (mTweetLikes != null && mTweetLikes.size() > 0) {
            return mTweetLikes.size();
        }
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = View.inflate(UIUtils.getContext(), R.layout.item_msg_mypraise, null);
            holder = new ViewHolder(convertView);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        TweetLike tweetLike = mTweetLikes.get(position);

        holder.mTvName.setText(tweetLike.getUser().getName());
        holder.mTvTime.setText(tweetLike.getDatatime());
        holder.mTvSup.setText("itheima :" + tweetLike.getTweet().getBody());

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

    static class ViewHolder {

        @InjectView(R.id.tv_name)
        TextView mTvName;
        @InjectView(R.id.tv_time)
        TextView mTvTime;
        @InjectView(R.id.tv_des)
        TextView mTvDes;
        @InjectView(R.id.tv_sup)
        TextView mTvSup;

        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}
