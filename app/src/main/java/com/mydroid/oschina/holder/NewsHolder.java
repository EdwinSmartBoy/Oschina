package com.mydroid.oschina.holder;

import com.mydroid.oschina.bean.News;

/**
 * @创建时间 Administrator on 2016/5/15 0015.
 */
public class NewsHolder extends MyHolder<News> {


    public void setDataAndRefreshHolderView(News data) {
        mData = data;

        refleshHolderView(mData);
    }

    public void refleshHolderView(News mData) {

        mTvTitle.setText(mData.getTitle());
        mTvContent.setText(mData.getBody());
        mTvUserName.setText(mData.getAuthor());
        mTvTime.setText(mData.getPubDate().split(" ")[0]);
        mTvCompNum.setText(mData.getCommentCount()+"");
    }
}
