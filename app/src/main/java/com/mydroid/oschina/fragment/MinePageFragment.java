package com.mydroid.oschina.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mydroid.oschina.R;
import com.mydroid.oschina.dialog.CodeDialog;
import com.mydroid.oschina.ui.BlogActivity;
import com.mydroid.oschina.ui.CollectedActivity;
import com.mydroid.oschina.ui.FollowFansActivity;
import com.mydroid.oschina.ui.MessageActivity;
import com.mydroid.oschina.ui.TeamActivity;
import com.mydroid.oschina.ui.UserDesActivity;
import com.mydroid.oschina.util.UIUtils;

import butterknife.ButterKnife;
import butterknife.InjectView;
import de.hdodenhof.circleimageview.CircleImageView;


/**
 * 创建者     CAI
 * 创建时间   2016/5/13 16:13
 * 描述	      "我"的页面
 * <p/>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */

public class MinePageFragment extends Fragment {


    @InjectView(R.id.iv_code)
    ImageView mIvCode;

    @InjectView(R.id.ly_button)
    LinearLayout mLyButton;
    @InjectView(R.id.line)
    View mLine;
    @InjectView(R.id.iv_face)
    CircleImageView mIvFace;
    @InjectView(R.id.user_name)
    TextView mUserName;
    @InjectView(R.id.iv_sex)
    ImageView mIvSex;
    @InjectView(R.id.userdes)
    RelativeLayout mUserdes;
    @InjectView(R.id.item_message)
    TextView mItemMessage;
    @InjectView(R.id.item_blog)
    TextView mItemBlog;
    @InjectView(R.id.item_note)
    TextView mItemNote;
    @InjectView(R.id.item_team)
    TextView mItemTeam;
    @InjectView(R.id.ly_code)
    LinearLayout mLyCode;
    private LinearLayout mJifen;
    private LinearLayout mShouchang;
    private LinearLayout mGuanzhu;
    private LinearLayout mFensi;
    private View mRootView;
    private TextView mTv_message;
    private TextView mTv_blog;
    private TextView mTv_note;
    private TextView mTv_team;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        mRootView = View.inflate(UIUtils.getContext(), R.layout.my_page, null);
        ButterKnife.inject(this, mRootView);
        return mRootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        //初始化控件
        initView();
        //点击事件
        initEvemt();


        super.onActivityCreated(savedInstanceState);
    }

    /**
     * 初始化控件
     */
    private void initView() {


        mJifen = (LinearLayout) mRootView.findViewById(R.id.jigen);


        mShouchang = (LinearLayout) mRootView.findViewById(R.id.shouchang);
        mGuanzhu = (LinearLayout) mRootView.findViewById(R.id.guanzhu);
        mFensi = (LinearLayout) mRootView.findViewById(R.id.fensi);
        //item
        mTv_message = (TextView) mRootView.findViewById(R.id.item_message);
        mTv_blog = (TextView) getActivity().findViewById(R.id.item_blog);
        mTv_note = (TextView) mRootView.findViewById(R.id.item_note);
        mTv_team = (TextView) mRootView.findViewById(R.id.item_team);


    }

    private void initEvemt() {
        //积分,收藏---的点击事件
        mJifen.setOnClickListener(MyOnclickListener);
        mShouchang.setOnClickListener(MyOnclickListener);
        mGuanzhu.setOnClickListener(MyOnclickListener);
        mFensi.setOnClickListener(MyOnclickListener);

        //item的点击事件

        mTv_message.setOnClickListener(MyOnclickListener);
        mTv_blog.setOnClickListener(MyOnclickListener);
        mTv_note.setOnClickListener(MyOnclickListener);
        mTv_team.setOnClickListener(MyOnclickListener);
        mIvCode.setOnClickListener(MyOnclickListener);
        mIvFace.setOnClickListener(MyOnclickListener);


    }

    /**
     * 点击事件监听
     */
    View.OnClickListener MyOnclickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.jigen:
                    Toast.makeText(UIUtils.getContext(), "此功能待开放", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.shouchang:
                    //跳转到收藏界面
                    startActivity(new Intent(UIUtils.getContext(), CollectedActivity.class));
                    break;
                case R.id.guanzhu:
                    //跳转到关注/粉丝
                    startActivity(new Intent(UIUtils.getContext(), FollowFansActivity.class));
                    break;
                case R.id.fensi:
                    //跳转到关注/粉丝
                    startActivity(new Intent(UIUtils.getContext(), FollowFansActivity.class));
                    break;
                case R.id.item_message:
                    //跳转到消息界面
                    Intent messageIntent = new Intent(getContext(), MessageActivity.class);
                    startActivity(messageIntent);
                    break;
                case R.id.item_blog:
                    //跳转到我的博客界面
                    startActivity(new Intent(getContext(), BlogActivity.class));
                    break;
                case R.id.item_note:
                    //便签界面
                    Toast.makeText(UIUtils.getContext(), "此功能待开放", Toast.LENGTH_SHORT).show();

                    break;
                case R.id.item_team:
                    //跳转到团队界面
                    startActivity(new Intent(getContext(), TeamActivity.class));

                    break;
                case R.id.iv_code:
                    CodeDialog dialog = new CodeDialog(getContext());
                    dialog.show();
                    break;
                case R.id.iv_face:
                    Intent intent = new Intent(getActivity(), UserDesActivity.class);
                    startActivity(intent);
                    break;

                default:
                    break;
            }
        }
    };


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}