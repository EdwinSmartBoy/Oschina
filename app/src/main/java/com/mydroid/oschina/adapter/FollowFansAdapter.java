package com.mydroid.oschina.adapter;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mydroid.oschina.R;
import com.mydroid.oschina.bean.Friend;
import com.mydroid.oschina.util.UIUtils;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * 创建者     林伯任
 * 创建时间   2016/5/15 16:42
 * 描述	      这个是我的--->粉丝/关注的页面
 * <p/>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public class FollowFansAdapter extends BaseAdapter {
    List<Friend> newsArray = new ArrayList<>();

    /**
     * 设置数据内容
     *
     * @param list
     */
    public void updateData(List<Friend> list) {
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
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = View.inflate(UIUtils.getContext(), R.layout.item_friends_fans, null);
            holder = new ViewHolder(convertView);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Friend news = newsArray.get(position);
        holder.mItemFansName.setText(news.getName());
        holder.mItemFansFrom.setText(news.getFrom());
        holder.mItemFansJob.setText(news.getExpertise());

        // 把资源文件转化成Drawable
        Drawable male = UIUtils.getResources().getDrawable(R.drawable.userinfo_icon_male);
        Drawable female = UIUtils.getResources().getDrawable(R.drawable.userinfo_icon_female);
        if (news.getGender() == 1) {
            holder.mItemFansGender.setImageDrawable(male);
        } else {
            holder.mItemFansGender.setImageDrawable(female);
        }

        Picasso.with(UIUtils.getContext()).load(news.getPortrait()).into(holder.mItemFansIcon);


        return convertView;
    }
    //============================================

    /**
     * This class contains all butterknife-injected Views & Layouts from layout file 'item_friends_fans.xml'
     * for easy to all layout elements.
     *
     * @author ButterKnifeZelezny, plugin for Android Studio by Avast Developers (http://github.com/avast)
     */
    static class ViewHolder {
        @InjectView(R.id.item_fans_icon)
        ImageView mItemFansIcon;
        @InjectView(R.id.item_fans_gender)
        ImageView mItemFansGender;
        @InjectView(R.id.item_fans_name)
        TextView mItemFansName;
        @InjectView(R.id.item_fans_from)
        TextView mItemFansFrom;
        @InjectView(R.id.item_fans_job)
        TextView mItemFansJob;

        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
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


