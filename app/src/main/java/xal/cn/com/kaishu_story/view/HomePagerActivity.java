package xal.cn.com.kaishu_story.view;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import xal.cn.com.kaishu_story.R;
import xal.cn.com.kaishu_story.base.BaseActivity;
import xal.cn.com.kaishu_story.fragment.MineFragment;
import xal.cn.com.kaishu_story.fragment.SonFragment;
import xal.cn.com.kaishu_story.fragment.StoryFragment;

public class HomePagerActivity extends BaseActivity {


    private RadioGroup radioGroup;
    private RadioButton gs;
    private RadioButton qz;
    private RadioButton wd;

    private StoryFragment storyFragment;
    private SonFragment sonFragment;
    private MineFragment mineFragment;
    private FragmentManager manager;
    private FragmentTransaction transaction;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home_pager;
    }

    @Override
    protected void initView() {
        radioGroup = findViewById(R.id.radiogroup);
        qz = findViewById(R.id.son);
        wd = findViewById(R.id.mine);
        gs = findViewById(R.id.story);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                manager = getSupportFragmentManager();
                transaction = manager.beginTransaction();
                showFragmete(transaction);
                if (i == R.id.story) {
                    if (storyFragment == null) {
                        storyFragment = new StoryFragment();
                        transaction.add(R.id.fram, storyFragment);
                    } else {
                        transaction.show(storyFragment);
                    }
                } else if (i == R.id.son) {
                    if (sonFragment == null) {
                        sonFragment = new SonFragment();
                        transaction.add(R.id.fram, sonFragment);
                    } else {
                        transaction.show(sonFragment);
                    }
                } else if (i == R.id.mine) {
                    if (mineFragment == null) {
                        mineFragment = new MineFragment();
                        transaction.add(R.id.fram, mineFragment);
                    } else {
                        transaction.show(mineFragment);
                    }
                }
                transaction.commit();
            }
        });
    }

    private void showFragmete(FragmentTransaction transaction) {
        if (storyFragment != null) {

            transaction.hide(storyFragment);
        }
        if (sonFragment != null) {
            transaction.hide(sonFragment);
        }
        if (mineFragment != null) {
            transaction.hide(mineFragment);

        }

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initDate() {
        storyFragment = new StoryFragment();
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.add(R.id.fram, storyFragment);
        transaction.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        int id = getIntent().getIntExtra("userloginflag", 0);
        if (id == 2) {
            if (sonFragment == null) {
                sonFragment = new SonFragment();
                transaction.add(R.id.fram, sonFragment);
            } else {
                transaction.show(sonFragment);
            }transaction.commit();
        }else if (id == 1) {
            if (storyFragment == null) {
                storyFragment = new StoryFragment();
                transaction.add(R.id.fram, storyFragment);
            } else {
                transaction.show(storyFragment);
            }
            transaction.commit();
        }

    }
    //记录用户首次点击返回键的时间
    private long firstTime = 0;

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                long secondTime = System.currentTimeMillis();
                if (secondTime - firstTime > 2000) {
                    Toast.makeText(HomePagerActivity.this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                    firstTime = secondTime;
                    return true;
                } else {
                    HomePagerActivity.this.finish();//结束当前Activity
                    Intent startMain = new Intent(Intent.ACTION_MAIN);
                    startMain.addCategory(Intent.CATEGORY_HOME);
                    startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(startMain);
                    System.exit(0);// 退出程序
                }
                break;
        }
        return super.onKeyUp(keyCode, event);
    }
}
