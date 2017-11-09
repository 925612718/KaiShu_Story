package xal.cn.com.kaishu_story.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import xal.cn.com.kaishu_story.R;
import xal.cn.com.kaishu_story.model.biz.entity.TitleBean;

/**
 * Created by Administrator on 2017/10/30.
 * 作者:刘鑫
 */

public class GridViewAdaptrer extends BaseAdapter {
    private List<TitleBean.ResultBean.ListBean> titleBean;
    private Context context;
    private MyHolder holder;

    public GridViewAdaptrer(List<TitleBean.ResultBean.ListBean> titleBean, Context context) {
        this.titleBean = titleBean;
        this.context = context;
    }

    @Override
    public int getCount() {
        return titleBean.size();
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
        if (view == null) {
            holder = new MyHolder();
            view = LayoutInflater.from(context).inflate(R.layout.grid_item, null);
            holder.titleImage = view.findViewById(R.id.story_image);
            holder.titleText = view.findViewById(R.id.story_text);
            view.setTag(holder);
        } else {
            holder = (MyHolder) view.getTag();
        }
        Glide.with(context).load(titleBean.get(i).getIconurl())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(holder.titleImage);

        holder.titleText.setText(titleBean.get(i).getTitle());
        return view;
    }

    class MyHolder {
        ImageView titleImage;
        TextView titleText;
    }
}
