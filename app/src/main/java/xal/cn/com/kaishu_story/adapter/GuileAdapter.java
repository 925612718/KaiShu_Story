package xal.cn.com.kaishu_story.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2017/10/28.
 * 作者:刘鑫
 */

public class GuileAdapter extends FragmentPagerAdapter {
    private List<Fragment> array;

    public GuileAdapter(FragmentManager fm, List<Fragment> array) {

        super(fm);
        this.array = array;
    }

    @Override
    public Fragment getItem(int position) {
        return array.get(position);
    }

    @Override
    public int getCount() {
        return array.size();
    }
}
