package com.mydroid.oschina.base;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建者     林伯任
 * 创建时间   2016/5/6 23:45
 * 描述	      ${TODO}
 * 描述	      对Adapter进行封装
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public class MyBaseAdapter<ITEMBEANTYPE> extends BaseAdapter {

    public List<ITEMBEANTYPE> mdataSet = new ArrayList<>();

    public MyBaseAdapter(List<ITEMBEANTYPE> mdataSet) {
        this.mdataSet = mdataSet;
    }

    @Override
    public int getCount() {
        return mdataSet != null ? mdataSet.size() : 0;
    }


    /*--------------------*/
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
        return null;
    }


}
