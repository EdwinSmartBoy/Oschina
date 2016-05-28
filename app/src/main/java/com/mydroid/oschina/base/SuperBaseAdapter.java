package com.mydroid.oschina.base;

import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * 创建者     林伯任
 * 创建时间   2016/5/10 19:53
 * 描述	      ${TODO}
 * <p/>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public abstract class SuperBaseAdapter<ITEMBEANTYPE> extends MyBaseAdapter {


    public SuperBaseAdapter(List mdataSet) {
        super(mdataSet);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BaseHolder baseHolder = null;
        if(convertView==null){
            baseHolder = getSpecialHolder();
        }else{
            baseHolder  = (BaseHolder) convertView.getTag();
        }

        baseHolder.setDataAndRefleshHolderView(mdataSet.get(position));
        return baseHolder.mHolderView;
    }

    /**
     * 创建holder
     * @return
     */
    public abstract BaseHolder getSpecialHolder();
}
