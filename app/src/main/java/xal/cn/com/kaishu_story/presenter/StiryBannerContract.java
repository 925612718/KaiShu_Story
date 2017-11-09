package xal.cn.com.kaishu_story.presenter;

import xal.cn.com.kaishu_story.base.BasePresenter;
import xal.cn.com.kaishu_story.base.BaseView;
import xal.cn.com.kaishu_story.model.biz.entity.BannerBeans;
import xal.cn.com.kaishu_story.model.biz.entity.Taletell_list_bean;
import xal.cn.com.kaishu_story.model.biz.entity.TitleBean;

/**
 * Created by Administrator on 2017/10/30.
 * 作者:刘鑫
 */

public interface StiryBannerContract {

    interface view extends BaseView<StoryBannerPresenter> {
        void showProgressDialog( );

        void dismissDialog();

        void setResult(TitleBean titleBean);

        void setResultOne(BannerBeans listBean);

        void setDayTJ(Taletell_list_bean tjBean);

        void showMassage(String msg);
    }

    interface StoryBannerPresenter extends BasePresenter {

    }
}
