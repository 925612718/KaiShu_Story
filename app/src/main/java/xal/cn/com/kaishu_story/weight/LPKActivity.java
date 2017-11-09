package xal.cn.com.kaishu_story.weight;

import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.OnClick;
import xal.cn.com.kaishu_story.R;
import xal.cn.com.kaishu_story.base.BaseActivity;

public class LPKActivity extends BaseActivity {


    @BindView(R.id.lpk_image_back)
    ImageView lpkImageBack;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_lpk;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initDate() {

    }


    @OnClick(R.id.lpk_image_back)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.lpk_image_back:
                finish();
                break;
        }
    }
}
