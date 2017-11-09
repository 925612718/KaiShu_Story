package xal.cn.com.kaishu_story.cache;


import io.reactivex.Observable;
import retrofit2.http.GET;
import xal.cn.com.kaishu_story.model.biz.entity.BannerBeans;
import xal.cn.com.kaishu_story.model.biz.entity.SonNewClassBean;
import xal.cn.com.kaishu_story.model.biz.entity.SonTitleBean;
import xal.cn.com.kaishu_story.model.biz.entity.Taletell_list_bean;
import xal.cn.com.kaishu_story.model.biz.entity.TitleBean;

/**
 * 作者:小贺
 * 编写时间: 2017/11/1.
 */

public interface ApiService {
    //    故事接口
    @GET("homeservice/adver/list?userid=")
    Observable<BannerBeans> getBannerBean();

    @GET("homeservice/nav/list?birthday=")
    Observable<TitleBean> getTitleBean();

    @GET("homeservice/layout/")
    Observable<Taletell_list_bean> getStoryBean();

    //    亲子接口
    @GET("homeservice/mmwk/nav/list?userid=")
    Observable<BannerBeans> getBanner();

    @GET("homeservice/mmwk/nav/list?userid=")
    Observable<SonTitleBean> getSonTitleBean();

    @GET("homeservice/mmwk/home/layout?userid=&page_no=1&page_size=15")
    Observable<SonNewClassBean> getListBean();

}
