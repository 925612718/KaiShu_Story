package xal.cn.com.kaishu_story.presenter;

import xal.cn.com.kaishu_story.base.BasePresenter;
import xal.cn.com.kaishu_story.base.BaseView;
import xal.cn.com.kaishu_story.model.biz.entity.BannerBeans;
import xal.cn.com.kaishu_story.model.biz.entity.SonNewClassBean;
import xal.cn.com.kaishu_story.model.biz.entity.SonTitleBean;

/**
 * Created by Administrator on 2017/10/31.
 * 作者:刘鑫
 */

public interface SonBannerContract {
    interface view extends BaseView<SonBannerPresenter> {

        void showProgressDialog();

        void dismissDialog();

        void setResult(SonTitleBean sonTitleBean);

        void setResultOne(BannerBeans listBean);

        void newsClass(SonNewClassBean sonNewClassBean);

        void showMassage(String msg);

    }

    interface SonBannerPresenter extends BasePresenter {

    }
}
