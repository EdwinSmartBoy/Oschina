package com.mydroid.oschina.adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mydroid.oschina.R;
import com.mydroid.oschina.bean.Tweet;
import com.mydroid.oschina.util.ImageUtils;
import com.mydroid.oschina.util.InputHelper;
import com.mydroid.oschina.util.PlatfromUtil;
import com.mydroid.oschina.util.StringUtils;
import com.mydroid.oschina.util.TypefaceUtils;
import com.mydroid.oschina.util.UIUtils;
import com.mydroid.oschina.widget.AvatarView;
import com.squareup.picasso.Picasso;

import org.kymjs.kjframe.utils.DensityUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 创建者     叶庆荣
 * 创建时间   2016/5/15 21:05
 * 描述	      TweetsHotMessageAdapter
 * <p/>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public class TweetsHotMessageAdapter extends BaseAdapter {
    private Bitmap recordBitmap;
    private List<Tweet> mTweetslist = new ArrayList<>();

    /**
     * 设置数据内容
     *
     * @param list
     */
    public void updateData(List<Tweet> list) {
        mTweetslist.clear();
        mTweetslist.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        if (mTweetslist != null)
            return mTweetslist.size();
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;
        if (convertView == null) {
            convertView = View.inflate(UIUtils.getContext(), R.layout.list_item_tweets, null);
            ButterKnife.inject(this, convertView);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Tweet tweet = mTweetslist.get(position);
        /*holder.face.setUserInfo(tweet.getAuthorid(), tweet.getAuthor());
        holder.face.setAvatarUrl(tweet.getPortrait());*/
        if (!tweet.getPortrait().isEmpty())
        Picasso.with(UIUtils.getContext()).load(tweet.getPortrait()).into(holder.face);
        holder.author.setText(tweet.getAuthor());
        holder.time.setText(StringUtils.friendly_time(tweet.getPubDate()));
        //设置内容
        Spanned span = Html.fromHtml(tweet.getBody().trim());
        if (!StringUtils.isEmpty(tweet.getAttach())) {
            if (recordBitmap == null) {
                initRecordImg();
            }
            ImageSpan recordImg = new ImageSpan(UIUtils.getContext(), recordBitmap);
            SpannableString str = new SpannableString("c");
            str.setSpan(recordImg, 0, 1, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
            holder.content.setText(str);
            span = InputHelper.displayEmoji(UIUtils.getContext().getResources(), span);
            holder.content.append(span);
        } else {
            span = InputHelper.displayEmoji(UIUtils.getContext().getResources(), span);
            holder.content.setText(span);
        }

        holder.commentcount.setText(tweet.getCommentCount());

        showTweetImage(holder, tweet.getImgSmall(), tweet.getImgBig());
        tweet.setLikeUsers(UIUtils.getContext(), holder.likeUsers, true);

        if (tweet.getLikeUser() == null) {
            holder.tvLikeState.setVisibility(View.GONE);
        } else {
            holder.tvLikeState.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /*if (AppContext.getInstance().isLogin()) {
                        updateLikeState(finalHolder, tweet);
                    } else {
                        AppContext.showToast("先登陆再赞~");
                        UIHelper.showLoginActivity(UIUtils.getContext());
                    }*/
                    Toast.makeText(UIUtils.getContext(), "已赞", Toast.LENGTH_SHORT).show();
                }
            });
        }

        TypefaceUtils.setTypeface(holder.tvLikeState);
        if (tweet.getIsLike() == 1) {
            holder.tvLikeState.setTextColor(UIUtils.getResources().getColor(R.color
                    .day_colorPrimary));
        } else {
            holder.tvLikeState.setTextColor(UIUtils.getResources().getColor(R.color
                    .gray));
        }
        PlatfromUtil.setPlatFromString(holder.platform, tweet.getAppclient());

        return convertView;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    class ViewHolder {
        @InjectView(R.id.iv_icon)
        CircleImageView face;
        @InjectView(R.id.tv_tweet_name)
        TextView author;
        @InjectView(R.id.tweet_item)
        TextView content;
        @InjectView(R.id.iv_tweet_image)
        ImageView image;
        @InjectView(R.id.tv_likeusers)
        TextView likeUsers;
        @InjectView(R.id.tv_tweet_time)
        TextView time;
        @InjectView(R.id.tv_tweet_platform)
        TextView platform;
        @InjectView(R.id.tv_del)
        TextView del;
        @InjectView(R.id.tv_like_state)
        TextView tvLikeState;
        @InjectView(R.id.tv_tweet_comment_count)
        TextView commentcount;

        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
    private void initRecordImg() {
        recordBitmap = BitmapFactory.decodeResource(UIUtils.getContext().getResources(),
                R.drawable.audio3);
        recordBitmap = ImageUtils.zoomBitmap(recordBitmap,
                DensityUtils.dip2px(UIUtils.getContext(), 20f), DensityUtils.dip2px(UIUtils.getContext(), 20f));
    }
    /**
     * 动态设置动弹列表图片显示规则
     */
    private void showTweetImage(final ViewHolder vh, String imgSmall, final String imgBig) {
        if (!TextUtils.isEmpty(imgBig)) {
            vh.image.setTag(imgBig);
            /*new Core.Builder().view(vh.image).size(300, 300).url(imgBig + "?300X300")
                    .loadBitmapRes(R.drawable.pic_bg).doTask();*/
            vh.image.setVisibility(AvatarView.VISIBLE);
        } else {
            vh.image.setVisibility(AvatarView.GONE);
        }
    }
}

