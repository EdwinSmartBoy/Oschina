package com.mydroid.oschina.fragment;

import android.view.View;
import android.widget.TextView;

import com.mydroid.oschina.base.BaseFragment;
import com.mydroid.oschina.base.LoadingPager;
import com.mydroid.oschina.util.UIUtils;

/**
 * 创建者     林伯任
 * 创建时间   2016/5/13 16:08
 * 描述	      ${TODO}
 * <p/>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public class CodeFragment extends BaseFragment {
    @Override
    public LoadingPager.LoadedResult initData() {
        return LoadingPager.LoadedResult.EMPTY;
    }

    @Override
    protected View initSuccessView() {
        TextView tv = new TextView(UIUtils.getContext());
        tv.setText(getClass().getSimpleName()+"test");
        return tv;
    }
}
