package com.mydroid.oschina.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mydroid.oschina.R;
import com.mydroid.oschina.bean.Friend;
import com.mydroid.oschina.util.UIUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * 创建者      Created by Edwin
 * 创建时间    2016/05/15
 * 描述        我的-->消息中心-->粉丝
 * <p/>
 * 更新者      Edwin
 * 更新时间    ${TODO}
 * 更新描述    ${TODO}
 */
public class MessageFansAdapter extends BaseAdapter {

    private List<Friend> mMessagesList = new ArrayList<>();


    public void updateData(List<Friend> friends) {
        mMessagesList.clear();
        mMessagesList.addAll(friends);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        if (mMessagesList != null && mMessagesList.size() > 0) {
            return mMessagesList.size();
        }
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = View.inflate(UIUtils.getContext(), R.layout.item_msg_fans, null);

            //实例化对象
            holder = new ViewHolder(convertView);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Friend friend = mMessagesList.get(position);

        holder.mTvName.setText(friend.getName());
        holder.mTvResponse.setText(friend.getExpertise());
        holder.mTvStatus.setText(friend.getFrom());
        int gender = friend.getGender();
        if (gender == 1) {
            holder.mImageView.setImageResource(R.drawable.userinfo_icon_male);
        } else {
            holder.mImageView.setImageResource(R.drawable.userinfo_icon_female);
        }
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

    class ViewHolder {

        @InjectView(R.id.tv_name)
        TextView mTvName;
        @InjectView(R.id.tv_status)
        TextView mTvStatus;
        @InjectView(R.id.tv_response)
        TextView mTvResponse;
        @InjectView(R.id.iv_gender)
        ImageView mImageView;

        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}
