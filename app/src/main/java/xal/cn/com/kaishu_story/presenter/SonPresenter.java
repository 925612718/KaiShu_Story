package xal.cn.com.kaishu_story.presenter;

import xal.cn.com.kaishu_story.model.biz.ISonBannerModel;
import xal.cn.com.kaishu_story.model.biz.SonBannerImpl;
import xal.cn.com.kaishu_story.model.biz.entity.BannerBeans;
import xal.cn.com.kaishu_story.model.biz.entity.SonNewClassBean;
import xal.cn.com.kaishu_story.model.biz.entity.SonTitleBean;
import xal.cn.com.kaishu_story.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2017/10/31.
 * 作者:刘鑫
 */

public class SonPresenter implements SonBannerContract.SonBannerPresenter {
    SonBannerContract.view sonBannerView;
    private final ISonBannerModel sonBannerModel;

    public SonPresenter(SonBannerContract.view sonBannerView) {
        this.sonBannerView = sonBannerView;
        this.sonBannerView.setPresenter(this);
        sonBannerModel = new SonBannerImpl();
    }

    @Override
    public void start() {
        sonBannerModel.getPadDaLive(new MyNetWorkCallback<BannerBeans>() {
            @Override
            public void onSuccess(BannerBeans bannerBeans) {
                sonBannerView.setResultOne(bannerBeans);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                sonBannerView.showMassage(errorMsg);
            }
        });
        sonBannerModel.getTitleBean(new MyNetWorkCallback<SonTitleBean>() {
            @Override
            public void onSuccess(SonTitleBean sonTitleBean) {
                sonBannerView.setResult(sonTitleBean);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                sonBannerView.showMassage(errorMsg);
            }
        });

        sonBannerModel.getNewClassBean(new MyNetWorkCallback<SonNewClassBean>() {
            @Override
            public void onSuccess(SonNewClassBean sonNewClassBean) {
                sonBannerView.newsClass(sonNewClassBean);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                sonBannerView.showMassage(errorMsg);
            }
        });
    }
}
