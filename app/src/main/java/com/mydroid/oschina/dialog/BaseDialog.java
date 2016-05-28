package com.mydroid.oschina.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.WindowManager;

import com.mydroid.oschina.R;

/**
 * 创建者     CAI
 * 创建时间   2016/5/14 18:21
 * 描述	      ${TODO}
 * <p/>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public abstract class BaseDialog extends Dialog{

    public BaseDialog(Context context) {
       //super(context);
        //指定当前的对话框,使用我们自己的样式
       this(context,R.style.MyDialogStyle);

        //获取对话框沉底显示
        getWindow().setGravity(setLocation());

        WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
        //获取高度
        localLayoutParams.height = getHeight();
        //获取宽度
        localLayoutParams.width = getWidth();
        getWindow().setAttributes(localLayoutParams);
    }

    //设置对话框位置
    protected abstract int setLocation();
    //获取对话框的宽度
    public abstract int getWidth();

    //获取对话框的高度
    public abstract int getHeight() ;

    public BaseDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    public BaseDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    /**
     * 这个方法用来传入自定义的布局
     * @param savedInstanceState
     */
    @Override
    public abstract void onCreate(Bundle savedInstanceState);
}
