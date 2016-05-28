package com.mydroid.oschina.bean;


import com.mydroid.oschina.util.LogUtils;

/**
 * 常量类
 *
 * @author FireAnt（http://my.oschina.net/LittleDY）
 * @version 创建时间：2014年10月27日 下午12:14:42
 */

public class Constants {

    public static final String INTENT_ACTION_USER_CHANGE = "net.oschina.action.USER_CHANGE";

    public static final String INTENT_ACTION_COMMENT_CHANGED = "net.oschina.action.COMMENT_CHANGED";

    public static final String INTENT_ACTION_NOTICE = "net.oschina.action.APPWIDGET_UPDATE";

    public static final String INTENT_ACTION_LOGOUT = "net.oschina.action.LOGOUT";

    public static final String WEICHAT_APPID = "wx41be5fe48092e94c";
    public static final String WEICHAT_SECRET = "0101b0595ffe2042c214420fac358abc";

    public static final String QQ_APPID = "100942993";
    public static final String QQ_APPKEY = "8edd3cc7ca8dcc15082d6fe75969601b";


    public static final int DEBUGLEVEL = LogUtils.LEVEL_ALL;

    public static final long PROTOCOL_TIMEOUT = 10000; // 超时时长为10秒

    public static final String IP = "http://188.188.4.41:8080/"; //默认IP地址

    public static final String BASE_URL = IP + "oschina/"; //默认的url地址

    /*public static final String LIST_BASE_URL = BASE_URL + "list"; //url中含有list的base_url

    public static final String DETAIL_BASE_URL = BASE_URL + "detail"; //url中含有detail的base_url*/

    public static final String HOTTWEET_URL = BASE_URL + "list/hottweet/page";//热门动弹页面
    //    http://192.168.1.100:8080/oschina/list/tweet_list/page0.xml
    public static final String NEWTWEET_URL = BASE_URL + "list/tweet_list/page";//最新动弹页面
    //http://192.168.1.100:8080/oschina/list/mytweet/page0.xml
    public static final String MYTWEET_URL = BASE_URL + "list/mytweet/page";//我的动弹页面

    public static final String MESSAGE = IP + "oschina/list/news/page"; //资讯
    public static final String HOTSPOT = IP + "oschina/list/hotspot/page"; //热点
    public static final String BLOGS = IP + "oschina/list/blog/page"; //博客
    public static final String RECOMMEND = IP + "oschina/list/recommend/page"; //推荐
    public static final String Friends_DETAIL = "http://188.188.4.41:8080/oschina/list/active_list1/page"; //朋友圈详情


    public static final String NEWS_DETAIL = "oschina/detail/news_detail/"; //新闻详情
    //    public static final String BLOG_DETAIL = "http://188.188.4.16:8080/oschina/detail/blog_detail/"; //博客详情

    public static final String BLOGS_DETAIL = "oschina/detail/blog_detail/"; //博客详情

    //                    http://192.168.1.100:8080/oschina/detail/blog_detail/470948.xml

    public static final String EVENT_LIST = "oschina/list/event_list/page"; //近期活动
    //    http://192.168.1.100:8080/oschina/list/event_list/page0.xml

    public static final String MYEVENT_LIST = "oschina/list/my_event_list/page"; //我的活动
    //    http://192.168.1.100:8080/oschina/list/my_event_list/page0.xml

    public static final String KEY_COLL_DETAIL = "coll_detail";
}
