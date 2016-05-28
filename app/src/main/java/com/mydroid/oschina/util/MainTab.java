package com.mydroid.oschina.util;

import com.mydroid.oschina.R;
import com.mydroid.oschina.fragment.ComprehensiveFragment;
import com.mydroid.oschina.fragment.FindFragment;
import com.mydroid.oschina.fragment.MinePageFragment;
import com.mydroid.oschina.fragment.NewTweetFragment;
import com.mydroid.oschina.fragment.TweetsFragment;


public enum MainTab{


        ZHONGHE(0,"综合", R.drawable.roiadbtn_news, ComprehensiveFragment.class),
    DONGTAN(1,"动弹", R.drawable.roiadbtn_dt, TweetsFragment.class),
    QUICK(2, "加號", R.drawable.roiadbtn_dt, NewTweetFragment.class),
    FOUND(3,"发现", R.drawable.roiadbtn_found, FindFragment.class),
    MINE(4,"我", R.drawable.roiadbtn_mine, MinePageFragment.class);

    private int idenx;
    private String resName;
    private int resIcon;
    private Class<?> clazz;

    MainTab(int idenx, String resName, int resIcon, Class<?> clazz) {
        this.idenx = idenx;
        this.resName = resName;
        this.resIcon = resIcon;
        this.clazz = clazz;
    }

    public int getIdenx() {
        return idenx;
    }

    public void setIdenx(int idenx) {
        this.idenx = idenx;
    }

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    public int getResIcon() {
        return resIcon;
    }

    public void setResIcon(int resIcon) {
        this.resIcon = resIcon;
    }

    public Class<?> getClazz() {
        return clazz;
    }

    public void setClazz(Class<?> clazz) {
        this.clazz = clazz;
    }
}