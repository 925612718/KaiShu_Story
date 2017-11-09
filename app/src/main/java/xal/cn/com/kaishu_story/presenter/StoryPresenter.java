package xal.cn.com.kaishu_story.presenter;

import xal.cn.com.kaishu_story.model.biz.IStoryBannerModel;
import xal.cn.com.kaishu_story.model.biz.StoryBannerImpl;
import xal.cn.com.kaishu_story.model.biz.entity.BannerBeans;
import xal.cn.com.kaishu_story.model.biz.entity.Taletell_list_bean;
import xal.cn.com.kaishu_story.model.biz.entity.TitleBean;
import xal.cn.com.kaishu_story.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2017/10/30.
 * 作者:刘鑫
 */

public class StoryPresenter implements StiryBannerContract.StoryBannerPresenter {
    StiryBannerContract.view bannerview;
    IStoryBannerModel bannerModel;

    public StoryPresenter(StiryBannerContract.view bannerview) {
        this.bannerview = bannerview;
        this.bannerview.setPresenter(this);
        bannerModel = new StoryBannerImpl();
    }

    @Override
    public void start() {

        bannerModel.getPadDaLive(new MyNetWorkCallback<BannerBeans>() {
            @Override
            public void onSuccess(BannerBeans listBean) {
                bannerview.setResultOne(listBean);

            }

            @Override
            public void onError(int errorCode, String errorMsg) {

                bannerview.showMassage(errorMsg);
            }
        });

        bannerModel.getTitleModel(new MyNetWorkCallback<TitleBean>() {
            @Override
            public void onSuccess(TitleBean titleBean) {
                bannerview.setResult(titleBean);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                bannerview.showMassage(errorMsg);
            }
        });
//        今日推荐
        bannerModel.getDayTJModel(new MyNetWorkCallback<Taletell_list_bean>() {

            @Override
            public void onSuccess(Taletell_list_bean taletell_list_bean) {
                bannerview.setDayTJ(taletell_list_bean);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                bannerview.showMassage(errorMsg);
            }
        });

    }
}
