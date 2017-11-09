package xal.cn.com.kaishu_story.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by 陌少 on 2017/10/31.
 */

public class TabAdapter extends FragmentPagerAdapter {
    String[] tabs = {"故事0", "微课0"};
    List<Fragment> tab_fragment;

    public TabAdapter(FragmentManager fm, List<Fragment> tab_fragment) {
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
//    @Override
//    public CharSequence getPageTitle(int position) {
//        return tabs.get[position];
//    }
}
