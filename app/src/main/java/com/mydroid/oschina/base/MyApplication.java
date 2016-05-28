package com.mydroid.oschina.base;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

import com.mydroid.oschina.NetworkApi.ApiHttpClient;

import java.util.HashMap;
import java.util.Map;

/**
 * 创建者     九天玄尘
 * 创建时间   2016/5/4 8:30
 * 描述	     1, 一个可全局访问的单例
 * 描述	      2,记得在清单文件中注册
 * <p/>
 * <p/>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public class MyApplication extends Application {

    private static Context mContext;
    private static int mMainThreadId;
    private static Handler mMainHandler;

    /**
     * 协议缓存的内存缓存的存储结构
     */
    private Map<String, String> mProtocolLruMap = new HashMap<>();

    /**
     * 得到主线程id
     */
    public static int getMainThreadId() {
        return mMainThreadId;
    }

    /**
     * 得到主线程Handler
     *
     * @return
     */
    public static Handler getMainHandler() {
        return mMainHandler;
    }

    /**
     * 得到上下文
     *
     * @return
     */
    public static Context getContext() {
        return mContext;
    }

    /**
     * 定义属性
     * 定义方法
     */
    @Override
    public void onCreate() {
        super.onCreate();
        //1,得到上下文
        mContext = getApplicationContext();

        //2,得到主线程id
        mMainThreadId = android.os.Process.myTid();

        //3,得到主线程的handler
        mMainHandler = new Handler();

        //初始化网络加载框架
        ApiHttpClient.init(mContext);
    }

    /**
     * @return mProtocolLruMap
     * @desc 获取内存缓存的对象
     */
    public Map<String, String> getProtocolCacheMap() {
        return mProtocolLruMap;
    }
}
