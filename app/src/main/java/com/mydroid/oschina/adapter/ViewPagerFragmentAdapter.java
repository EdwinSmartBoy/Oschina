package com.mydroid.oschina.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import com.astuetz.PagerSlidingTabStripExtends;

import java.util.ArrayList;
import java.util.List;

/**
 * ViewPager数据适配器
 */
public class ViewPagerFragmentAdapter extends FragmentStatePagerAdapter {
    //
    // FragmentStatePagerAdapter 可以节省内存


    List<ViewPageInfo> infos = new ArrayList<>();
    private       PagerSlidingTabStripExtends tabStrip;
    private final Context              context;

    public ViewPagerFragmentAdapter(FragmentManager fm,
                                    PagerSlidingTabStripExtends tabStrip,
                                    ViewPager pager) {
        super(fm);
        this.tabStrip = tabStrip;

        // 2. 给ViewPager设置数据适配器
        pager.setAdapter(this);
        // 3. 把导航栏和ViewPager关联起来
        tabStrip.setViewPager(pager);

        // 获取上下文
        context = pager.getContext();
    }

    /**
     * 每添加一个, 刷新一次数据适配器
     *
     * @param title
     * @param fragment
     */
    public void addTab(String title, Class<?> fragment, Bundle bundle) {
        ViewPageInfo info = new ViewPageInfo(title, fragment, bundle);
        infos.add(info);

        tabStrip.notifyDataSetChanged();
        notifyDataSetChanged(); // 刷新内容
    }

    @Override
    public Fragment getItem(int position) {
        ViewPageInfo info = infos.get(position);
        return Fragment.instantiate(context, info.clazz.getName(), info.bundle);
    }

    @Override
    public int getCount() {
        return infos.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return infos.get(position).title;
    }

    class ViewPageInfo {
        String title;
        Class<?> clazz;
        Bundle bundle;

        public ViewPageInfo(String title, Class<?> clazz, Bundle bundle) {
            this.title = title;
            this.clazz = clazz;
            this.bundle = bundle;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Class<?> getClazz() {
            return clazz;
        }

        public void setClazz(Class<?> clazz) {
            this.clazz = clazz;
        }

        public Bundle getBundle() {
            return bundle;
        }

        public void setBundle(Bundle bundle) {
            this.bundle = bundle;
        }
    }


}