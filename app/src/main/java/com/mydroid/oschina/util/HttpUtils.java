package com.mydroid.oschina.util;

import java.util.Map;

/**
 * 创建者     伍碧林
 * 创建时间   2016/5/5 11:21
 * 描述	      ${TODO}
 * <p/>
 * 更新者     $Author: admin $
 * 更新时间   $Date: 2016-05-05 11:26:11 +0800 (星期四, 05 五月 2016) $
 * 更新描述   ${TODO}
 */
public class HttpUtils {
    /**
     * @param map 请求参数所对应的map
     * @return 拼接好的字符串
     */
    public static String getUrlParamsByMap(Map<String, Object> map) {
        if (map == null) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            sb.append(entry.getKey() + "=" + entry.getValue());
            sb.append("&");
        }
        String s = sb.toString();
        if (s.endsWith("&")) {
            s = s.substring(0, s.length() - 1);
        }
        return s;
    }
}
