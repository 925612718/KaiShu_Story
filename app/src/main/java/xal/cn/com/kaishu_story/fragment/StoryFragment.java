package xal.cn.com.kaishu_story.fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import xal.cn.com.kaishu_story.R;
import xal.cn.com.kaishu_story.adapter.GridViewAdaptrer;
import xal.cn.com.kaishu_story.adapter.Taletell_List_Adapter;
import xal.cn.com.kaishu_story.base.BaseFragment;
import xal.cn.com.kaishu_story.model.biz.entity.BannerBeans;
import xal.cn.com.kaishu_story.model.biz.entity.Taletell_list_bean;
import xal.cn.com.kaishu_story.model.biz.entity.TitleBean;
import xal.cn.com.kaishu_story.presenter.StiryBannerContract;
import xal.cn.com.kaishu_story.presenter.StoryPresenter;
import xal.cn.com.kaishu_story.weight.GlideImageLoder;
import xal.cn.com.kaishu_story.weight.MoYiMoActivity;
import xal.cn.com.kaishu_story.weight.MyList;
import xal.cn.com.kaishu_story.weight.MyScrollView;
import xal.cn.com.kaishu_story.weight.NewsStoryActivity;
import xal.cn.com.kaishu_story.weight.StartActivity;

/**
 * Created by Administrator on 2017/10/28.
 * 作者:刘鑫
 */

public class StoryFragment extends BaseFragment implements StiryBannerContract.view {


    @BindView(R.id.moyimo)
    ImageView moyimo;
    @BindView(R.id.search)
    ImageView search;
    @BindView(R.id.hint)
    TextView hint;
    @BindView(R.id.start)
    ImageView start;
    @BindView(R.id.zhen_image)
    ImageView zhenImage;
    @BindView(R.id.taletell_banner)
    Banner taletellBanner;
    @BindView(R.id.gridview)
    GridView gridview;
    @BindView(R.id.tale_list)
    MyList taleList;
    @BindView(R.id.story_scroll)
    MyScrollView storyScroll;
    @BindView(R.id.load_footer)
    ImageView loadFooter;
    @BindView(R.id.story_smart)
    SmartRefreshLayout storySmart;

    private List<String> images = new ArrayList<>();
    private List<TitleBean.ResultBean.ListBean> listBeans = new ArrayList<>();
    private StiryBannerContract.StoryBannerPresenter bannerPresenter;
    private GridViewAdaptrer gridViewAdaptrer;
    private ArrayList<Taletell_list_bean.ResultBean.ListBean> datas = new ArrayList<>();
    private Taletell_List_Adapter listAdapter;
    private AnimationDrawable drawable;
    private ProgressDialog progressDialog;


    @Override
    protected int getLayoutId() {
        return R.layout.storyfragment;
    }

    @Override
    protected void init(View view) {


//        头布局帧动画
        drawable = (AnimationDrawable) getResources().getDrawable(R.drawable.refresh_header);
        zhenImage.setBackgroundDrawable(drawable);
        storySmart.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                drawable.start();
                storySmart.finishRefresh(2000);
            }
        });
        storySmart.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                Toast.makeText(getActivity(), "开始加载更多", Toast.LENGTH_SHORT).show();

//              开启子线程
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadData();
                    }
                }, 1500);
            }
        });
    }

    @Override
    protected void loadData() {
        bannerPresenter = new StoryPresenter(this);
        bannerPresenter.start();
    }

    @Override
    public void setPresenter(StiryBannerContract.StoryBannerPresenter storyBannerPresenter) {
        this.bannerPresenter = storyBannerPresenter;
    }

    @Override
    public void showProgressDialog() {
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.show();
    }

    @Override
    public void dismissDialog() {

    }

    /*
    * 展现GridView数据
    * */
    @Override
    public void setResult(final TitleBean titleBean) {
//            listBeans.clear();
        gridViewAdaptrer = new GridViewAdaptrer(listBeans, getActivity());
        gridview.setAdapter(gridViewAdaptrer);
        listBeans.addAll(titleBean.getResult().getList());
        Log.e("TAG", "  " + titleBean.getResult().getList().get(0).getTitle());
        gridViewAdaptrer.notifyDataSetChanged();
    }

    /*
    *
    * 展示轮播图数据
    * */
    @Override
    public void setResultOne(BannerBeans listBean) {
        images.clear();
        for (int i = 0; i <listBean.getResult().getList().size() ; i++) {
            images.add(listBean.getResult().getList().get(i).getImgurl());
        }

        taletellBanner.setImageLoader(new GlideImageLoder());
        taletellBanner.setImages(images);
        taletellBanner.start();

    }

    /*
    *
    * 展示RecycleView数据
    * */
    @Override
    public void setDayTJ(final Taletell_list_bean listBean) {

        listAdapter = new Taletell_List_Adapter(getActivity(), datas);
        taleList.setAdapter(listAdapter);

        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                datas.addAll(listBean.getResult().getList());
                listAdapter.notifyDataSetChanged();
            }
        });
    }


    @Override
    public void showMassage(String msg) {


    }

    @Override
    protected void lazyLoad() {

    }


    @OnClick({R.id.moyimo, R.id.search, R.id.start, R.id.taletell_banner})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.moyimo:
                startActivity(new Intent(getActivity(), MoYiMoActivity.class));
                break;
            case R.id.search:
                break;
            case R.id.start:
                startActivity(new Intent(getActivity(),StartActivity.class));
                break;
            case R.id.taletell_banner:
                break;
            case R.id.gridview:
                gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        startActivity(new Intent(getActivity(),NewsStoryActivity.class));
                    }
                });
                break;

        }
    }
}
