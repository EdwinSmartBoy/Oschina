package com.mydroid.oschina.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.mydroid.oschina.R;
import com.mydroid.oschina.util.UIUtils;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * 创建者     CAI
 * 创建时间   2016/5/14 18:21
 * 描述	     快速按钮的Dialog
 * <p/>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public class MyDialog extends BaseDialog {
    @InjectView(R.id.option_rb_text)
    RadioButton mOptionRbText;
    @InjectView(R.id.option_rb_picture)
    RadioButton mOptionRbPicture;
    @InjectView(R.id.option_rb_photo)
    RadioButton mOptionRbPhoto;
    @InjectView(R.id.option_rg)
    RadioGroup mOptionRg;

    public MyDialog(Context context) {
        super(context);
    }


    //设置对话框位置
    @Override
    protected int setLocation() {
        return Gravity.BOTTOM;
    }

    //获取对话框的宽度
    @Override
    public int getWidth() {
        Display localDisplay = getWindow().getWindowManager().getDefaultDisplay();

        return localDisplay.getWidth();
    }

    //获取对话框的高度
    @Override
    public int getHeight() {
        return UIUtils.dip2px(150);
    }

    /**
     * 这个方法用来传入自定义的布局
     *
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {

        //指定当前的对话框显示什么内容
        setContentView(R.layout.quick_option);
        ButterKnife.inject(this);

        ImageView iv_close = (ImageView) findViewById(R.id.iv_close);
        //设置快捷键的旋转动画
        Animation operatingAnimation = AnimationUtils.loadAnimation(getContext(),R.anim.quick_option_close);
        LinearInterpolator lin = new LinearInterpolator();
        operatingAnimation.setInterpolator(lin);
        iv_close.startAnimation(operatingAnimation);
        //设置弹出快捷窗口的点击事件
        iv_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.iv_close:
                        dismiss();
                        break;
                    case R.id.option_rb_text:

                        break;
                    case R.id.option_rb_picture:
                        break;
                    case R.id.option_rb_photo:
                        break;
                }
                dismiss();
            }
        });

    }


}
