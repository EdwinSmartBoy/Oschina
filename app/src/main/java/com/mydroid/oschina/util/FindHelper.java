package com.mydroid.oschina.util;

import android.content.Context;
import android.content.Intent;

import com.mydroid.oschina.bean.FindBackPage;
import com.mydroid.oschina.ui.FindBackActivity;

/**
 * 创建者     九天玄尘
 * 创建时间   2016/5/17 1:18
 * 描述	      ${TODO}
 * <p/>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public class FindHelper {

    public static void showFindleBack(Context context, FindBackPage page) {
        Intent intent = new Intent(context, FindBackActivity.class);
        intent.putExtra(FindBackActivity.BUNDLE_KEY_PAGE, page.getValue());
        context.startActivity(intent);
    }
}
