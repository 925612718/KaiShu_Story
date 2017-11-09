package xal.cn.com.kaishu_story.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import xal.cn.com.kaishu_story.R;
import xal.cn.com.kaishu_story.model.biz.entity.Taletell_list_bean;
import xal.cn.com.kaishu_story.weight.MediaPlayerActivity;
import xal.cn.com.kaishu_story.weight.StartActivity;


/**
 * Created by lenovo on 2017/10/31.
 */

public class Taletell_List_Adapter extends BaseAdapter {
    private Context context;
    private List<Taletell_list_bean.ResultBean.ListBean> listdata;
    private GridLayoutManager mymanager4;
    private List_recycler_Adapter2 adapter4;

    public Taletell_List_Adapter(Context context, List<Taletell_list_bean.ResultBean.ListBean> listdata) {
        this.context = context;
        this.listdata = listdata;
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
        return position;
    }

    @Override
    public int getViewTypeCount() {
        return 11;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;

        switch (getItemViewType(i)) {
            case 0:

                if (view == null) {
                    view = View.inflate(context, R.layout.taletell_list_item, null);
                    holder = new ViewHolder(view);
                    view.setTag(holder);

                } else {
                    holder = (ViewHolder) view.getTag();
                }
                holder.title.setText(listdata.get(i).getTitle());

                holder.contentText.setText(listdata.get(i).getSubtitle().get(0));
                GridLayoutManager manager = new GridLayoutManager(context, 2);
                holder.recyc.setLayoutManager(manager);
                List_recycler_Adapter4 adapter = new List_recycler_Adapter4(context, listdata.get(i).getContent());
                adapter.setOnClickLinser(new List_recycler_Adapter4.Linsern() {
                    @Override
                    public void onclick(int position) {
                        if (listdata.get(0).getContent().get(position).getContenttype().equals("ablum")) {

                        Toast.makeText(context,"跳转到webView页面",Toast.LENGTH_SHORT).show();
                        } else {
                            Intent intent = new Intent(context, StartActivity.class);
                            intent.putExtra("image", listdata.get(0).getContent().get(position).getStory().getCoverurl());
                            Log.e("TAG", "liuxin"+listdata.get(0).getContent().get(position).getStory().getCoverurl());
                            intent.putExtra("name", listdata.get(0).getContent().get(position).getStory().getStoryname());
                            intent.putExtra("time",listdata.get(0).getContent().get(position).getStory().getTimetext());
                            Log.e("TAG", "xinailin"+listdata.get(0).getContent().get(position).getStory().getTimetext());
                            intent.putExtra("mp3", listdata.get(0).getContent().get(position).getStory().getVoiceurl());
                            context.startActivity(intent);
                        }
                    }
                });
                holder.recyc.setAdapter(adapter);
                Glide.with(context).load(listdata.get(i).getAdver().getCoverurl()).into(holder.img);
                break;
            case 1:
                Log.e("TAG", "1111111111111");
                ViewHolder2 holder2 = null;
                if (view == null) {
                    view = View.inflate(context, R.layout.taletell_list_item2, null);
                    holder2 = new ViewHolder2(view);
                    view.setTag(holder2);
                } else {
                    holder2 = (ViewHolder2) view.getTag();
                }
                holder2.title.setText(listdata.get(i).getContent().get(0).getAblum().getAblumname());
                holder2.content.setText(listdata.get(i).getContent().get(0).getAblum().getSubhead());
                Glide.with(context).load(listdata.get(i).getContent().get(0).getAblum().getProduct().getCoverurl()).into(holder2.img);
                GridLayoutManager mymanager = new GridLayoutManager(context, 2);
                holder2.recyc.setLayoutManager(mymanager);
                List_recycler_Adapter2 adapter2 = new List_recycler_Adapter2(context, listdata.get(i).getContent());
                adapter2.setOnClickLinser(new List_recycler_Adapter2.Linsern() {
                    @Override
                    public void onclick(int position) {
                        Toast.makeText(context, "点击了", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(context, MediaPlayerActivity.class);

                    }
                });
                holder2.recyc.setAdapter(adapter2);
                break;
            case 2:
                ViewHolder3 holder3 = null;
                if (view == null) {
                    view = View.inflate(context, R.layout.taletell_list_item3, null);
                    holder3 = new ViewHolder3(view);
                    view.setTag(holder3);

                } else {
                    holder3 = (ViewHolder3) view.getTag();
                }
                holder3.title.setText(listdata.get(i).getTitle());
                holder3.contentText.setText(listdata.get(i).getSubtitle().get(0));
                GridLayoutManager manager3 = new GridLayoutManager(context, 1);
                holder3.recyc.setLayoutManager(manager3);
                List_recycler_Adapter3 adapter3 = new List_recycler_Adapter3(context, listdata.get(i).getContent());
                holder3.recyc.setAdapter(adapter3);
                break;
            case 3:
                ViewHolder4 holder4 = null;
                if (view == null) {
                    view = View.inflate(context, R.layout.taletell_list_item2, null);
                    holder4 = new ViewHolder4(view);
                    view.setTag(holder4);

                } else {
                    holder4 = (ViewHolder4) view.getTag();
                }
                holder4.tag_title.setText(listdata.get(i).getTitle());
                holder4.tag_content.setText(listdata.get(i).getSubtitle().get(0));
                holder4.price.setVisibility(View.GONE);
                holder4.much.setVisibility(View.GONE);
                holder4.title.setText(listdata.get(i).getContent().get(0).getAblum().getAblumname());
                holder4.content.setText(listdata.get(i).getContent().get(0).getAblum().getSubhead());
                Glide.with(context).load(listdata.get(i).getContent().get(0).getCoverurl()).into(holder4.img);
                mymanager4 = new GridLayoutManager(context, 2);
                holder4.recyc.setLayoutManager(mymanager4);
                adapter4 = new List_recycler_Adapter2(context, listdata.get(i).getContent());
                holder4.recyc.setAdapter(adapter4);
                break;
            case 4:
                if (view == null) {
                    view = View.inflate(context, R.layout.taletell_list_item3, null);
                    holder = new ViewHolder(view);
                    view.setTag(holder);

                } else {
                    holder = (ViewHolder) view.getTag();
                }
                holder.title.setText(listdata.get(i).getTitle());
                Log.e("tag", listdata.get(i).getSubtitle().get(0));
                holder.contentText.setText(listdata.get(i).getSubtitle().get(0));
                GridLayoutManager mymanager13 = new GridLayoutManager(context, 2);
                holder.recyc.setLayoutManager(mymanager13);
                holder.much.setVisibility(View.VISIBLE);
                List_recycler_Adapter4 adapter13 = new List_recycler_Adapter4(context, listdata.get(i).getContent());
                holder.recyc.setAdapter(adapter13);
                break;
            case 5:
                ViewHolder5 holder5 = null;
                if (view == null) {
                    view = View.inflate(context, R.layout.taletell_list_item2, null);
                    holder5 = new ViewHolder5(view);
                    view.setTag(holder5);

                } else {
                    holder5 = (ViewHolder5) view.getTag();
                }
                holder5.tag_title.setText(listdata.get(i).getTitle());
                holder5.tag_content.setText(listdata.get(i).getSubtitle().get(0));
                Glide.with(context).load(listdata.get(i).getContent().get(0).getCoverurl()).into(holder5.img);
                holder5.title.setText(listdata.get(i).getContent().get(0).getAblum().getAblumname());
                holder5.content.setText(listdata.get(i).getContent().get(0).getAblum().getSubhead());
                GridLayoutManager mymanager5 = new GridLayoutManager(context, 2);
                holder5.recyc.setLayoutManager(mymanager5);
                List_recycler_Adapter2 adapter5 = new List_recycler_Adapter2(context, listdata.get(i).getContent());
                holder5.recyc.setAdapter(adapter5);
                holder5.price.setVisibility(View.GONE);
                holder5.much.setVisibility(View.GONE);
                /*if (view == null) {
                    view = View.inflate(context, R.layout.taletell_list_item3, null);
                    holder = new ViewHolder(view);
                    view.setTag(holder);

                } else {
                    holder = (ViewHolder) view.getTag();
                }
                holder.title.setText(listdata.get(i).getTitle());
                Log.e("tag", listdata.get(i).getSubtitle().get(0));
                holder.contentText.setText(listdata.get(i).getSubtitle().get(0));
                GridLayoutManager mymanager6 = new GridLayoutManager(context, 2);
                holder.recyc.setLayoutManager(mymanager6);
                List_recycler_Adapter4 adapter6 = new List_recycler_Adapter4(context, listdata.get(i).getContent());
                holder.recyc.setAdapter(adapter6);
                break;*/
                break;
            case 6:
                if (view == null) {
                    view = View.inflate(context, R.layout.taletell_list_item3, null);
                    holder = new ViewHolder(view);
                    view.setTag(holder);
                } else {
                    holder = (ViewHolder) view.getTag();
                }
                holder.title.setText(listdata.get(i).getTitle());
                Log.e("tag", listdata.get(i).getSubtitle().get(0));
                holder.contentText.setText(listdata.get(i).getSubtitle().get(0));
                GridLayoutManager mymanager7 = new GridLayoutManager(context, 2);
                holder.recyc.setLayoutManager(mymanager7);
                List_recycler_Adapter4 adapter7 = new List_recycler_Adapter4(context, listdata.get(i).getContent());
                holder.recyc.setAdapter(adapter7);
                break;
            case 7:
                if (view == null) {
                    view = View.inflate(context, R.layout.taletell_list_item3, null);
                    holder = new ViewHolder(view);
                    view.setTag(holder);

                } else {
                    holder = (ViewHolder) view.getTag();
                }
                holder.title.setText(listdata.get(i).getTitle());
                Log.e("tag", listdata.get(i).getSubtitle().get(0));
                holder.contentText.setText(listdata.get(i).getSubtitle().get(0));
                GridLayoutManager mymanager8 = new GridLayoutManager(context, 2);
                holder.recyc.setLayoutManager(mymanager8);
                List_recycler_Adapter4 adapter8 = new List_recycler_Adapter4(context, listdata.get(i).getContent());
                holder.recyc.setAdapter(adapter8);
                break;
            case 8:
                if (view == null) {
                    view = View.inflate(context, R.layout.taletell_list_item3, null);
                    holder = new ViewHolder(view);
                    view.setTag(holder);

                } else {
                    holder = (ViewHolder) view.getTag();
                }
                holder.title.setText(listdata.get(i).getTitle());
                Log.e("tag", listdata.get(i).getSubtitle().get(0));
                holder.contentText.setText(listdata.get(i).getSubtitle().get(0));
                GridLayoutManager mymanager9 = new GridLayoutManager(context, 2);
                holder.recyc.setLayoutManager(mymanager9);
                holder.much.setVisibility(View.VISIBLE);
                List_recycler_Adapter4 adapter9 = new List_recycler_Adapter4(context, listdata.get(i).getContent());
                holder.recyc.setAdapter(adapter9);
                break;
            case 9:
                if (view == null) {
                    view = View.inflate(context, R.layout.taletell_list_item3, null);
                    holder = new ViewHolder(view);
                    view.setTag(holder);

                } else {
                    holder = (ViewHolder) view.getTag();
                }
                holder.title.setText(listdata.get(i).getTitle());
                Log.e("tag", listdata.get(i).getSubtitle().get(0));
                holder.contentText.setText(listdata.get(i).getSubtitle().get(0));
                GridLayoutManager mymanager11 = new GridLayoutManager(context, 1);
                holder.recyc.setLayoutManager(mymanager11);
                holder.much.setVisibility(View.VISIBLE);
                List_recycler_Adapter5 adapter11 = new List_recycler_Adapter5(context, listdata.get(i).getContent());
                holder.recyc.setAdapter(adapter11);

                break;
            case 10:
                if (view == null) {
                    view = View.inflate(context, R.layout.taletell_list_item3, null);
                    holder = new ViewHolder(view);
                    view.setTag(holder);

                } else {
                    holder = (ViewHolder) view.getTag();
                }
                holder.title.setText(listdata.get(i).getTitle());
                Log.e("tag", listdata.get(i).getSubtitle().get(0));
                holder.contentText.setText(listdata.get(i).getSubtitle().get(0));
                GridLayoutManager mymanager10 = new GridLayoutManager(context, 2);
                holder.recyc.setLayoutManager(mymanager10);
                holder.much.setVisibility(View.VISIBLE);
                List_recycler_Adapter4 adapter10 = new List_recycler_Adapter4(context, listdata.get(i).getContent());
                holder.recyc.setAdapter(adapter10);
                break;
        }
        return view;
    }


    public static class ViewHolder {
        public View rootView;
        public TextView title;
        public TextView much;
        public TextView contentText;
        public RecyclerView recyc;
        public ImageView img;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.title = (TextView) rootView.findViewById(R.id.title);
            this.much = (TextView) rootView.findViewById(R.id.much);
            this.contentText = (TextView) rootView.findViewById(R.id.contentText);
            this.recyc = (RecyclerView) rootView.findViewById(R.id.recyc);
            this.img = (ImageView) rootView.findViewById(R.id.img);
        }

    }

    public static class ViewHolder2 {
        public View rootView;
        public ImageView img;
        public TextView title;
        public TextView content;
        public RecyclerView recyc;

        public ViewHolder2(View rootView) {
            this.rootView = rootView;
            this.img = (ImageView) rootView.findViewById(R.id.img);
            this.title = (TextView) rootView.findViewById(R.id.title);
            this.content = (TextView) rootView.findViewById(R.id.content);
            this.recyc = (RecyclerView) rootView.findViewById(R.id.recyc);
        }

    }

    public static class ViewHolder3 {
        public View rootView;
        public TextView title;
        public TextView contentText;
        public RecyclerView recyc;

        public ViewHolder3(View rootView) {
            this.rootView = rootView;
            this.title = (TextView) rootView.findViewById(R.id.title);
            this.contentText = (TextView) rootView.findViewById(R.id.contentText);
            this.recyc = (RecyclerView) rootView.findViewById(R.id.recyc);
        }

    }


    public static class ViewHolder4 {
        public View rootView;
        public TextView much;
        public ImageView img;
        public TextView title;
        public TextView content;
        public TextView tag_title;
        public TextView tag_content;
        public TextView price;
        public RecyclerView recyc;

        public ViewHolder4(View rootView) {
            this.rootView = rootView;
            this.much = (TextView) rootView.findViewById(R.id.much);
            this.img = (ImageView) rootView.findViewById(R.id.img);
            this.title = (TextView) rootView.findViewById(R.id.title);
            this.tag_title = (TextView) rootView.findViewById(R.id.tag_title);
            this.tag_content = (TextView) rootView.findViewById(R.id.tag_content);
            this.content = (TextView) rootView.findViewById(R.id.content);
            this.price = (TextView) rootView.findViewById(R.id.price);
            this.recyc = (RecyclerView) rootView.findViewById(R.id.recyc);
        }

    }

    public static class ViewHolder5 {
        public View rootView;
        public TextView much;
        public ImageView img;
        public TextView tag_title;
        public TextView tag_content;
        public TextView title;
        public TextView content;
        public TextView price;
        public RecyclerView recyc;

        public ViewHolder5(View rootView) {
            this.rootView = rootView;
            this.much = (TextView) rootView.findViewById(R.id.much);
            this.img = (ImageView) rootView.findViewById(R.id.img);
            this.title = (TextView) rootView.findViewById(R.id.title);
            this.content = (TextView) rootView.findViewById(R.id.content);
            this.tag_title = (TextView) rootView.findViewById(R.id.tag_title);
            this.tag_content = (TextView) rootView.findViewById(R.id.tag_content);
            this.price = (TextView) rootView.findViewById(R.id.price);
            this.recyc = (RecyclerView) rootView.findViewById(R.id.recyc);
        }

    }

}
