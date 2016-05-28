package com.mydroid.oschina.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 创建者     陈长旋
 * 创建时间   2016/5/4 08:33
 * 描述	      Fragment的基类,常规的抽取
 * <p/>
 * 更新者     $Author: admin $
 * 更新时间   $Date: 2016-05-04 09:35:51 +0800 (星期三, 04 五月 2016) $
 * 更新描述   ${TODO}
 */
public abstract class BaseFragmentCommmon extends Fragment {
    /*
      抽取基类的好处?
      1.从java语言角度-->放置共有的方法,共有的属性-->少写代码
      2.不用在覆写oncreate ,onCreateView,onActivityCreate方法,只需要实现自己定义好的相关方法即可
      3.还可以在基类里面,决定哪些方法是必须实现的,哪些方法是选择性实现的
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        init();
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return initView();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        initData();
        initListener();
        super.onActivityCreated(savedInstanceState);
    }

    /**
     * # 初始化参数
     * # 在BaseFragment其实不知道具体方法体是什么, 所以交给子类
     */
    public void init() {

    }

    /**
     * @return
     * # 初始化所能提供的视图
     * # 在BaseFragment其实不知道具体方法体是什么, 所以交给子类
     * # 因为一个Fragment必须需要有视图可以展示, 所以子类是必须覆写
     */
    public abstract View initView();

    /**
     * # 初始化对应的数据
     * # 在BaseFragment其实不知道具体方法体是什么, 所以交给子类
     */
    public void initData() {

    }

    /**
     *  #初始化监听
     *  #在BaseFragment其实不知道具体方法体是什么, 所以交给子类
     */
    public void initListener() {

    }

}
