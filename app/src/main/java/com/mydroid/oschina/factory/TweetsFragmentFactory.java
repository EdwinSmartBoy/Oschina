package com.mydroid.oschina.factory;

import android.support.v4.app.Fragment;

import com.mydroid.oschina.fragment.HotTweetFragment;
import com.mydroid.oschina.fragment.MyTweetFragment;
import com.mydroid.oschina.fragment.NewTweetFragment;

/**
 * 创建者     叶庆荣
 * 创建时间   2016/5/13 9:36
 * 描述	      ${TODO}
 * <p/>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public class TweetsFragmentFactory {

        public static final int NEW_SPRING = 0;
        public static final int HOT_SPRING = 1;
        public static final int MY_SPRING  = 2;


        public static Fragment createFragment(int position) {
            //fragment的创建
            Fragment fragment = null;
            switch (position) {
                case NEW_SPRING:
                    fragment = new NewTweetFragment();
                    break;
                case HOT_SPRING:
                    fragment = new HotTweetFragment();
                    break;
                case MY_SPRING:
                    fragment = new MyTweetFragment();
                    break;
                default:
                    break;
            }
            //返回fragment
            return fragment;
    }
}
