package xal.cn.com.kaishu_story.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import xal.cn.com.kaishu_story.R;
import xal.cn.com.kaishu_story.model.biz.entity.Taletell_list_bean;

/**
 * Created by lenovo on 2017/10/31.
 */

public class List_recycler_Adapter extends RecyclerView.Adapter<List_recycler_Adapter.ViewHolder> {
    private Context context;
    private List<Taletell_list_bean.ResultBean.ListBean.ContentBean> content;

    public  List_recycler_Adapter(Context context, List<Taletell_list_bean.ResultBean.ListBean.ContentBean> content) {
        this.content = content;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.tale_item_grid_item, null);
        ViewHolder holder = new ViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if ((content.get(position).getContenttype()).equals("ablum")) {
            holder.tale_title.setText(content.get(position).getAblum().getAblumname());
            holder.tale_content.setText(content.get(position).getAblum().getSubhead());
            Glide.with(context).load(content.get(position).getCoverurl()).into(holder.item_img);
        } else if ((content.get(position).getContenttype()).equals("story")) {
            holder.tale_title.setText(content.get(position).getStory().getStoryname());
            holder.tale_content.setText(content.get(position).getStory().getSubhead());
            Glide.with(context).load(content.get(position).getCoverurl()).into(holder.item_img);
        }
    }

    @Override
    public int getItemCount() {
        return content.size();
    }




    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView item_img;
        public TextView tale_title;
        public TextView tale_content;
        public ViewHolder(View itemView) {
            super(itemView);
            item_img = (ImageView) itemView.findViewById(R.id.item_img);
            tale_title = (TextView) itemView.findViewById(R.id.tale_title);
            tale_content = (TextView) itemView.findViewById(R.id.tale_content);
        }
    }
}
