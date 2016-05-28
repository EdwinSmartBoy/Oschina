package com.mydroid.oschina.base;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.mydroid.oschina.R;
import com.mydroid.oschina.util.ApiService;
import com.mydroid.oschina.util.UIUtils;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * 创建者     林伯任
 * 创建时间   2016/5/14 15:55
 * 描述	      ${TODO}
 * <p/>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public abstract class BaseListFragment extends Fragment implements
        SwipeRefreshLayout.OnRefreshListener,
        AdapterView.OnItemClickListener, AbsListView.OnScrollListener, AdapterView.OnItemLongClickListener {
    //定义四种状态
    public static final int STATE_lOADING = 0;
    public static final int STATE_EMPTY = 1;
    public static final int STATE_ERROR = 2;
    public static final int STATE_SUCCESS = 3;
    public final int mCurrentState = STATE_lOADING;


    @InjectView(R.id.refreshLayout)
    SwipeRefreshLayout refreshLayout;
    @InjectView(R.id.lv)
    ListView lv;

    public BaseAdapter baseListAdapter;
    public RequestQueue queue;
    private TextView mTv;

    public BaseListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        queue = Volley.newRequestQueue(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_list, container, false);


        // return inflater.inflate(R.layout.pager_loading, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ButterKnife.inject(this, view);
        // 初始化控件
        //给listView添加尾巴
        mTv = new TextView(UIUtils.getContext());
        mTv.setPadding(8, 12, 8, 12);
        mTv.setText("加载更多");
        mTv.setGravity(Gravity.CENTER);
        mTv.setTextColor(Color.BLACK);
        lv.addFooterView(mTv);

        //        - 初始化下拉刷新, 设置刷新监听
        refreshLayout.setRefreshing(false);
        refreshLayout.setColorSchemeColors(Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW);
        refreshLayout.setOnRefreshListener(this);

        //        - ListView设置条目点击事件\滚动监听
        lv.setOnItemClickListener(this);
        lv.setOnScrollListener(this);

        if (baseListAdapter != null) {
            lv.setAdapter(baseListAdapter);
        } else {
            // 创建数据适配器(特殊)
            baseListAdapter = getListAdapter();
            // 设置数据适配器
            lv.setAdapter(baseListAdapter);
            // 异步请求网络数据
            requestData();
        }


    }

    /**
     * a.创建数据适配器
     *
     * @return
     */

    @NonNull
    protected abstract BaseAdapter getListAdapter();

    /**
     * b.请求网络数据
     */
    protected abstract void requestData();

    /**
     * c. 解析得到的数据
     *
     * @param data 原数据
     * @return 转换后的对象
     */
    protected abstract Object parseData(String data);

    /**
     * d. 将解析后的数据展示到界面上
     */
    protected abstract void updateUI(Object obj);

    public ApiService.OnHttpResultListener listener = new ApiService.OnHttpResultListener() {

        @Override
        public void onSuccess(String data) {
            // 解析得到的网络数据
            Object obj = parseData(data);
            // 数据缓存


            // 更新界面
            updateUI(obj);
        }

        @Override
        public void onError(Throwable e) {
            // 请求失败, 打印结果
            //            Log.e("TAG", e.getMessage());
        }

    };


    Handler mhandler = new Handler();

    /**
     * 一旦用户下拉, 此方法被调用
     */
    @Override
    public void onRefresh() {
        //异步请求数据
        requestData();
        Toast.makeText(UIUtils.getContext(), "刷新成功", Toast.LENGTH_SHORT).show();
        //隐藏刷新头
        refreshLayout.setRefreshing(false);
        // 模拟请求网络数据
        /*mhandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                refreshLayout.setRefreshing(false);
            }
        }, 2000);
*/
    }

    /**
     * listView的点击事件, 让子类去选择实现
     *
     * @param parent
     * @param view
     * @param position
     * @param id
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    }

    /**
     * listView的滚动监听.
     * 让子类去做事情
     *
     * @param view
     * @param scrollState
     */
    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {


    }

    //子类主要复写这个方法就好了
    //滑到最后一条的时候  就去加载更多的数据.
    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        return false;
    }

}
