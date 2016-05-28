package com.mydroid.oschina.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.Toast;

import com.mydroid.oschina.R;

/**
 * 创建者     九天玄尘
 * 创建时间   2016/5/13 15:26
 * 描述	      ${TODO}
 * <p/>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public class FindUserActivity extends Activity {

    private ImageButton mSearchDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.find_activity_finduser);
        initView();
        initData();
        initListener();
    }

    public void initView() {

        mSearchDelete = (ImageButton) findViewById(R.id.find_finduser_delete);

    }

    public void initData() {

    }

    public  void initListener() {
        mSearchDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(FindUserActivity.this, "哈哈", Toast.LENGTH_SHORT).show();

            }
        });
    }

}
