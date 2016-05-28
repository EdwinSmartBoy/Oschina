package com.mydroid.oschina.holder;

import com.mydroid.oschina.bean.Blog;

/**
 * @创建时间 Administrator on 2016/5/14 0014.
 */
public class BlogHolder extends MyHolder<Blog> {


    public void setDataAndRefreshHolderView(Blog data) {
        mData = data;

        refleshHolderView(mData);
    }


    public void refleshHolderView(Blog mData) {

        mTvTitle.setText(mData.getTitle());
        mTvContent.setText(mData.getBody());
        mTvUserName.setText(mData.getAuthor());
        mTvTime.setText(mData.getPubDate().split(" ")[0]);
        mTvCompNum.setText(mData.getCommentCount()+"");

    }


}
