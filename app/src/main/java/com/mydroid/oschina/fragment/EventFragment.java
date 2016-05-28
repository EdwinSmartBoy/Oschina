package com.mydroid.oschina.fragment;

import com.mydroid.oschina.adapter.ViewPagerFragmentAdapter;

/**
 * 创建者     九天玄尘
 * 创建时间   2016/5/17 0:08
 * 描述	      ${TODO}
 * <p/>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public class EventFragment extends BaseViewPagerFragment{


    @Override
    public void onSetupAdapter(ViewPagerFragmentAdapter adapter) {
        // 4. 给数据适配器添加数据
        adapter.addTab("近期活动", RecentEventFragment.class, getBundle(""));
        adapter.addTab("我的活动", MyEventFragment.class, getBundle(""));
    }
}
