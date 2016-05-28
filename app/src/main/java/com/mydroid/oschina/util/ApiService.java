package com.mydroid.oschina.util;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.mydroid.oschina.bean.Constants;

/**
 * 创建者     林伯任
 * 创建时间   2016/5/14 15:57
 * 描述	      ${TODO}
 * <p/>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public class ApiService {

    /**
     * 新闻资讯
     *
     * @param q
     * @param listener
     * @param page
     */
    public static void getNewsList(RequestQueue q,
                                   final OnHttpResultListener listener,
                                   int page) {
        String path = Constants.MESSAGE + page + ".xml";
        sendDataRequest(listener, q, path);
    }

    /**
     * 博客列表
     *
     * @param q
     * @param listener
     * @param page
     */
    public static void getBlogList(RequestQueue q,
                                   final OnHttpResultListener listener,
                                   int page) {
        String path = Constants.BLOGS + page + ".xml";
        sendDataRequest(listener, q, path);
    }

    /**
     * 热点列表
     *
     * @param q
     * @param listener
     * @param page
     */
    public static void getHotspotList(RequestQueue q,
                                      final OnHttpResultListener listener,
                                      int page) {
        String path = Constants.HOTSPOT + page + ".xml";
        sendDataRequest(listener, q, path);
    }


    /**
     * 推荐列表
     *
     * @param q
     * @param listener
     * @param page
     */
    public static void getRecommendList(RequestQueue q,
                                        final OnHttpResultListener listener,
                                        int page) {
        String path = Constants.RECOMMEND + page + ".xml";
        sendDataRequest(listener, q, path);
    }
    /**
     * 最新动弹
     * @param q
     * @param listener
     * @param page
     */
    public static void getNewsTweetList(RequestQueue q,
                                   final OnHttpResultListener listener,
                                   int page) {
        String path = Constants.NEWTWEET_URL + page + ".xml";
        sendDataRequest(listener, q, path);
    }
    /**
     * 热门动弹
     * @param q
     * @param listener
     * @param page
     */
    public static void getHotTweetList(RequestQueue q,
                                   final OnHttpResultListener listener,
                                   int page) {
        String path = Constants.HOTTWEET_URL + page + ".xml";
        sendDataRequest(listener, q, path);
    }
    /**
     * 朋友圈
     * @param q
     * @param listener
     * @param page
     */
    public static void getFriend(RequestQueue q,
                                   final OnHttpResultListener listener,
                                   int page) {
        String path = Constants.Friends_DETAIL + page + ".xml";
        sendDataRequest(listener, q, path);
    }
    /**
     * 我的动弹
     * @param q
     * @param listener
     * @param page
     */
    public static void getMyTweetList(RequestQueue q,
                                   final OnHttpResultListener listener,
                                   int page) {
        String path = Constants.MYTWEET_URL + page + ".xml";
        sendDataRequest(listener, q, path);
    }

    /**
     * 我-->收藏-->软件
     *
     * @param q
     * @param listener
     * @param page     http://188.188.4.41:8080/oschina/list/favorite_list1/page0.xml
     */
    public static void getFavorite(RequestQueue q,
                                   final OnHttpResultListener listener,
                                   int page) {
        String path = Constants.IP + "oschina/list/favorite_list1/page" + page + ".xml";
        sendDataRequest(listener, q, path);
    }

    /**
     * 我-->收藏-->软件
     *
     * @param q
     * @param listener http://188.188.4.41:8080/oschina/list/favorite_list2/page0.xml
     */
    public static void getTopic(RequestQueue q,
                                final OnHttpResultListener listener, int index) {
        String path = Constants.IP + "oschina/list/favorite_list" + index + "/page0.xml";
        sendDataRequest(listener, q, path);
    }
   /**
     * 我-->关注/粉丝
     * @param q
     * @param listener
    * 关注
     * //http://188.188.4.41:8080/oschina/list/friends_list1/page0.xml
    * 粉丝
    * //http://188.188.4.41:8080/oschina/list/friends_list0/page0.xml
     */
    public static void getFriends(RequestQueue q,
                                   final OnHttpResultListener listener,int index) {
        String path = Constants.IP +"oschina/list/friends_list"+index+"/page0.xml";
        sendDataRequest(listener, q, path);
    }


    /*-------------------------消息界面的请求封装(start)----------------------------------*/

    /**
     * 我-->消息-->@我/评论
     *
     * @param q
     * @param listener http://188.188.4.41:8080/oschina/list/active_list2/page0.xml
     *                 http://192.168.1.100:8080/oschina/list/active_list3/page0.xml
     */
    public static void getMessageCenterDataRemind(RequestQueue q,
                                                  final OnHttpResultListener listener, int index) {
        String path = Constants.IP + "oschina/list/active_list" + index + "/page0.xml";
        sendDataRequest(listener, q, path);
    }


    /**
     * 我-->消息-->留言
     *
     * @param q
     * @param listener http://188.188.4.100:8080/oschina/list/message_list/page0.xml
     */
    public static void getMessageCenterDataMessage(RequestQueue q, final OnHttpResultListener listener) {
        String path = Constants.IP + "oschina/list/message_list/page0.xml";
        sendDataRequest(listener, q, path);
    }

    /**
     * 我-->消息-->粉丝
     *
     * @param q
     * @param listener http://188.188.4.100:8080/oschina/list/friends_list0/page0.xml
     */
    public static void getMessageCenterDataFans(RequestQueue q,
                                                final OnHttpResultListener listener, int index) {
        String path = Constants.IP + "oschina/list/friends_list" + index + "/page0.xml";
        sendDataRequest(listener, q, path);
    }

    /**
     * 我-->消息-->赞过我的
     *
     * @param q
     * @param listener http://188.188.4.100:8080/oschina/list/my_tweet_like_list/page.xml
     */
    public static void getMessageCenterDataMyPraise(RequestQueue q,
                                                    final OnHttpResultListener listener) {
        String path = Constants.IP + "oschina/list/my_tweet_like_list/page.xml";
        sendDataRequest(listener, q, path);
    }
    /*-------------------------消息界面的请求封装(end)----------------------------------*/



    /*-------------------------活动界面的请求封装(end)----------------------------------*/
    /**
     * 发现--->活动--->近期活动
     *
     * @param q
     * @param listener http://188.188.4.41:8080/oschina/list/event_list/page0.xml
     */
    public static void getRecEventList(RequestQueue q,
                                       final OnHttpResultListener listener,
                                       int page) {
        String path =Constants.IP + Constants.EVENT_LIST + page+".xml";
        sendDataRequest(listener, q, path);
    }


    /**
     * 发现--->活动--->我的活动
     *
     * @param q
     * @param listener http://188.188.4.41:8080/oschina/list/my_event_list/page0.xml
     */
    public static void getMyEventList(RequestQueue q,
                                      final OnHttpResultListener listener,
                                      int page) {
        String path = Constants.IP + Constants.MYEVENT_LIST + page +".xml";
        sendDataRequest(listener, q, path);
    }


    /*-------------------------活动界面的请求封装(end)----------------------------------*/


    private static void sendDataRequest(final OnHttpResultListener listener,
                                        RequestQueue queue, String path) {

        // 清除缓存
        //        queue.getCache().clear();
        Log.d("TAG", "开始请求数据");
        if (queue.getCache().get(path) != null) {
            //response exists , 缓存存在, 直接获取数据
            String cachedResponse = new String(queue.getCache().get(path).data);
            Log.d("TAG", "读取缓存: " + cachedResponse.length() + cachedResponse);

            // 请求成功回调
            listener.onSuccess(cachedResponse);

        } else {
            //no response 没有缓存, 直接请求新的数据
            queue.add(new MyStringRequest(Request.Method.GET, path,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String s) {
                            // 数据请求成功
                            Log.d("TAG", "onResponse 获取到数据: " + s.length() + s);

                            // 请求成功回调
                            listener.onSuccess(s);

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError volleyError) {
                    listener.onError(volleyError);
                    Log.d("TAG", "onErrorResponse ");
                }
            }
            ));
        }
    }


    public interface OnHttpResultListener {

        void onSuccess(String data);

        void onError(Throwable e);
    }
}
