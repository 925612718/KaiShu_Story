package xal.cn.com.kaishu_story.fragment;

import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import xal.cn.com.kaishu_story.R;
import xal.cn.com.kaishu_story.adapter.SonListAdapter;
import xal.cn.com.kaishu_story.adapter.SonTGridViewAdapter;
import xal.cn.com.kaishu_story.app.App;
import xal.cn.com.kaishu_story.base.BaseFragment;
import xal.cn.com.kaishu_story.model.biz.entity.BannerBeans;
import xal.cn.com.kaishu_story.model.biz.entity.SonNewClassBean;
import xal.cn.com.kaishu_story.model.biz.entity.SonTitleBean;
import xal.cn.com.kaishu_story.presenter.SonBannerContract;
import xal.cn.com.kaishu_story.presenter.SonPresenter;
import xal.cn.com.kaishu_story.weight.GlideImageLoder;
import xal.cn.com.kaishu_story.weight.MyList;

/**
 * Created by Administrator on 2017/10/28.
 * 作者:刘鑫
 */

public class SonFragment extends BaseFragment implements SonBannerContract.view {
    @BindView(R.id.son_banner)
    Banner sonBanner;
    @BindView(R.id.son_grid)
    GridView sonGrid;
    @BindView(R.id.tale_list1)
    MyList taleList1;
    @BindView(R.id.sonsmart)
    SmartRefreshLayout sonsmart;
    @BindView(R.id.son_image)
    ImageView sonImage;
    @BindView(R.id.son_zhen_image)
    ImageView sonZhenImage;
    private List<String> sonImages = new ArrayList<>();
    private List<SonTitleBean.ResultBean.ListBean> listBeans = new ArrayList<>();
    private SonBannerContract.SonBannerPresenter sonBannerPresenter;
    private SonTGridViewAdapter sonTGridViewAdapter;
    private List<SonNewClassBean.ResultBean.ListBean> sonlistBeanList = new ArrayList<>();
    private SonListAdapter sonListAdapter;
       AnimationDrawable animationDrawable;


    @Override
    protected int getLayoutId() {
        return R.layout.sonfragment;
    }

    @Override
    protected void init(View view) {

        animationDrawable = (AnimationDrawable) getResources().getDrawable(R.drawable.refresh_header);
        sonZhenImage.setBackgroundDrawable(animationDrawable);

        sonsmart.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                sonsmart.finishRefresh(2000);
                animationDrawable.start();
                Toast.makeText(getActivity(), "开始加载", Toast.LENGTH_SHORT).show();
                App.PageSize = 1;
            }
        });
        sonsmart.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                sonsmart.finishLoadmore(2000);
                Toast.makeText(getActivity(), "开始加载更多", Toast.LENGTH_SHORT).show();
//                App.PageSize++;

//                loadData();
            }
        });
    }

    @Override
    protected void loadData() {
        sonBannerPresenter = new SonPresenter(this);
        sonBannerPresenter.start();
    }

    @Override
    public void setPresenter(SonBannerContract.SonBannerPresenter sonBannerPresenter) {
        this.sonBannerPresenter = sonBannerPresenter;
    }

    @Override
    public void showProgressDialog() {

    }

    @Override
    public void dismissDialog() {

    }

    /*
    *   展示亲子标题数据
    * */
    @Override
    public void setResult(final SonTitleBean sonTitleBean) {
        sonTGridViewAdapter = new SonTGridViewAdapter(listBeans, getActivity());
        sonGrid.setAdapter(sonTGridViewAdapter);

                listBeans.addAll(sonTitleBean.getResult().getList());
                sonTGridViewAdapter.notifyDataSetChanged();

    }

    /*
    *展示轮播图数据
    * */
    @Override
    public void setResultOne(BannerBeans listBean) {
        sonImages.clear();
        for (int i = 0; i < 5; i++) {
            sonImages.add(listBean.getResult().getList().get(i).getImgurl());
        }
        sonBanner.setImageLoader(new GlideImageLoder());
        sonBanner.setImages(sonImages);
        sonBanner.start();
    }

    /*
    *
    * 展示数据
    * */
    @Override
    public void newsClass(SonNewClassBean sonNewClassBean) {
        sonlistBeanList.addAll(sonNewClassBean.getResult().getList());
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                sonListAdapter = new SonListAdapter(sonlistBeanList, getActivity());
                taleList1.setAdapter(sonListAdapter);
                sonListAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void showMassage(String msg) {

    }

    @Override
    protected void lazyLoad() {

    }
}
