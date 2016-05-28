package com.mydroid.oschina.fragment;

import com.mydroid.oschina.adapter.ViewPagerFragmentAdapter;

/**
 * 创建者     叶庆荣
 * 创建时间   2016/5/12 23:03
 * 描述	      动弹页面
 * <p/>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public class TweetsFragment extends BaseViewPagerFragment {


    @Override
    public void onSetupAdapter(ViewPagerFragmentAdapter adapter) {
        // 4. 给数据适配器添加数据
        adapter.addTab("最新动弹", NewTweetFragment.class, getBundle("最新动弹"));
        adapter.addTab("热点动弹", HotTweetFragment.class, getBundle("热点动弹"));
        adapter.addTab("我的动弹", MyTweetFragment.class, getBundle("我的动弹"));
    }

}
