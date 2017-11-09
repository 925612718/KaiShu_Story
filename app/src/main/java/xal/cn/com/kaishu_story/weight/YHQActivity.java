package xal.cn.com.kaishu_story.weight;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.TableLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import xal.cn.com.kaishu_story.R;

import xal.cn.com.kaishu_story.base.BaseActivity;
import xal.cn.com.kaishu_story.fragment.GQFragment;
import xal.cn.com.kaishu_story.fragment.YhqFragment;

public class YHQActivity extends BaseActivity {


    @BindView(R.id.yhq_fragment_black)
    ImageView yhqFragmentBlack;
    @BindView(R.id.yhq_vp)
    ViewPager yhqVp;
    @BindView(R.id.yhq_tab)
    TableLayout yhqTab;
    private List<Fragment> fragments = new ArrayList<>();
//    private YhqTabAdapter yhqTabAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_yhq;
    }

    @Override
    protected void initView() {
        fragments.add(new GQFragment());
        fragments.add(new YhqFragment());
//        yhqTabAdapter = new YhqTabAdapter(getSupportFragmentManager(), fragments);
//        yhqVp.setAdapter(yhqTabAdapter);
//        yhqTab.setTabMode(TabLayout.MODE_FIXED);
//        yhqTab.setupWithViewPager(yhqVp);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initDate() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
