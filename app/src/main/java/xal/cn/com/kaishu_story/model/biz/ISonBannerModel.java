package xal.cn.com.kaishu_story.model.biz;

import xal.cn.com.kaishu_story.model.biz.entity.BannerBeans;
import xal.cn.com.kaishu_story.model.biz.entity.SonNewClassBean;
import xal.cn.com.kaishu_story.model.biz.entity.SonTitleBean;
import xal.cn.com.kaishu_story.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2017/10/31.
 * 作者:刘鑫
 */

public interface ISonBannerModel {
    //轮播图
    void getPadDaLive(MyNetWorkCallback<BannerBeans> callback);

    //   亲子gridView
    void getTitleBean(MyNetWorkCallback<SonTitleBean> callback);

    // 亲子新课推荐
    void getNewClassBean(MyNetWorkCallback<SonNewClassBean> callback);
}
