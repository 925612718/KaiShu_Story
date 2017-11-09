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
import xal.cn.com.kaishu_story.model.biz.entity.SonTitleBean;

/**
 * Created by Administrator on 2017/10/31.
 * 作者:刘鑫
 */

public class SonTGridViewAdapter extends BaseAdapter {
    private List<SonTitleBean.ResultBean.ListBean> listBeans;
    private Context context;
    private MySonHolder mySonHolder;

    public SonTGridViewAdapter(List<SonTitleBean.ResultBean.ListBean> listBeans, Context context) {
        this.listBeans = listBeans;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listBeans.size();
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
            mySonHolder = new MySonHolder();
            view = LayoutInflater.from(context).inflate(R.layout.songrid_item, null);
            mySonHolder.sonText = view.findViewById(R.id.son_text);
            mySonHolder.sonImage = view.findViewById(R.id.son_image);
            view.setTag(mySonHolder);
        } else {
            mySonHolder = (MySonHolder) view.getTag();
        }
        Glide.with(context).load(listBeans.get(i).getIconurl())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .error(R.mipmap.ic_launcher)
                .placeholder(R.mipmap.ic_launcher)
                .into(mySonHolder.sonImage);
        mySonHolder.sonText.setText(listBeans.get(i).getTitle());

        return view;
    }

    class MySonHolder {
        ImageView sonImage;
        TextView sonText;
    }
}
