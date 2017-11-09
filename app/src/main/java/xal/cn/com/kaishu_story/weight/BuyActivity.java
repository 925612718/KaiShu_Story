package xal.cn.com.kaishu_story.weight;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import xal.cn.com.kaishu_story.R;
import xal.cn.com.kaishu_story.adapter.BuyTabLoutAdapter;
import xal.cn.com.kaishu_story.base.BaseActivity;
import xal.cn.com.kaishu_story.fragment.BuyFragment;
import xal.cn.com.kaishu_story.fragment.WeiKeFragment;

public class BuyActivity extends BaseActivity {


    @BindView(R.id.buy_image)
    ImageView buyImage;
    @BindView(R.id.buy_pop)
    ImageView buyPop;
    @BindView(R.id.buy_tab)
    TabLayout buyTab;
    @BindView(R.id.buy_viewpager)
    ViewPager buyViewpager;
    private List<Fragment> fragments = new ArrayList<>();
    private BuyTabLoutAdapter buyTabLoutAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_buy;
    }

    @Override
    protected void initView() {
        fragments.add(new BuyFragment());
        fragments.add(new WeiKeFragment());
        buyTabLoutAdapter = new BuyTabLoutAdapter(getSupportFragmentManager(), fragments);
        buyViewpager.setAdapter(buyTabLoutAdapter);
        buyTab.setTabMode(TabLayout.MODE_FIXED);
        buyTab.setupWithViewPager(buyViewpager);

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initDate() {

    }




    @OnClick({R.id.buy_image, R.id.buy_pop})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.buy_image:
                break;
            case R.id.buy_pop:
                break;
        }
    }
}
