package com.mydroid.oschina.base;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;

import com.mydroid.oschina.R;
import com.mydroid.oschina.util.TLog;
import com.mydroid.oschina.util.UIUtils;

/**
 * 创建者     叶庆荣
 * 创建时间   2016/5/12 12:21
 * 描述	      LoadingPager--四种页面的加载状态--加载中,成功,空,失败
 * <p/>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}$
 */
public abstract class LoadingPager extends FrameLayout {

    public static final int STATE_LOADING = 0;
    public static final int STATE_SUCCESS = 1;
    public static final int STATE_EMPTY = 2;
    public static final int STATE_ERROR = 3;

    public int mCurState = STATE_LOADING;

    private View mLoadingView;
    private View mEmptyView;
    private View mErrorView;
    private View mSuccessView;
    private LoadDataTask mLoadDataTask;

    public LoadingPager(Context context) {
        super(context);
        //初始化3种静态视图
        initCommonView();
    }

    /**
     * @des 初始化3种静态视图
     * @called LoadingPager创建的时候
     */
    private void initCommonView() {
        //加载中视图
        mLoadingView = View.inflate(UIUtils.getContext(), R.layout.pager_loading, null);
        this.addView(mLoadingView);

        //空视图
        mEmptyView = View.inflate(UIUtils.getContext(), R.layout.pager_empty, null);
        this.addView(mEmptyView);

        //错误视图
        mErrorView = View.inflate(UIUtils.getContext(), R.layout.pager_network, null);
        this.addView(mErrorView);

        //点击重试
        mErrorView.findViewById(R.id.error_btn_retry).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //重新触发加载数据
                triggerLoadData();
            }
        });

        //根据默认情况,展示默认视图
        updateViewByState();
    }

    /**
     * @des 根据最新的状态, 刷新对应的视图(决定到底提供什么视图类型)
     * @called 1.LoadingPager创建的时候
     * @called 2.外界触发加载了数据, 开始异步加载钱
     * @called 3.外界触发加载了数据, 数据加载完成了
     */
    private void updateViewByState() {
        //控制 加载中视图 的显示隐藏
        if (mCurState == STATE_LOADING) {
            mLoadingView.setVisibility(View.VISIBLE);
        } else {
            mLoadingView.setVisibility(View.GONE);
        }
//        mLoadingView.setVisibility((mCurState == STATE_LOADING)?View.VISIBLE: View.GONE);

        //控制 空视图 的显示隐藏
        if (mCurState == STATE_EMPTY) {
            mEmptyView.setVisibility(View.VISIBLE);
        } else {
            mEmptyView.setVisibility(View.GONE);
        }

        //控制 错误视图 的显示隐藏
        if (mCurState == STATE_ERROR) {
            mErrorView.setVisibility(View.VISIBLE);
        } else {
            mErrorView.setVisibility(View.GONE);
        }

        //成功视图还没有创建,但是应该显示成功视图
        if (mSuccessView == null && mCurState == STATE_SUCCESS) {
            mSuccessView = initSuccessView();

            this.addView(mSuccessView);
        }

        //控制成功视图的显示隐藏
        if (mSuccessView != null) {
            if (mCurState == STATE_SUCCESS) {
                mSuccessView.setVisibility(View.VISIBLE);
            } else {
                mSuccessView.setVisibility(View.GONE);
            }
        }
    }


    /**
     * @des 触发加载数据
     * @called 外界需要加载数据的时候调用
     */
    public void triggerLoadData() {

        if (mCurState != STATE_SUCCESS && mLoadDataTask == null) {
            TLog.log("###触发加载数据triggerLoadData");
            //初始化状态/重置状态为loading
            mCurState = STATE_LOADING;
            updateViewByState();

            mLoadDataTask = new LoadDataTask();
            new Thread(mLoadDataTask).start();
        }

    }

    /*
        分析页面的数据加载情况
         数据加载基本流程?
            1.触发加载             =====>加载中的视图
                进入页面开始加载数据
                下拉加载数据
                点击重试
            2.异步加载-->得到数据   =====>加载中的视图
            3.处理数据-->得到自己最终想要的数据
            4.刷新ui
                请求失败  ===>错误视图
                请求成功,但是想要的数据为空  ===>空视图
                请求成功,得到了想要的数据    ===>成功视图

         */
    class LoadDataTask implements Runnable {
        @Override
        public void run() {
            //真正的在子线程中加载具体的数据
            LoadedResult loadedResult = initData();
            //处理数据
            mCurState = loadedResult.getState();
            //刷新ui-->updateViewByState
            MyApplication.getMainHandler().post(new Runnable() {
                @Override
                public void run() {
                    updateViewByState();
                }
            });
            //任务执行完成,置空任务
            mLoadDataTask = null;
        }
    }

    /**
     * @return
     * @des 真正的在子线程中加载具体的数据
     * @des 在LoadingPager中不知道如何在子线程中真正的加载数据
     * @des 必须实现, 但是不知道具体实现, 定义成为抽象方法, 交给子类实现
     * @called 外界调用了triggerLoadData()
     */
    public abstract LoadedResult initData();

    /**
     * @return
     * @des 初始化成功视图-->决定视图长什么样子
     * @des 绑定具体的数据-->因为这个视图最终是展示给用户看的
     * @des 在LoadingPager中不知道决定视图长什么样子, 以及决定数据和视图如何绑定
     * @called 外界触发加载了数据, 而且数据加载完成了, 而且数据加载成功了
     * @des 必须实现, 但是不知道具体实现, 定义成为抽象方法, 交给子类实现
     */
    public abstract View initSuccessView();


    public enum LoadedResult {

        SUCCESS(STATE_SUCCESS), ERROR(STATE_ERROR), EMPTY(STATE_EMPTY);

        private int state;

        public int getState() {
            return state;
        }

        LoadedResult(int state) {
            this.state = state;
        }
    }
}
