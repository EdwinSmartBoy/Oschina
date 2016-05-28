package com.mydroid.oschina.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mydroid.oschina.R;
import com.mydroid.oschina.util.UIUtils;

import org.w3c.dom.Text;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * 创建者     林伯任
 * 创建时间   2016/5/17 19:32
 * 描述	      ${TODO}
 * <p/>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public class MenuAdapter extends BaseAdapter {

    String[] mtitles = {"技术问答", "开源软件", "博客区", "Git客户端"};
    int[] mIcons = {R.drawable.drawer_menu_icon_quest,
            R.drawable.drawer_menu_icon_opensoft,
            R.drawable.drawer_menu_icon_blog,
            R.drawable.drawer_menu_icon_gitapp};


    @Override
    public int getCount() {
        return mtitles.length;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = View.inflate(UIUtils.getContext(), R.layout.item_left_menu, null);
        ImageView mItemIcon = (ImageView) convertView.findViewById(R.id.item_icon);
        TextView tv = (TextView) convertView.findViewById(R.id.item_text);

        mItemIcon.setImageResource(mIcons[position]);
        tv.setText(mtitles[position]);
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
}
