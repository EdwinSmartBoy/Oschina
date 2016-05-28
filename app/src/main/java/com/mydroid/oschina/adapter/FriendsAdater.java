package com.mydroid.oschina.adapter;


import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.mydroid.oschina.bean.Active;
import com.mydroid.oschina.holder.FriendsHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建者     九天玄尘
 * 创建时间   2016/5/17 15:15
 * 描述	      发现中朋友圈,适配器
 * <p/>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public class FriendsAdater extends BaseAdapter {

    List<Active> friendList = new ArrayList();

    /**
     * 设置数据内容
     * @param list
     */
    public void updateData(List<Active> list) {
        friendList.clear();
        friendList.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        if (friendList != null) {
            return friendList.size();
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


    //绑定视图
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        FriendsHolder friendHolder = null;
        if (convertView == null) {
            friendHolder = new FriendsHolder();
        }else{
            friendHolder = (FriendsHolder) convertView.getTag();
        }

        Active friend = friendList.get(position);
        friendHolder.setDataAndRefreshHolderView(friend);

        return friendHolder.mHolderView;
    }

    public void setData(List<Active> data) {
        friendList.addAll(data);
        notifyDataSetChanged();
    }
}
