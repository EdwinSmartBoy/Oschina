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
 * 描述        我的界面-->消息界面-->@我界面的适配器
 * <p/>
 * 更新者      Edwin
 * 更新时间    ${TODO}
 * 更新描述    ${TODO}
 */
public class MessageRemindAdapter extends BaseAdapter {

    private static final String TAG = "MessageRemindAdapter";
    List<Active> activeArray = new ArrayList<>();

    /**
     * 设置数据内容
     *
     * @param list
     */
    public void updateData(List<Active> list) {
        activeArray.clear();
        activeArray.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        if (activeArray != null && activeArray.size() > 0) {
            return activeArray.size();
        }
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = View.inflate(UIUtils.getContext(), R.layout.item_msg_remind, null);

            //实例化对象
            holder = new ViewHolder(convertView);

            convertView.setTag(holder);
        } else {
            //
            holder = (ViewHolder) convertView.getTag();
        }
        //获取数据
        Active active = activeArray.get(position);

        //设置数据
        holder.name.setText(active.getAuthor());
        holder.content.setText(Html.fromHtml(active.getMessage()));
        holder.updateTime.setText(active.getPubDate());

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
        TextView name;
        @InjectView(R.id.tv_status)
        TextView status;
        @InjectView(R.id.tv_time)
        TextView updateTime;
        @InjectView(R.id.tv_response)
        TextView content;

        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}
