package com.mydroid.oschina.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mydroid.oschina.util.UIUtils;

/**
 * 创建者     林伯任
 * 创建时间   2016/5/11 20:32
 * 描述	      ${TODO}
 * <p/>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public abstract class BaseFragment extends Fragment {


    public LoadingPager mLoadignPager;
    public FragmentActivity mActivity;


    /**
     * 加载控件
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mLoadignPager == null) {
            //加载LodingPager
            mLoadignPager = new LoadingPager(UIUtils.getContext()) {
                @Override
                public LoadingPager.LoadedResult initData() {
                    return BaseFragment.this.initData();
                }

                @Override
                public View initSuccessView() {
                    return BaseFragment.this.initSuccessView();
                }
            };
        }


        //触发加载数据triggerLoadData
        mLoadignPager.triggerLoadData();
        return mLoadignPager;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    //加载具体的数据
    public abstract LoadingPager.LoadedResult initData();

    //加载成功后的视图---显示数据
    protected abstract View initSuccessView();
}
