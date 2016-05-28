package com.mydroid.oschina.holder;

import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mydroid.oschina.R;
import com.mydroid.oschina.bean.Active;
import com.mydroid.oschina.bean.Constants;
import com.mydroid.oschina.util.UIUtils;
import com.squareup.picasso.Picasso;

import butterknife.ButterKnife;
import butterknife.InjectView;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 创建者     九天玄尘
 * 创建时间   2016/5/17 16:34
 * 描述	      ${TODO}
 * <p/>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public class FriendsHolder {

    public View mHolderView;

    @InjectView(R.id.item_find_portrait)
    CircleImageView mItemFindPortrait;
    @InjectView(R.id.item_find_author)
    TextView mItemFindAuthor;
    @InjectView(R.id.item_find_date)
    TextView mItemFindDate;
    @InjectView(R.id.item_find_titletype)
    TextView mItemFindTitletype;
    @InjectView(R.id.item_find_title)
    TextView mItemFindTitle;
    @InjectView(R.id.item_find_desc)
    TextView mItemFindDesc;
    @InjectView(R.id.item_find_appclient)
    TextView mItemFindAppclient;
    @InjectView(R.id.iv_find_comment)
    ImageView mIvFindComment;
    @InjectView(R.id.tv_comment_count)
    TextView mTvCommentCount;


    public FriendsHolder() {
        mHolderView = initHolderView();
        mHolderView.setTag(this);

    }

    public View initHolderView() {
        View rootView = View.inflate(UIUtils.getContext(), R.layout.item_find_friends, null);

        ButterKnife.inject(this, rootView);

        return rootView;
    }



    public void setDataAndRefreshHolderView(Active friend) {

        mItemFindAuthor.setText(friend.getAuthor());
        mItemFindDate.setText(friend.getPubDate().split(" ")[0]);
//      mItemFindTitletype.setText(friend.getObjectType());
        mItemFindTitle.setText(friend.getObjectTitle());

        String html = friend.getMessage();
        Spanned spanned = Html.fromHtml(html);

        mItemFindDesc.setText(spanned);
//        mItemFindAppclient.setText(friend.getAppClient());
       // mIvFindComment.setImageResource(R.drawable.ic_comment_count);
//        mTvCommentCount.setText(friend.getCommentCount());

            /*--------------- 下面略坑 ---------------*/


        /**
         * 加载头像
         */
        String s = friend.getPortrait().split(":8080/")[1];
        String url = Constants.IP+s;
        Picasso.with(UIUtils.getContext()).load(url).into(mItemFindPortrait);
        /**
         * 发表了博客等行为
         */
        switch (friend.getObjectType() ) {
            case 100:
                mItemFindTitletype.setText("更新了动态");
                break;
            case 3:
                mItemFindTitletype.setText("发表了博客");
                break;
            case 5:
                mItemFindTitletype.setText("分享了一段代码");
                break;
            case 17:
                mItemFindTitletype.setText("回答了问题:");
                break;
            case 101:
                mItemFindTitletype.setText("回复了动态:");
                break;

            default:
                break;
        }

        /**
         * 来自什么平台   mItemFindAppclient.setText(friend.getAppClient());
         */
        switch (friend.getAppClient()) {
            case 3:
               mItemFindAppclient.setText("Android");
               mItemFindAppclient.setVisibility(View.VISIBLE);
                break;
            case 4:
               mItemFindAppclient.setText("iPhone");
               mItemFindAppclient.setVisibility(View.VISIBLE);
                break;
            case 0:
               mItemFindAppclient.setText("");
               mItemFindAppclient.setVisibility(View.INVISIBLE);
                break;

            default:
                break;
        }

        /**
         * 评论数       mTvCommentCount.setText(friend.getCommentCount());
         */
        if (friend.getCommentCount() == 0) {
            mTvCommentCount.setVisibility(View.GONE);
            mIvFindComment.setVisibility(View.GONE);
        }else {

            mTvCommentCount.setText(friend.getCommentCount()+"");
            mIvFindComment.setImageResource(R.drawable.ic_comment_count);
            mTvCommentCount.setVisibility(View.VISIBLE);
            mIvFindComment.setVisibility(View.VISIBLE);
        }
    }
}
