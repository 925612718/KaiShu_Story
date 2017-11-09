package xal.cn.com.kaishu_story.weight;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import butterknife.BindView;
import butterknife.OnClick;
import xal.cn.com.kaishu_story.R;
import xal.cn.com.kaishu_story.base.BaseActivity;

public class MoYiMoActivity extends BaseActivity {

    @BindView(R.id.my_moyimo_image_sound)
    ImageView myMoyimoImageSound;
    @BindView(R.id.my_moyimo_image1)
    ImageView myMoyimoImage1;
    @BindView(R.id.my_moyimo_image2)
    ImageView myMoyimoImage2;
    @BindView(R.id.linear1)
    LinearLayout linear1;
    @BindView(R.id.linear2)
    LinearLayout linear2;
    @BindView(R.id.linear3)
    LinearLayout linear3;
    @BindView(R.id.linear4)
    LinearLayout linear4;
    @BindView(R.id.linear5)
    LinearLayout linear5;
    @BindView(R.id.linear6)
    LinearLayout linear6;
    @BindView(R.id.my_moyimo_relat3)
    RelativeLayout myMoyimoRelat3;
    @BindView(R.id.activity_moyimo)
    LinearLayout activityMoyimo;



    @Override
    protected int getLayoutId() {
        return  R.layout.activity_mo_yi_mo;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

        Glide.with(this)
                .load(R.mipmap.kaishuhi)
                .asGif()
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(myMoyimoImage1);

    }

    @Override
    protected void initDate() {

    }

    @OnClick({R.id.my_moyimo_image_sound, R.id.my_moyimo_image1, R.id.my_moyimo_image2, R.id.my_moyimo_relat3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.my_moyimo_image_sound:
                break;
            case R.id.my_moyimo_image1:
                myMoyimoImage1.setVisibility(View.GONE);//隐藏
                myMoyimoImage2.setVisibility(View.VISIBLE);//显示

                ObjectAnimator alpha = ObjectAnimator.ofFloat(myMoyimoImage2, "Alpha", 1.0f, 0.0f);
                alpha.setDuration(3000);
                alpha.start();
                alpha.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {
                    }
                    @Override
                    public void onAnimationEnd(Animator animator) {
                        myMoyimoImage2.setVisibility(View.GONE);
                        myMoyimoRelat3.setVisibility(View.VISIBLE);
                    }
                    @Override
                    public void onAnimationCancel(Animator animator) {
                    }
                    @Override
                    public void onAnimationRepeat(Animator animator) {

                    }
                });


                break;
            case R.id.my_moyimo_image2:
                break;
            case R.id.my_moyimo_relat3:
                break;
        }
    }
}
