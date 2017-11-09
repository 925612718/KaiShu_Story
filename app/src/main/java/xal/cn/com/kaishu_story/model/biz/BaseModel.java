package xal.cn.com.kaishu_story.model.biz;

import xal.cn.com.kaishu_story.net.HttpFactroy;
import xal.cn.com.kaishu_story.net.IHttp;

/**
 * Created by Administrator on 2017/10/28.
 * 作者:刘鑫
 */

public interface BaseModel {

    public static IHttp iHttp = HttpFactroy.create();

}
