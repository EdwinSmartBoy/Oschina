package com.mydroid.oschina.fragment;


import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.mydroid.oschina.R;
import com.mydroid.oschina.base.BaseFragment;
import com.mydroid.oschina.base.LoadingPager;
import com.mydroid.oschina.bean.FindBackPage;
import com.mydroid.oschina.ui.FindUserActivity;
import com.mydroid.oschina.util.FindHelper;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * 创建者     九天玄尘
 * 创建时间   2016/5/12 18:39
 * 描述	      ${TODO}
 * <p/>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public class FindFragment extends BaseFragment implements View.OnClickListener {


    @InjectView(R.id.tv_find_friends)
    TextView mTvFindFriend;
    @InjectView(R.id.tv_find_finduser)
    TextView mTvFindFinduser;
    @InjectView(R.id.tv_find_event)
    TextView mTvFindEvent;
    @InjectView(R.id.tv_find_scan)
    TextView mTvFindScan;
    @InjectView(R.id.tv_find_shake)
    TextView mTvFindShake;



    @Override
    public LoadingPager.LoadedResult initData() {
        return LoadingPager.LoadedResult.SUCCESS;
    }

    @Override
    protected View initSuccessView() {
        View rootView = View.inflate(getContext(), R.layout.find_fragment, null);
        ButterKnife.inject(this, rootView);

        initListener();
        return rootView;
    }

    private void initListener() {
        mTvFindFriend.setOnClickListener(this);
        mTvFindFinduser.setOnClickListener(this);
        mTvFindEvent.setOnClickListener(this);
        mTvFindScan.setOnClickListener(this);
        mTvFindShake.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_find_friends:

                FindHelper.showFindleBack(getContext(), FindBackPage.FIND_FRIENDS);
                break;
            case R.id.tv_find_finduser:
                Intent intent = new Intent(getContext(), FindUserActivity.class);
                getContext().startActivity(intent);
                break;
            case R.id.tv_find_event:
                FindHelper.showFindleBack(getContext(), FindBackPage.FIND_EVENT);
                break;
            case R.id.tv_find_scan:
                FindHelper.showFindleBack(getContext(), FindBackPage.FIND_SCAN);
                Toast.makeText(getActivity(), "敬请期待", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_find_shake:
                FindHelper.showFindleBack(getContext(), FindBackPage.FIND_SHAKE);
                break;

            default:
                break;
        }
    }


}

