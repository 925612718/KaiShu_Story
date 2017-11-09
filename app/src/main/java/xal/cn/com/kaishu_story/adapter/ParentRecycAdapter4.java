package xal.cn.com.kaishu_story.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import xal.cn.com.kaishu_story.R;
import xal.cn.com.kaishu_story.model.biz.entity.SonNewClassBean;


/**
 * Created by lenovo on 2017/11/2.
 */

public class ParentRecycAdapter4 extends RecyclerView.Adapter<ParentRecycAdapter4.ViewHolder> {
    private Context context;
    private List<SonNewClassBean.ResultBean.ListBean.ContentBean> content;

    public ParentRecycAdapter4(Context context, List<SonNewClassBean.ResultBean.ListBean.ContentBean> content) {
        this.content = content;
        this.context = context;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.parentitem_item4, null);
        ViewHolder holder = new ViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(context).load(content.get(position).getCoverurl()).into(holder.item_img);
    }

    @Override
    public int getItemCount() {
        return content.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView item_img;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.item_img = (ImageView) rootView.findViewById(R.id.item_img);
        }

    }
}
