package xal.cn.com.kaishu_story.model.biz;

import xal.cn.com.kaishu_story.cache.ApiMethod;
import xal.cn.com.kaishu_story.cache.MyObserver;
import xal.cn.com.kaishu_story.app.App;
import xal.cn.com.kaishu_story.model.biz.entity.BannerBeans;
import xal.cn.com.kaishu_story.model.biz.entity.Taletell_list_bean;
import xal.cn.com.kaishu_story.model.biz.entity.TitleBean;
import xal.cn.com.kaishu_story.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2017/10/28.
 * 作者:刘鑫
 */

public class StoryBannerImpl implements IStoryBannerModel {


    @Override
    public void getPadDaLive(MyNetWorkCallback<BannerBeans> callback) {
//        iHttp.get(Urls.ShouYELunBo, null, callback);
        ApiMethod.getBannerBean(new MyObserver<BannerBeans>(App.context, callback));
    }

    @Override
    public void getTitleModel(MyNetWorkCallback<TitleBean> callback) {
        ApiMethod.getTitleBean(new MyObserver<TitleBean>(App.context, callback));

    }

    @Override
    public void getDayTJModel(MyNetWorkCallback<Taletell_list_bean> callback) {
        ApiMethod.getStoryBean(new MyObserver<Taletell_list_bean>(App.context, callback));
    }


}
