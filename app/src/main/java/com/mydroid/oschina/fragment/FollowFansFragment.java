package com.mydroid.oschina.fragment;

import com.mydroid.oschina.adapter.ViewPagerFragmentAdapter;

/**
 * 创建者     林伯任
 * 创建时间   2016/5/13 14:20
 * 描述	      我的页面-->粉丝/关注界面
 * <p/>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public class FollowFansFragment extends BaseViewPagerFragment {



    @Override
    public void onSetupAdapter(ViewPagerFragmentAdapter adapter) {

        adapter.addTab("粉丝",FollowsFragment.class,getBundle(""));
        adapter.addTab("粉丝",FansFragment.class,getBundle(""));
    }
}
