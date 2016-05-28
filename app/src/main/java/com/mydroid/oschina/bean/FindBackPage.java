package com.mydroid.oschina.bean;

import com.mydroid.oschina.fragment.EventFragment;
import com.mydroid.oschina.fragment.FriendsFragment;
import com.mydroid.oschina.fragment.ScanFragment;
import com.mydroid.oschina.fragment.ShakeFragment;
import com.mydroid.oschina.ui.FindUserActivity;

/**
 * 创建者     九天玄尘
 * 创建时间   2016/5/17 0:05
 * 描述	      ${TODO}
 * <p/>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public enum FindBackPage {

    FIND_FRIENDS(1, "朋友圈", FriendsFragment.class),
    FIND_FINDUSER(2, "找人", FindUserActivity.class),
    FIND_EVENT(3, "活动", EventFragment.class),
    FIND_SCAN(4, "扫一扫",ScanFragment.class),
    FIND_SHAKE(5, "摇一摇", ShakeFragment.class);


    private String title;
    private Class<?> clz;
    private int value;

    private FindBackPage(int value, String title, Class<?> clz) {
        this.value = value;
        this.title = title;
        this.clz = clz;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Class<?> getClz() {
        return clz;
    }

    public void setClz(Class<?> clz) {
        this.clz = clz;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public static FindBackPage getPageByValue(int val) {
        for (FindBackPage p : values()) {
            if (p.getValue() == val)
                return p;
        }
        return null;
    }
}
