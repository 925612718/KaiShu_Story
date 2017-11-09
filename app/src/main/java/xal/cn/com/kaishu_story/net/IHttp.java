package xal.cn.com.kaishu_story.net;


import java.util.Map;

import xal.cn.com.kaishu_story.net.callback.MyNetWorkCallback;

/**
 * Created by xingge on 2017/7/11.
 */

public interface IHttp {

    <T> void get(String url, Map<String, String> params, MyNetWorkCallback<T> callback);

    <T> void post(String url, Map<String, String> params, MyNetWorkCallback<T> callback);

    void upload();

    void download();

    void loadImage();

}
