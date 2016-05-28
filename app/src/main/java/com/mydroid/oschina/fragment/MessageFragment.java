package com.mydroid.oschina.fragment;

import com.mydroid.oschina.adapter.ViewPagerFragmentAdapter;

/**
 * 创建者      Created by Edwin
 * 创建时间    2016/05/13
 * 描述        我的界面-->消息界面的消息中心的创建
 * <p/>
 * 更新者      Edwin
 * 更新时间    ${TODO}
 * 更新描述    ${TODO}
 */
public class MessageFragment extends BaseViewPagerFragment {


    @Override
    public void onSetupAdapter(ViewPagerFragmentAdapter adapter) {

        //创建对应的界面
        adapter.addTab("@我", MessageRemindFragment.class, getBundle(""));
        adapter.addTab("评论", MessageCommentFragment.class, getBundle(""));
        adapter.addTab("留言", MessageWordFragment.class, getBundle(""));
        adapter.addTab("粉丝", MessageFansFragment.class, getBundle(""));
        adapter.addTab("赞过我的", MessageMyPraiseFragment.class, getBundle(""));
    }
}
