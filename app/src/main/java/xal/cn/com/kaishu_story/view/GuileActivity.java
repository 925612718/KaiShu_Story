package xal.cn.com.kaishu_story.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import xal.cn.com.kaishu_story.weight.MainActivity;
import xal.cn.com.kaishu_story.R;
import xal.cn.com.kaishu_story.adapter.GuileAdapter;
import xal.cn.com.kaishu_story.base.BaseActivity;
import xal.cn.com.kaishu_story.fragment.OneFragment;
import xal.cn.com.kaishu_story.fragment.ThreeFragment;
import xal.cn.com.kaishu_story.fragment.TwoFragment;

public class GuileActivity extends BaseActivity {

private List<Fragment> array =new ArrayList<>();
    @BindView(R.id.guile_viewpager)
    ViewPager guileViewpager;
    private GuileAdapter guileAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_guile;
    }

    @Override
    protected void initView() {
        guileAdapter = new GuileAdapter(getSupportFragmentManager(), array);
        guileViewpager.setAdapter(guileAdapter);
    }

    @Override
    protected void initData() {
        SharedPreferences sp = getSharedPreferences("one", MODE_PRIVATE);
        boolean name = sp.getBoolean("name", false);
        if(!name) {
            SharedPreferences.Editor edit = sp.edit();
            edit.putBoolean("name",true);
            edit.commit();
        }else {
            Intent intent =new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        array.add(new OneFragment());
        array.add(new TwoFragment());
        array.add(new ThreeFragment());
        guileAdapter.notifyDataSetChanged();
    }

    @Override
    protected void initDate() {

    }


}
