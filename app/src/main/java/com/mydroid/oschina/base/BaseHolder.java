package com.mydroid.oschina.base;

import android.view.View;

/**
 * 创建者     林伯任
 * 创建时间   2016/5/12 19:38
 * 描述	      ${TODO}
 * <p/>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public abstract class BaseHolder<HOLDERBEANTYPE> {
    public View mHolderView;
    public HOLDERBEANTYPE mData;

    public BaseHolder() {
        mHolderView = initHolderView();

        mHolderView.setTag(this);
    }

    public void setDataAndRefleshHolderView(HOLDERBEANTYPE data) {
        mData  = data;
        refleshHolderView(data);

    }


    /**
     * 决定视图长什么样子
     * @return
     */
    public abstract View initHolderView();


    /**
     * 数据和视图的绑定操作
     */
    public abstract void refleshHolderView(HOLDERBEANTYPE data) ;



}
