package com.mydroid.oschina.NetworkApi;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.mydroid.oschina.util.MyStringRequest;

/**
 * 网络框架的封装
 */
public class ApiHttpClient {

    //主机名
    private static String API_URL_LOCAL = "http://188.188.4.41:8080/%s";

    private static RequestQueue mQueue;

    /**
     * 初始化网络请求框架-->在
     *
     * @param context ctrl + shift + g
     *                alt + F7
     */
    public static void init(Context context) {
        mQueue = Volley.newRequestQueue(context);
    }


    /**
     * 静态的get请求
     *
     * @param partUrl
     * @param handler
     */
    public static void get(String partUrl, final OnHttpResultHandler handler) {

        // 将路径和主机名 拼接
        String url = getLocalAbsoluteApiUrl(partUrl);
//        System.out.println("http--url= "+url);

        if (mQueue.getCache().get(url) != null) {
            // 缓存存在
            String response = new String(mQueue.getCache().get(url).data);
            handler.onSuccess(response);
        } else {
            MyStringRequest stringRequest = new MyStringRequest(
                    Request.Method.GET,  // 设置请求方式
                    url, // 设置请求路径
                    // 请求成功回调
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.d("TAG", response);

                            handler.onSuccess(response);
                        }
                    },
                    // 请求失败回调
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.e("TAG", error.getMessage(), error);
                            handler.onError(error.getCause());
                        }
                    }
            );
            mQueue.add(stringRequest);
        }

    }



    private static String getLocalAbsoluteApiUrl(String partUrl) {
        return String.format(API_URL_LOCAL, partUrl);
    }

    public interface OnHttpResultHandler {

        void onSuccess(String respose);

        void onError(Throwable e);
    }
}
