package com.mydroid.oschina.holder;

import android.view.View;
import android.widget.TextView;

import com.mydroid.oschina.base.BaseHolder;
import com.mydroid.oschina.util.UIUtils;

/**
 * 创建者     林伯任
 * 创建时间   2016/5/13 16:17
 * 描述	      ${TODO}
 * <p/>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public class SoftWareHolder extends BaseHolder<String> {

    public TextView mSoftWareHolder;

    @Override
    public void refleshHolderView(String data) {
        mSoftWareHolder.setText(data+"我是xxxxxx哈哈哈");
    }

    @Override
    public View initHolderView() {
        mSoftWareHolder = new TextView(UIUtils.getContext());

        return mSoftWareHolder;
    }
}
