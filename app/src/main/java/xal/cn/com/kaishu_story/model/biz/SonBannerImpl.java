package xal.cn.com.kaishu_story.model.biz;

import xal.cn.com.kaishu_story.cache.ApiMethod;
import xal.cn.com.kaishu_story.cache.MyObserver;
import xal.cn.com.kaishu_story.app.App;
import xal.cn.com.kaishu_story.model.biz.entity.BannerBeans;
import xal.cn.com.kaishu_story.model.biz.entity.SonNewClassBean;
import xal.cn.com.kaishu_story.model.biz.entity.SonTitleBean;
import xal.cn.com.kaishu_story.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2017/10/31.
 * 作者:刘鑫
 */

public class SonBannerImpl implements ISonBannerModel {
    @Override
    public void getPadDaLive(MyNetWorkCallback<BannerBeans> callback) {
//        iHttp.get(Urls.ShouYELunBo, null, callback);
        ApiMethod.getSonBean(new MyObserver<BannerBeans>(App.context,callback));
    }

    @Override
    public void getTitleBean(MyNetWorkCallback<SonTitleBean> callback) {
//        iHttp.get(Urls.SonTitle, null, callback);
        ApiMethod.getSonTitleBean(new MyObserver<SonTitleBean>(App.context,callback));
    }

    @Override
    public void getNewClassBean(MyNetWorkCallback<SonNewClassBean> callback) {
//        iHttp.get(Urls.NEWCLASSTUIJIAN, null, callback);
        ApiMethod.getListBean(new MyObserver<SonNewClassBean>(App.context,callback));
    }
}
