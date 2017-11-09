package xal.cn.com.kaishu_story.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by 陌少 on 2017/10/30.
 */

public class ImgViewpagerAdapter extends PagerAdapter {
    private ArrayList<ImageView> imglist ;
    private Context context ;

    public ImgViewpagerAdapter(ArrayList<ImageView> imglist, Context context) {
        this.imglist = imglist;
        this.context = context;
    }

    @Override
    public int getCount() {
        return imglist.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(imglist.get(position));
        return imglist.get(position);
    }
}
