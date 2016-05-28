package com.mydroid.oschina.fragment;

import android.support.annotation.NonNull;
import android.widget.BaseAdapter;

import com.mydroid.oschina.adapter.FriendsAdater;
import com.mydroid.oschina.base.BaseListFragment;
import com.mydroid.oschina.bean.Active;
import com.mydroid.oschina.bean.ActiveList;
import com.mydroid.oschina.util.ApiService;
import com.mydroid.oschina.util.XmlUtils;

import java.util.List;

/**
 * 创建者     九天玄尘
 * 创建时间   2016/5/17 0:08
 * 描述	      ${TODO}
 * <p/>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public class FriendsFragment extends BaseListFragment {

    private FriendsAdater mAdatar;
    private ActiveList mActiveList ;

    /**
     * 设置适配器
     * @return
     */
    @NonNull
    @Override
    protected BaseAdapter getListAdapter() {
        mAdatar = new FriendsAdater();
        return mAdatar;
    }

    /**
     * 请求网络数据
     */
    @Override
    protected void requestData() {
        ApiService.getFriend(queue, listener, 0);
    }

    /**
     * 解析数据
     * @param data 原数据
     * @return
     */
    @Override
    protected Object parseData(String data) {
        mActiveList = XmlUtils.toBean(ActiveList.class, data.getBytes());
        System.out.print(mActiveList.getActivelist().get(1));
        return mActiveList;
    }

    /**
     * 更新UI
     * @param obj
     */
    @Override
    protected void updateUI(Object obj) {
        ActiveList activeList = (ActiveList) obj;
        List<Active> list = activeList.getList();
        ((FriendsAdater)baseListAdapter).updateData(list);
    }
}
