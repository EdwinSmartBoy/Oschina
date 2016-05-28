package com.mydroid.oschina.fragment;


import com.mydroid.oschina.adapter.ViewPagerFragmentAdapter;

/**
 * ------------------------------------------
 * Created by poplar on 2016/5/14.
 * <p/>
 * 描    述:
 * <p/>
 * 修订历史:
 * ------------------------------------------
 */
public class NewsViewPagerFragment extends BaseViewPagerFragment {

    @Override
    public void onSetupAdapter(ViewPagerFragmentAdapter adapter) {
        // 4. 给数据适配器添加数据
        adapter.addTab("资讯", ZHMessageFragment.class, getBundle(""));
        adapter.addTab("热点", DefaultFragment.class, getBundle(""));
        adapter.addTab("博客", ZHBlogsFragment.class, getBundle(""));
        adapter.addTab("推荐", DefaultFragment.class, getBundle(""));
    }
}
