package xal.cn.com.kaishu_story.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import xal.cn.com.kaishu_story.R;
import xal.cn.com.kaishu_story.model.biz.entity.SonNewClassBean;


/**
 * Created by Administrator on 2017/11/2.
 * 作者:刘鑫
 */

public class SonListAdapter extends BaseAdapter {

    private List<SonNewClassBean.ResultBean.ListBean> listdata;
    private Context context;
    private ViewHolder viewHolder;

    public SonListAdapter(List<SonNewClassBean.ResultBean.ListBean> newsClassList, Context context) {
        this.listdata = newsClassList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listdata.size();
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
    public int getItemViewType(int position) {
        int layout = listdata.get(position).getLayout();
        return layout;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i);
        ViewHolder viewHolder = null;
        Log.e("TAG", itemViewType + "");
        view = LayoutInflater.from(context).inflate(R.layout.news_class_item, null);
        viewHolder = new ViewHolder(view);
        if (i == 6) {
            viewHolder.tv_title.setVisibility(View.GONE);
        }else{
            viewHolder.tv_title.setText(listdata.get(i).getTitle());
            viewHolder.tv_title.setVisibility(View.VISIBLE);
        }
        if (listdata.get(i).getLayout() == 101) {

            LinearLayoutManager manager = new LinearLayoutManager(context);
            viewHolder.recycler.setLayoutManager(manager);
            ParentRecycAdapter adapter = new ParentRecycAdapter(context, listdata.get(i).getContent());
            viewHolder.recycler.setAdapter(adapter);

        } else if (listdata.get(i).getLayout() == 102) {

            LinearLayoutManager manager = new LinearLayoutManager(context);
            viewHolder.recycler.setLayoutManager(manager);
            ParentRecycAdapter2 adapter = new ParentRecycAdapter2(context, listdata.get(i).getContent());
            viewHolder.recycler.setAdapter(adapter);

        } else if (listdata.get(i).getLayout() == 103) {

            GridLayoutManager manager = new GridLayoutManager(context, 3);
            viewHolder.recycler.setLayoutManager(manager);
            ParentRecycAdapter3 adapter = new ParentRecycAdapter3(context, listdata.get(i).getContent());
            viewHolder.recycler.setAdapter(adapter);

        } else if (listdata.get(i).getLayout() == 104) {

            GridLayoutManager manager = new GridLayoutManager(context, 2);
            viewHolder.recycler.setLayoutManager(manager);
            ParentRecycAdapter4 adapter = new ParentRecycAdapter4(context, listdata.get(i).getContent());
            viewHolder.recycler.setAdapter(adapter);

        }


        return view;
    }


    public static class ViewHolder {
        public View rootView;
        public TextView tv_title;
        public RecyclerView recycler;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.tv_title = (TextView) rootView.findViewById(R.id.tv_title);
            this.recycler = (RecyclerView) rootView.findViewById(R.id.recycler);
        }

    }
}
