package com.mydroid.oschina.holder;

import android.view.View;
import android.widget.TextView;

import com.mydroid.oschina.R;
import com.mydroid.oschina.util.UIUtils;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * @创建时间 Administrator on 2016/5/15 0015.
 */
public abstract class MyHolder<HOLDERBEANTYPE> {

    public View mHolderView;
    public HOLDERBEANTYPE mData;

    @InjectView(R.id.tv_title)
    public TextView mTvTitle;
    @InjectView(R.id.tv_content)
    public TextView mTvContent;
    @InjectView(R.id.tv_user_name)
    public TextView mTvUserName;
    @InjectView(R.id.tv_time)
    public TextView mTvTime;
    @InjectView(R.id.tv_comp_num)
    public TextView mTvCompNum;


    public MyHolder() {
        mHolderView = initHolderView();
        mHolderView.setTag(this);

    }

    public View initHolderView() {
        View rootView = View.inflate(UIUtils.getContext(), R.layout.item_comp, null);

        ButterKnife.inject(this, rootView);

        return rootView;
    }

    public void setDataAndRefleshHolderView(HOLDERBEANTYPE data) {
        mData = data;
        refleshHolderView(mData);

    }


    /**
     * 数据和视图的绑定操作
     */
    public abstract void refleshHolderView(HOLDERBEANTYPE mData);



}
