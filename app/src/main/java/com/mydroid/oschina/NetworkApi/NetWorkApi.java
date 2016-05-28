package com.mydroid.oschina.NetworkApi;

/**
 * 二次封装
 */
public class NetWorkApi {
    public static void getNewsList(int page, int catalog,
                                   ApiHttpClient.OnHttpResultHandler handler) {
        String path = null;
        switch (catalog){
            case 1:
                path = "oschina/list/news/page"+page+".xml";
                break;
            case 4:
                path = "oschina/list/hotspot/page"+page+".xml";
                break;
        }

        if(path == null){
            return;
        }

        ApiHttpClient.get(path, handler);
    }
}
