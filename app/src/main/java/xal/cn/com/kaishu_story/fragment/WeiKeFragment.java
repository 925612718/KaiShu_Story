package xal.cn.com.kaishu_story.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;
import xal.cn.com.kaishu_story.R;
import xal.cn.com.kaishu_story.base.BaseFragment;
import xal.cn.com.kaishu_story.view.HomePagerActivity;

/**
 * Created by Administrator on 2017/10/31.
 * 作者:刘鑫
 */

public class WeiKeFragment extends BaseFragment {
    @BindView(R.id.weike_image)
    ImageView weikeImage;
    @BindView(R.id.weike_text)
    TextView weikeText;
    @BindView(R.id.wk_button)
    Button wkButton;
    Unbinder unbinder;

    @Override
    protected int getLayoutId() {
        return R.layout.weike_fragment;
    }

    @Override
    protected void init(View view) {

    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void lazyLoad() {

    }

  

    @OnClick(R.id.wk_button)
    public void onViewClicked(View view) {
        switch (view.getId()){
            case R.id.wk_button:
                Intent intent = new Intent(getActivity(),HomePagerActivity.class);
                intent.putExtra("userloginflag", 2);
                startActivity(intent);
                break;
        }
    }
}
