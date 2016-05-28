package com.mydroid.oschina.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.mydroid.oschina.R;
import com.mydroid.oschina.adapter.MenuAdapter;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * 创建者     林伯任
 * 创建时间   2016/5/17 18:42
 * 描述	      ${TODO}
 * <p/>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public class LeftNemuFragment extends Fragment {
    @InjectView(R.id.left_menu_setting)
    LinearLayout mLeftMenuSetting;
    @InjectView(R.id.left_menu_exit)
    LinearLayout mLeftMenuExit;
    @InjectView(R.id.left_menu_lv)
    ListView mLeftMenuLv;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_left, null);
        ButterKnife.inject(this, view);
        initView();
        initData();
        return view;
    }

    /**
     * 模拟数据
     */
    private void initData() {

    }

    /**
     * 初始化布局
     */
    private void initView() {
        MenuAdapter adapter = new MenuAdapter();
        mLeftMenuLv.setAdapter(adapter);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
