package com.mydroid.oschina.dialog;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.mydroid.oschina.R;
import com.mydroid.oschina.util.UIUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

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
public class CodeDialog extends BaseDialog {
    @InjectView(R.id.ly_code)
    LinearLayout mLyCode;
    @InjectView(R.id.iv_code)
    ImageView mIvCode;

    public CodeDialog(Context context) {
        super(context);
    }


    //设置对话框位置
    @Override
    protected int setLocation() {
        return Gravity.CENTER;
    }

    //获取对话框的宽度
    @Override
    public int getWidth() {

        return UIUtils.dip2px(250);
    }

    //获取对话框的高度
    @Override
    public int getHeight() {
        return UIUtils.dip2px(300);
    }

    /**
     * 这个方法用来传入自定义的布局
     *
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {

        //指定当前的对话框显示什么内容
        setContentView(R.layout.iv_code);
        ButterKnife.inject(this);

        mLyCode.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {


                //判断sd卡的挂载状态
             /*  if (!Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState()){
                   Toast.makeText(getContext(), "你的sd卡没有正确加载", Toast.LENGTH_SHORT).show();
               } else{*/

                    Bitmap bitmap = BitmapFactory.decodeResource(UIUtils.getResources(), R.drawable.myqrcode);
                    File f = new File(Environment.getExternalStorageDirectory(), "xxx.png");
                    FileOutputStream out = null;
                    try {
                        out = new FileOutputStream(f);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }

                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);

                Toast toast = Toast.makeText(getContext(), "二维码已保存到oschina文件夹下", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.BOTTOM, 0, 0);
                toast.show();


                dismiss();
                return true;
            }
        });


    }


}
