package com.mydroid.oschina.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.mydroid.oschina.R;

import static android.view.View.OnClickListener;
import static android.view.View.inflate;

/**
 * 创建者     九天玄尘
 * 创建时间   2016/5/17 0:08
 * 描述	      ${TODO}
 * <p/>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public class ShakeFragment extends Fragment {

    private ImageView mIvShake;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflate(getActivity(), R.layout.fragment_shake,null);
        mIvShake = (ImageView) rootView.findViewById(R.id.iv_find_shake);
        return rootView;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mIvShake.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "哈哈,摇你妹", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
