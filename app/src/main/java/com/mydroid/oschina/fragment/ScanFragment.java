package com.mydroid.oschina.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.mydroid.oschina.R;

/**
 * 创建者     九天玄尘
 * 创建时间   2016/5/17 0:08
 * 描述	      ${TODO}
 * <p/>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public class ScanFragment extends Fragment {

    private ImageView mIvScanFrame;
    private ImageView mIvScanLine;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View rootView = View.inflate(getActivity(), R.layout.fragment_scan, null);
        mIvScanFrame = (ImageView) rootView.findViewById(R.id.iv_scan_frame);
        mIvScanLine = (ImageView) rootView.findViewById(R.id.iv_scan_line);

        initListener();
        return rootView;

    }

    private void initListener() {
        TranslateAnimation translate = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_PARENT, -0.5f,
                Animation.RELATIVE_TO_PARENT, 0.5f);
        translate.setDuration(2000);
        translate.setRepeatCount(Animation.INFINITE);
        translate.setRepeatMode(Animation.REVERSE);
        mIvScanLine.startAnimation(translate);
    }
}
