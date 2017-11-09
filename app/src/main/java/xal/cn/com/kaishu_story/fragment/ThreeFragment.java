package xal.cn.com.kaishu_story.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;
import xal.cn.com.kaishu_story.weight.MainActivity;
import xal.cn.com.kaishu_story.R;
import xal.cn.com.kaishu_story.base.BaseFragment;

/**
 * Created by Administrator on 2017/10/28.
 * 作者:刘鑫
 */

public class ThreeFragment extends BaseFragment {
    @BindView(R.id.image_three)
    ImageView imageThree;
    Unbinder unbinder;

    @Override
    protected int getLayoutId() {
        return R.layout.threefragment;
    }

    @Override
    protected void init(View view) {

    }

    @Override
    protected void loadData() {

    }

   

    @OnClick(R.id.image_three)
    public void onViewClicked(View view) {
        switch (view.getId()){
            case R.id.image_three:
                Intent intent=new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    protected void lazyLoad() {

    }
}
