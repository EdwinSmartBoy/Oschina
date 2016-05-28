package com.mydroid.oschina.factory;

import android.support.v4.app.Fragment;

import com.mydroid.oschina.fragment.ZHBlogsFragment;
import com.mydroid.oschina.fragment.ZHHotspotFragment;
import com.mydroid.oschina.fragment.ZHMessageFragment;
import com.mydroid.oschina.fragment.ZHRecommendFragment;

/**
 * 创建者     叶庆荣
 * 创建时间   2016/5/11 21:13
 * 描述	      FragmentFactory的创建工厂
 * <p/>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}$
 */
public class FragmentFactory {

    public static final int MESSAGE = 0;
    public static final int HOTSPOT = 1;
    public static final int BLOGS = 2;
    public static final int RECOMMEND = 3;




    public static Fragment createFragment(int position) {
        //fragment的创建
        Fragment fragment = null;
        switch (position) {
            case MESSAGE:
                fragment = new ZHMessageFragment();
                break;
            case HOTSPOT:
                fragment = new ZHHotspotFragment();

                break;
            case BLOGS:
                fragment = new ZHBlogsFragment();
                break;
            case RECOMMEND:
                fragment = new ZHRecommendFragment();
                break;

            default:
                break;
        }
        //返回fragment
        return fragment;
    }
}
