package com.mydroid.oschina.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mydroid.oschina.R;
import com.mydroid.oschina.bean.Messages;
import com.mydroid.oschina.util.UIUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 创建者      Created by Edwin
 * 创建时间    2016/05/15
 * 描述        ${TODO}
 * <p/>
 * 更新者      Edwin
 * 更新时间    ${TODO}
 * 更新描述    ${TODO}
 */
public class MessageWordAdapter extends BaseAdapter {

    private List<Messages> mMessagesList = new ArrayList<>();

    public void updateData(List<Messages> messages) {
        mMessagesList.clear();
        mMessagesList.addAll(messages);
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
            convertView = View.inflate(UIUtils.getContext(), R.layout.item_msg_message_word, null);
            holder = new ViewHolder(convertView);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Messages messages = mMessagesList.get(position);

        holder.mTvName.setText(messages.getFriendName());
        holder.mTvSup.setText(messages.getContent());
        holder.mTvTime.setText(messages.getPubDate());
        holder.mTvMessageCount.setText(messages.getMessageCount() + "条留言");

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

        @InjectView(R.id.civ_user_pic)
        CircleImageView mCivUserPic;
        @InjectView(R.id.tv_name)
        TextView mTvName;
        @InjectView(R.id.tv_sup)
        TextView mTvSup;
        @InjectView(R.id.tv_time)
        TextView mTvTime;
        @InjectView(R.id.tv_message_count)
        TextView mTvMessageCount;

        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}
