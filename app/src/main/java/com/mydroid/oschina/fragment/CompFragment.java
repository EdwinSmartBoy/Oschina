package com.mydroid.oschina.fragment;

/**
 * @创建时间 Administrator on 2016/5/12 0012.
 */


public class CompFragment  {

   /* private PagerSlidingTabStripExtends mZHTabs;
    private ViewPager                   mZhViewPager;
    private String[]                    mZhTitleArr;

    //加载具体的数据
    @Override
    public LoadingPager.LoadedResult initData() {
        return LoadingPager.LoadedResult.SUCCESS;
    }

    *//**
     * @return
     * @des 初始化成功视图-->决定视图长什么样子
     * @des 绑定具体的数据-->因为这个视图最终是展示给用户看的
     * @called 外界触发加载了数据, 而且数据加载完成了, 而且数据加载成功了
     *//*
    @Override
    protected View initSuccessView() {

        View rootview = View.inflate(UIUtils.getContext(), R.layout.compfragment, null);

        mZHTabs = (PagerSlidingTabStripExtends) rootview.findViewById(R.id.comp_tabs);
        mZhViewPager = (ViewPager) rootview.findViewById(R.id.comp_viewpager);

        mZhTitleArr = UIUtils.getStrings(R.array.zh_titles);

        //给ViewPager 设置适配器
        MainFragmentPagerAdapter adapter = new MainFragmentPagerAdapter(getChildFragmentManager());
        mZhViewPager.setAdapter(adapter);

        // Bind the tabs to the ViewPager
        mZHTabs.setViewPager(mZhViewPager);

        //绑定数据后的视图
        return rootview;
    }


    class MainFragmentPagerAdapter extends FragmentStatePagerAdapter {

        public MainFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            Fragment fragment = FragmentFactory.createFragment(position);
            return fragment;
        }

        @Override
        public int getCount() {
            if (mZhTitleArr != null) {
                return mZhTitleArr.length;
            }
            return 0;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mZhTitleArr[position];
        }

    }
*/

}
