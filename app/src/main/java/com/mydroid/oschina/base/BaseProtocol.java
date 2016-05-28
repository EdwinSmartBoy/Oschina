package com.mydroid.oschina.base;

import android.support.annotation.NonNull;

import com.mydroid.oschina.bean.Constants;
import com.mydroid.oschina.util.FileUtils;
import com.mydroid.oschina.util.HttpUtils;
import com.mydroid.oschina.util.IOUtils;
import com.mydroid.oschina.util.LogUtils;
import com.mydroid.oschina.util.UIUtils;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 创建者      Created by Edwin
 * 创建时间    2016/05/13
 * 描述        网络矿建的封装  OkHttpUtils
 * <p/>
 * 更新者      Edwin
 * 更新时间    ${TODO}
 * 更新描述    ${TODO}
 */

public abstract class BaseProtocol<T> {
    /**
     * 1.先内存-->返回
     * 2.在本地-->存内存,返回
     * 3.在网络-->存内存,存本地,返回
     *
     * @param index
     * @return
     * @throws Exception
     */
    public T loadData(int index) throws Exception {
        T t = null;
        //1.先内存-->返回
        //初始化MyApplication对象
        MyApplication app = (MyApplication) UIUtils.getContext();//getApplicationContext();
        //获取内存缓存目录
        Map<String, String> protocolCacheMap = app.getProtocolCacheMap();
        String key = generateKey(index);
        if (protocolCacheMap.containsKey(key)) {//存在内存缓存
            String memCacheJsonString = protocolCacheMap.get(key);
            t = parseJsonString(memCacheJsonString);
            if (t != null) {
                LogUtils.s("从内存加载数据-->" + generateKey(index));
                return t;
            }
        }

        //2.在本地-->存内存,返回
        t = loadDataFromLocal(index);
        if (t != null) {
            LogUtils.s("从本地加载数据-->" + getCacheFile(index).getAbsolutePath());
            return t;
        }
        //3.在网络-->存内存,存本地,返回
        return loadDataFromNet(index);

    }

    /**
     * 返回协议内存缓存和磁盘缓存对应的key信息
     *
     * @param index
     * @return 返回关键字组拼的URL
     */
    @NonNull
    private String generateKey(int index) {
        LogUtils.d("generateKey-->"+getInterfaceKey()  + index);
        return getInterfaceKey()  + index;
    }

    /**
     * 从本地加载协议内容
     *
     * @param index
     * @return
     */
    private T loadDataFromLocal(int index) {
        BufferedReader reader = null;
        try {
            //获取缓存目录
            File cacheFile = getCacheFile(index);
            if (cacheFile.exists()) {//有可能有有效的缓存
                //读取第一行,读取出缓存生成时间
                reader = new BufferedReader(new FileReader(cacheFile));
                String firstLine = reader.readLine();

                long cacheInsertTime = Long.parseLong(firstLine);

                //设置协议的有效时长
                if (System.currentTimeMillis() - cacheInsertTime < Constants.PROTOCOL_TIMEOUT) {
                    String cacheJsonString = reader.readLine();
                    /*--------------- 存内存 ---------------*/
                    MyApplication app = (MyApplication) UIUtils.getContext();
                    //将数据存储到内存中
                    Map<String, String> protocolCacheMap = app.getProtocolCacheMap();
                    protocolCacheMap.put(generateKey(index), cacheJsonString);
                    LogUtils.s("保存数据到内存-->" + generateKey(index));
                    T t = parseJsonString(cacheJsonString);
                    if (t != null) {
                        return t;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            IOUtils.close(reader);
        }
        return null;
    }

    /**
     * 得到缓存相应的文件
     *
     * @param index 缓存的index页面的数据
     * @return
     */
    @NonNull
    private File getCacheFile(int index) {
        String dir = FileUtils.getDir("xml");//sdcard/Android/data/包目录/xml
        String fileName = generateKey(index);
        return new File(dir, fileName);
    }

    /**
     * 从网络加载数据
     *
     * @param index
     * @return
     * @throws IOException
     */
    private T loadDataFromNet(int index) throws IOException {
        //1.创建okHttpClient对象
        OkHttpClient okHttpClient = new OkHttpClient();

        //2.创建请求对象
        //http://188.188.4.410:8080/oschina/detail/blog_detail/470948.xml
        //http://188.188.4.410:8080/oschina/list/blog/page0.xml
        //http://188.188.4.410:8080/oschina/-->BASE_URL
        //getInterfaceKey()-->比如:list/mytweet/page
        // ?index=0
        String url = Constants.BASE_URL + getInterfaceKey();  //news

        //定义参数的map
        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("page", index);

        //对参数map进行拼接
        String urlParamsByMap = HttpUtils.getUrlParamsByMap(paramsMap);

        url = url + "/" + urlParamsByMap;
        LogUtils.i("url->" + url);
        Request request = new Request.Builder().get().url(url).build();

        //3.发起请求-->同步
        Response response = okHttpClient.newCall(request).execute();

        if (response.isSuccessful()) {
            /*--------------- 1.得到网络请求的数据 ---------------*/
            String resJsonString = response.body().string();
            /*--------------- 2.保存协议内容到本地 ---------------*/
            BufferedWriter writer = null;
            try {
                File cacheFile = getCacheFile(index);
                writer = new BufferedWriter(new FileWriter(cacheFile));
                //写入第一行
                writer.write(System.currentTimeMillis() + "");
                //换行
                writer.newLine();
                //写入第二行
                writer.write(resJsonString);

                LogUtils.s("保存数据到本地-->" + getCacheFile(index).getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                IOUtils.close(writer);
            }
            /*--------------- 3.存内存 ---------------*/
            MyApplication app = (MyApplication) UIUtils.getContext();
            Map<String, String> protocolCacheMap = app.getProtocolCacheMap();
            protocolCacheMap.put(generateKey(index), resJsonString);
            LogUtils.s("保存数据到内存-->" + generateKey(index));

            T t = parseJsonString(resJsonString);
            return t;
        }
        return null;
    }

    /**
     * @return 得到协议的关键字
     * 在BaseProtocol中不知道具体的协议关键字是啥, 交给子类,必须实现
     * 必须实现, 但是不知道具体实现, 定义成为抽象方法, 交给子类具体实现
     * 当前的base_url为 http://188.188.4.41:8080/oschina/  后面的需要自己手动添加
     */
    public abstract String getInterfaceKey();


    /**
     * @param resJsonString
     * @return 解析网络请求回来的数据, 有两种情况
     * 在BaseProtocol中不知道具体如何解析, 交给子类,必须实现
     * 必须实现, 但是不知道具体实现, 定义成为抽象方法, 交给子类具体实现
     * jsonString-->bean
     * jsonString-->List Map
     */
    public abstract T parseJsonString(String resJsonString);
}

