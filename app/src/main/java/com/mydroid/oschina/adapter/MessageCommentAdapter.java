package com.mydroid.oschina.adapter;

import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mydroid.oschina.R;
import com.mydroid.oschina.bean.Active;
import com.mydroid.oschina.util.UIUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * 创建者      Created by Edwin
 * 创建时间    2016/05/15
 * 描述        我的-->消息中心-->评论
 * <p/>
 * 更新者      Edwin
 * 更新时间    ${TODO}
 * 更新描述    ${TODO}
 */
public class MessageCommentAdapter extends BaseAdapter {

    private List<Active> mComments = new ArrayList<>();

    public void updateData(List<Active> actives) {
        mComments.clear();
        mComments.addAll(actives);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        if (mComments != null && mComments.size() > 0) {
            return mComments.size();
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

        //        TextView textView = new TextView(UIUtils.getContext());
        //        textView.setText(mComments.get(position).getAuthor());
        //        textView.setTextColor(Color.BLACK);
        //        convertView = textView;
        Active active = mComments.get(position);
        String time = active.getPubDate().split(" ")[0];
        holder.mTvName.setText(active.getAuthor());

        holder.mTvTime.setText(time);

        holder.mTvDes.setText(Html.fromHtml(active.getMessage()));
        holder.mTvTime.setText(active.getPubDate());
        holder.mTvSup.setText(active.getObjectReply().getObjectName() + active.getObjectReply().getObjectBody());
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

    /**
     * This class contains all butterknife-injected Views & Layouts from layout file 'item_msg_commend.xml'
     * for easy to all layout elements.
     *
     * @author ButterKnifeZelezny, plugin for Android Studio by Avast Developers (http://github.com/avast)
     */
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
