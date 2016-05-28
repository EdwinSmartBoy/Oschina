package com.mydroid.oschina.fragment;

import com.mydroid.oschina.adapter.ViewPagerFragmentAdapter;

/**
 * 创建者     林伯任
 * 创建时间   2016/5/13 14:20
 * 描述	      我的页面的收藏页面
 * <p/>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public class CollectedFragment extends BaseViewPagerFragment {
  /*  private PagerSlidingTabStripExtends mPagerTab;
    private ViewPager mViewPager;

    private String[] mDatases = {
            "软件",
            "话题",
            "代码",
            "博客",
            "资讯"
    };*/

    @Override
    public void onSetupAdapter(ViewPagerFragmentAdapter adapter) {
        adapter.addTab("软件",SoftWareFragment.class,getBundle(""));
        adapter.addTab("话题",TopicFragment.class,getBundle(""));
        adapter.addTab("代码",CodeFragment.class,getBundle(""));
        adapter.addTab("博客",BlogFragment.class,getBundle(""));
        adapter.addTab("资讯",ZMessageFragment.class,getBundle(""));
    }

    /*@Override
    public LoadingPager.LoadedResult initData() {
        return LoadingPager.LoadedResult.SUCCESS;
    }

    @Override
    protected View initSuccessView() {
        View rootView = View.inflate(UIUtils.getContext(), R.layout.fragment_collected, null);
        mPagerTab = (PagerSlidingTabStripExtends) rootView.findViewById(R.id.collected_pagertab);

        mViewPager = (ViewPager) rootView.findViewById(R.id.colleted_viewpager);

        CollFragmentPagerAdapter adapter = new CollFragmentPagerAdapter(getActivity().getSupportFragmentManager());
        mViewPager.setAdapter(adapter);

        //绑定VeiwPager
        mPagerTab.setViewPager(mViewPager);

        TextView tv = new TextView(UIUtils.getContext());
        tv.setText("测试测试");
        return rootView;
    }

    *//**
     * ViewPager的适配器
     *//*
    class CollFragmentPagerAdapter extends FragmentPagerAdapter {

        public CollFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            //根据下标创建Fragment
            //滑动的时候加载软件/代码/博客/资讯页面
            Fragment fragment = CollectedFragmentFactory.createFragment(position);
            return fragment;
        }

        @Override
        public int getCount() {
            if (mDatases != null) {
                return mDatases.length;
            }
            return 0;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mDatases[position];
        }

    }*/
}
