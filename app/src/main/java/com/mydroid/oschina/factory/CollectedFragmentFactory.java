package com.mydroid.oschina.factory;

import android.support.v4.app.Fragment;

import com.mydroid.oschina.fragment.BlogFragment;
import com.mydroid.oschina.fragment.CodeFragment;
import com.mydroid.oschina.fragment.SoftWareFragment;
import com.mydroid.oschina.fragment.TopicFragment;
import com.mydroid.oschina.fragment.ZMessageFragment;

/**
 * 创建者     叶庆荣
 * 创建时间   2016/5/13 9:36
 * 描述	      ${TODO}
 * <p/>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public class CollectedFragmentFactory {

        public static final int SOFTWARE = 0;
        public static final int TOPIC = 1;
        public static final int CODE  = 2;
        public static final int BLOG  = 3;
        public static final int ZMESSAGE  = 4;


        public static Fragment createFragment(int position) {
            //fragment的创建
            Fragment fragment = null;
            switch (position) {
                case SOFTWARE:
                    fragment = new SoftWareFragment();
                    break;
                case TOPIC:
                    fragment = new TopicFragment();
                    break;
                case CODE:
                    fragment = new CodeFragment();
                    break;
                case BLOG:
                    fragment = new BlogFragment();
                    break;
                case ZMESSAGE:
                    fragment = new ZMessageFragment();
                    break;
                default:
                    break;
            }
            //返回fragment
            return fragment;
    }
}
