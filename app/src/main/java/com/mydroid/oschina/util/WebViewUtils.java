package com.mydroid.oschina.util;

import android.util.Base64;
import android.webkit.WebView;

import java.io.UnsupportedEncodingException;

/**
 * 创建者     林伯任
 * 创建时间   2016/5/15 22:37
 * 描述	      ${TODO}
 * <p/>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */

/**
 * 用来加载html数据
 */
public class WebViewUtils {
    /*public static void LoadWebViewData(WebView webView, String webData) {
        *//**
         *   @param data a String of data in the given encoding
         @param mimeType the MIME type of the data, e.g. 'text/html'
         @param encoding the encoding of the data
         *//*
        String data = webData;
        String mimeType = "text/html";
        String encoding = "utf-8";
        try {
            byte[] bytes = data.getBytes("Unicode");
            //编码
            byte[] encode = Base64.encode(bytes, Base64.DEFAULT);
            //转化成字符串
            data = new String(encode);
            //设置webview的编码集
            webView.getSettings().setDefaultTextEncodingName(encoding);

            //给webView设置数据
            webView.loadData(data, mimeType, encoding);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }*/


    /**
     * 用来加载webView显示数据
     *
     * @param wb
     * @param data
     */
   public static void loadWebViewData(WebView wb, String data) {
        try {
            byte[] unicodes = data.getBytes("Unicode");
            //String result = new String(unicodes);
            byte[] encode = Base64.encode(unicodes, Base64.DEFAULT);
            String encodeStr = new String(encode);
            wb.getSettings().setDefaultTextEncodingName("uft-8");

            wb.loadData(encodeStr, "text/html", "base64");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }


}
