package com.mydroid.oschina.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.astuetz.PagerSlidingTabStripExtends;
import com.mydroid.oschina.R;
import com.mydroid.oschina.adapter.ViewPagerFragmentAdapter;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * 滑动界面
 */
public abstract class BaseViewPagerFragment extends Fragment {




    @InjectView(R.id.tabStrip)
    PagerSlidingTabStripExtends tabStrip;
    @InjectView(R.id.pager)
    ViewPager                   pager;

    private ViewPagerFragmentAdapter mTabAdapter;

    public BaseViewPagerFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // 返回布局
        return inflater.inflate(R.layout.fragment_view_pager, container, false);
    }

    /**
     * 在onCreateView之后执行
     * @param view 布局的根节点
     * @param savedInstanceState
     */
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ButterKnife.inject(this, view);

        // 1. 设置数据适配器, 在Fragment里添加Fragment, 用getChildFragmentManager()
        mTabAdapter = new ViewPagerFragmentAdapter(getChildFragmentManager(), tabStrip, pager);

        onSetupAdapter(mTabAdapter);
    }

    /**
     * 让子类重写此方法, 设置真正的内容
     * @param adapter
     */

    public abstract void onSetupAdapter(ViewPagerFragmentAdapter adapter);

    @NonNull
    public Bundle getBundle(String arg) {
        Bundle bundle = new Bundle();
        bundle.putString("key", arg);
        return bundle;
    }


}
