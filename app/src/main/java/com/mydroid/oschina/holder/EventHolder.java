package com.mydroid.oschina.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mydroid.oschina.R;
import com.mydroid.oschina.bean.Constants;
import com.mydroid.oschina.bean.Event;
import com.mydroid.oschina.util.UIUtils;
import com.squareup.picasso.Picasso;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * @创建时间 Administrator on 2016/5/17 0017.
 */
public class EventHolder {

    public View mHolderView;
    private Event mData;

    @InjectView(R.id.event_pic)
    ImageView mEventPic;
    @InjectView(R.id.event_title)
    TextView  mEventTitle;
    @InjectView(R.id.event_time)
    TextView  mEventTime;
    @InjectView(R.id.event_content)
    TextView  mEventContent;

    public EventHolder() {

        mHolderView = initHolderView();
        mHolderView.setTag(this);
    }

    private View initHolderView() {

        View rootView = View.inflate(UIUtils.getContext(), R.layout.item_event, null);

        ButterKnife.inject(this, rootView);

        return rootView;

    }



    public void setDataAndRefleshHolderView(Event data) {
        mData = data;
        refleshHolderView(mData);

    }


    /**
     * 数据和视图的绑定操作
     */
    public void refleshHolderView(Event mData) {

        mEventTitle.setText(mData.getTitle());
        mEventTime.setText(mData.getCreateTime());
        mEventContent.setText(mData.getSpot());

        String cover = mData.getCover();
        String s = cover.split("0/")[1];
        String url = Constants.IP + s;
        Picasso.with(UIUtils.getContext()).load(url).into(mEventPic);


    }


}
