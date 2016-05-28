package com.mydroid.oschina.factory;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.widget.ListView;

import com.mydroid.oschina.util.UIUtils;

/**
 * 创建者     叶庆荣
 * 创建时间   2016/5/13 10:36
 * 描述	      ListView的工厂模式
 * <p/>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public class ListViewFactory {
    public static ListView creatListView() {
        ListView listView = new ListView(UIUtils.getContext());
        listView.setDividerHeight(0);
        listView.setCacheColorHint(Color.TRANSPARENT);
        listView.setSelector(new ColorDrawable(Color.TRANSPARENT));
        return listView;
    }
}
