package xal.cn.com.kaishu_story.cache;


import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import xal.cn.com.kaishu_story.model.biz.entity.BannerBeans;
import xal.cn.com.kaishu_story.model.biz.entity.SonNewClassBean;
import xal.cn.com.kaishu_story.model.biz.entity.SonTitleBean;
import xal.cn.com.kaishu_story.model.biz.entity.Taletell_list_bean;
import xal.cn.com.kaishu_story.model.biz.entity.TitleBean;

/**
 * 作者:小贺
 * 编写时间: 2017/11/1.
 */

public class ApiMethod {

    /**
     * 封装线程管理和订阅的过程
     */
    public static void ApiSubscribe(Observable observable, Observer observer) {
        observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())

                .subscribe(observer);
    }

    /**
     * 用于获取豆瓣电影Top250的数据
     *
     * @param observer 由调用者传过来的观察者对象
     */
    public static void getBannerBean(Observer<BannerBeans> observer) {
        ApiSubscribe(ApiStrategy.getApiService().getBannerBean(), observer);
    }

    public static void getTitleBean(Observer<TitleBean> observer) {
        ApiSubscribe(ApiStrategy.getApiService().getTitleBean(), observer);
    }

    public static void getStoryBean(Observer<Taletell_list_bean> observer) {
        ApiSubscribe(ApiStrategy.getApiService().getStoryBean(), observer);
    }


    /*
    *
    * 亲子
    * */

    public static void getSonBean(Observer<BannerBeans> observer) {
        ApiSubscribe(ApiStrategy.getApiService().getBanner(), observer);
    }

    public static void getSonTitleBean(Observer<SonTitleBean> observer) {
        ApiSubscribe(ApiStrategy.getApiService().getSonTitleBean(), observer);
    }

    public static void getListBean(Observer<SonNewClassBean> observer) {
        ApiSubscribe(ApiStrategy.getApiService().getListBean(), observer);
    }
}
