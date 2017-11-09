package xal.cn.com.kaishu_story.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;
import xal.cn.com.kaishu_story.weight.BuyActivity;
import xal.cn.com.kaishu_story.weight.CZActivity;
import xal.cn.com.kaishu_story.weight.Exchange;
import xal.cn.com.kaishu_story.weight.LPKActivity;
import xal.cn.com.kaishu_story.weight.LoginActivityy;
import xal.cn.com.kaishu_story.R;
import xal.cn.com.kaishu_story.weight.YHQActivity;
import xal.cn.com.kaishu_story.base.BaseFragment;

/**
 * Created by Administrator on 2017/10/28.
 * 作者:刘鑫
 */

public class MineFragment extends BaseFragment {


    @BindView(R.id.mImage_login)
    ImageView mImageLogin;
    @BindView(R.id.mImage_bf)
    ImageView mImageBf;
    @BindView(R.id.mImage_headimg)
    CircleImageView mImageHeadimg;
    @BindView(R.id.mText_headtext)
    TextView mTextHeadtext;
    @BindView(R.id.buy_textview)
    RelativeLayout buyTextview;
    @BindView(R.id.text_cz)
    RelativeLayout textCz;
    @BindView(R.id.text_dh)
    RelativeLayout textDh;
    @BindView(R.id.text_lpk)
    RelativeLayout textLpk;
    @BindView(R.id.text_yhq)
    RelativeLayout textYhq;
    @BindView(R.id.text_wdzj)
    RelativeLayout textWdzj;
    @BindView(R.id.text_wtgd)
    RelativeLayout textWtgd;
    @BindView(R.id.text_wxhd)
    RelativeLayout textWxhd;
    @BindView(R.id.text_wxzd)
    RelativeLayout textWxzd;
    @BindView(R.id.text_wdzp)
    RelativeLayout textWdzp;
    @BindView(R.id.text_yxsc)
    RelativeLayout textYxsc;
    @BindView(R.id.text_yxdd)
    RelativeLayout textYxdd;
    @BindView(R.id.mImage_phone)
    ImageView mImagePhone;
    @BindView(R.id.mImage_wx)
    ImageView mImageWx;
    @BindView(R.id.mImage_but)
    ImageView mImageBut;
    @BindView(R.id.text_zhbd)
    RelativeLayout textZhbd;
    @BindView(R.id.text_lxkf)
    RelativeLayout textLxkf;
    @BindView(R.id.text_gghp)
    RelativeLayout textGghp;
    Unbinder unbinder;
    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String img = intent.getStringExtra("img");
            String name = intent.getStringExtra("name");
            String openid = intent.getStringExtra("openid");

            Glide.with(getActivity()).load(img).into(mImageHeadimg);
            mTextHeadtext.setText(name);
        }
    };

    @Override
    protected int getLayoutId() {
        return R.layout.minefragment;
    }

    @Override
    protected void init(View view) {

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("MyFragment");
        getActivity().registerReceiver(broadcastReceiver, intentFilter);

    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void lazyLoad() {

    }

    @OnClick({R.id.buy_textview,R.id.mImage_headimg, R.id.text_cz, R.id.text_dh, R.id.text_lpk, R.id.text_yhq, R.id.text_wdzj, R.id.text_wtgd, R.id.text_wxhd, R.id.text_wxzd, R.id.text_wdzp, R.id.text_yxsc, R.id.text_yxdd, R.id.text_zhbd, R.id.text_lxkf, R.id.text_gghp})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.mImage_headimg:
                startActivity(new Intent(getActivity(), LoginActivityy.class));
                break;
            case R.id.buy_textview:
                getActivity().startActivity(new Intent(getActivity(), BuyActivity.class));
                break;
            case R.id.text_cz:
                getActivity().startActivity(new Intent(getActivity(), CZActivity.class));
                break;
            case R.id.text_dh:
                getActivity().startActivity(new Intent(getActivity(), Exchange.class));
                break;
            case R.id.text_lpk:
                getActivity().startActivity(new Intent(getActivity(), LPKActivity.class));
                break;
            case R.id.text_yhq:
                getActivity().startActivity(new Intent(getActivity(), YHQActivity.class));
                break;
            case R.id.text_wdzj:
                break;
            case R.id.text_wtgd:
                break;
            case R.id.text_wxhd:
                break;
            case R.id.text_wxzd:
                break;
            case R.id.text_wdzp:
                break;
            case R.id.text_yxsc:
                break;
            case R.id.text_yxdd:
                break;
            case R.id.text_zhbd:
                break;
            case R.id.text_lxkf:
                break;
            case R.id.text_gghp:
                break;
        }
    }
}
