package xal.cn.com.kaishu_story.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2017/10/31.
 * 作者:刘鑫
 */

public class BuyTabLoutAdapter extends FragmentPagerAdapter {
    String[] tabs = {"故事0", "微课0"};
    List<Fragment> tab_fragment;

    public BuyTabLoutAdapter(FragmentManager fm, List<Fragment> tab_fragment) {
        super(fm);
        this.tab_fragment = tab_fragment;
    }

    @Override
    public Fragment getItem(int position) {
        return tab_fragment.get(position);
    }

    @Override
    public int getCount() {
        return tab_fragment.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }
}
