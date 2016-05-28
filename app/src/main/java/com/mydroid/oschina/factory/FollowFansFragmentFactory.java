package com.mydroid.oschina.factory;

import android.support.v4.app.Fragment;

import com.mydroid.oschina.fragment.FansFragment;
import com.mydroid.oschina.fragment.FollowsFragment;

/**
 * 创建者     林伯任
 * 创建时间   2016/5/13 21:02
 * 描述	      ${TODO}
 * <p/>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public class FollowFansFragmentFactory {
    public static final int FOLLOWS = 0;
    public static final int FANS = 1;


    public static Fragment createFragment(int position) {
        //fragment的创建
        Fragment fragment = null;
        switch (position) {
            case FOLLOWS:
                fragment = new FollowsFragment();
                break;
            case FANS:
                fragment = new FansFragment();
                break;

        }
        //返回fragment
        return fragment;
    }
}
