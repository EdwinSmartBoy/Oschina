package com.mydroid.oschina.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mydroid.oschina.R;
import com.mydroid.oschina.util.LogUtils;

/**
 * 创建者     九天玄尘
 * 创建时间   2016/5/12 15:29
 * 描述	      暂时没用到
 * <p/>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public class SettingItemView extends RelativeLayout{

    private String[] text = {"朋友圈","找人","活动","扫一扫","摇一摇"};
    private int[] images = {R.drawable.icon_explore_friends,
                            R.drawable.icon_explore_finduser,
                            R.drawable.icon_explore_event,
                            R.drawable.icon_explore_scan,
                            R.drawable.icon_explore_shake};

    String namespace = "http://schemas.android.com/apk/res-auto";
    private TextView mTextView;
    private ImageView mImageView;

    public SettingItemView(Context context) {
        this(context,null);
    }



    public SettingItemView(Context context, AttributeSet attrs) {
        super(context, attrs);

        //布局文件中调用
        initView(attrs);
    }

    private void initView(AttributeSet attrs) {
        View  rootView= View.inflate(getContext(), R.layout.include_setting_item, this);

        mImageView = (ImageView) rootView.findViewById(R.id.iv_setting_item);
        mTextView = (TextView) rootView.findViewById(R.id.tv_setting_item);


        /*--------------- 文本 ---------------*/
        String desc = attrs.getAttributeValue(namespace, "desc");
       // mTextView.setText("成功");
        mTextView.setText(desc);

        /*--------------- 图片 ---------------*/
        for (int i = 0; i < text.length; i++) {

            if (desc == text[i] ) {

                mImageView.setImageResource(images[i]);
                LogUtils.s(images[i]+" ");
            }
        }

}}
