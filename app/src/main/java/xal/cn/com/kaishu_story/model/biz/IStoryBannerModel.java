package xal.cn.com.kaishu_story.model.biz;

import xal.cn.com.kaishu_story.model.biz.entity.BannerBeans;
import xal.cn.com.kaishu_story.model.biz.entity.Taletell_list_bean;
import xal.cn.com.kaishu_story.model.biz.entity.TitleBean;
import xal.cn.com.kaishu_story.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2017/10/28.
 * 作者:刘鑫
 */

public interface IStoryBannerModel {
    //轮播图
    void getPadDaLive(MyNetWorkCallback<BannerBeans> callback);

    //标题
    void getTitleModel(MyNetWorkCallback<TitleBean> callback);

    //   今日推荐
    void getDayTJModel(MyNetWorkCallback<Taletell_list_bean> callback);
}
