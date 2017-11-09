package xal.cn.com.kaishu_story.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/30.
 * 作者:刘鑫
 */

public class StoryBannerAdapter extends BaseAdapter {
    private List<String>storyBanner =new ArrayList<>();
    private Context context;

    public StoryBannerAdapter(List<String> storyBanner, Context context) {
        this.storyBanner = storyBanner;
        this.context = context;
    }

    @Override
    public int getCount() {
        return storyBanner.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null) {
//            LayoutInflater.from(context).inflate(R)
        }
        return null;
    }
}
