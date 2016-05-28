package com.mydroid.oschina.fragment;

import com.mydroid.oschina.adapter.ViewPagerFragmentAdapter;

/**
 * @创建时间 Administrator on 2016/5/12 0012.
 */
public class ComprehensiveFragment extends BaseViewPagerFragment {


    @Override
    public void onSetupAdapter(ViewPagerFragmentAdapter adapter) {
        // 4. 给数据适配器添加数据
        adapter.addTab("资讯", ZHMessageFragment.class, getBundle(""));
        adapter.addTab("热点", ZHHotspotFragment.class, getBundle(""));
        adapter.addTab("博客", ZHBlogsFragment.class, getBundle(""));
        adapter.addTab("推荐", ZHRecommendFragment.class, getBundle(""));
    }
}
