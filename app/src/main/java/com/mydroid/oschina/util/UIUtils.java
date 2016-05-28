
package com.mydroid.oschina.util;


import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;

import com.mydroid.oschina.base.MyApplication;


/**
 * 创建者     伍碧林
 * 创建时间   2016/5/3 10:47
 * 描述	      和ui相关的操作方法
 * <p/>
 * 更新者     $Author: admin $
 * 更新时间   $Date: 2016-05-07 14:18:38 +0800 (星期六, 07 五月 2016) $
 * 更新描述   ${TODO}
 */
public class UIUtils {
    /**
     * 得到上下文
     */
    public static Context getContext() {
        return MyApplication.getContext();
    }

    /**
     * 得到Resource对象
     */
    public static Resources getResources() {
        return getContext().getResources();
    }

    /**
     * 得到String.xml中的字符信息
     */
    public static String getString(int resId) {
        return getResources().getString(resId);
    }

    /**
     * 得到String.xml中的字符数组信息
     */
    public static String[] getStrings(int resId) {
        return getResources().getStringArray(resId);
    }

    /**
     * 得到color.xml中的颜色信息
     */
    public static int getColor(int resId) {
        return getResources().getColor(resId);
    }

    /**
     * 得到应用程序的包名
     *
     * @return
     */
    public static String getPackageName() {
        return getContext().getPackageName();
    }

    /**
     * dip-->px
     *
     * @param dip
     * @return
     */
    public static int dip2px(int dip) {
        //1. px/(ppi/160) = dp
        //2. px/dip = density;

        /*
        240x320  ppi=120
        320x480  ppi=160  1px=1dp
        480x800  ppi=240  1.5px=1dp
        720x1280 ppi=320  2px=1dp

         */


        float density = getResources().getDisplayMetrics().density;
//       float densityDpi = getResources().getDisplayMetrics().densityDpi;
        int px = (int) (dip * density + .5f);
        return px;
    }

    public static int px2Dip(int px) {
        float density = getResources().getDisplayMetrics().density;
        // px/dip = density;
        int dip = (int) (px / density + .5f);
        return dip;
    }


    /**
     * 安全的执行一个任务
     *
     * @param
     */
    public static void postTaskSafely(Runnable task) {
        int myTid = android.os.Process.myTid();
        int mainThreadId = MyApplication.getMainThreadId();
        if (myTid == mainThreadId) {
            //说明当前线程是主线程-->直接运行任务
            task.run();
        } else {
            //否则是子线程-->添加到线程队列中去
            Handler handler = MyApplication.getMainHandler();
            handler.post(task);
        }
    }


}

