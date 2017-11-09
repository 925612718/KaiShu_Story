package xal.cn.com.kaishu_story.app;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

import xal.cn.com.kaishu_story.base.BaseActivity;

/**
 * Created by Administrator on 2017/10/28.
 * 作者:刘鑫
 */

public class App extends Application {
    public static BaseActivity context = null;

    public static int PageSize =1;


    {

        PlatformConfig.setWeixin("wx967daebe835fbeac", "5bb696d9ccd75a38c8a0bfe0675559b3");
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad", "http://sns.whalecloud.com");
    }
    @Override
    public void onCreate() {
        super.onCreate();
        UMShareAPI.get(this);
    }
//避免超过64k的方法
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

}
