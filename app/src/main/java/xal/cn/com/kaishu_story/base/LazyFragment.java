package xal.cn.com.kaishu_story.base;

import android.support.v4.app.Fragment;

/**
 * Created by Administrator on 2017/11/2.
 * 作者:刘鑫
 */

public abstract class LazyFragment extends Fragment {
    protected  boolean isVisible;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if(getUserVisibleHint()){
            isVisible=true;
            onVisible();
        }else{
            isVisible=false;
            onInvisible();
        }
    }

    protected void onInvisible() {

    }

    protected void onVisible() {
        lazyLoad();
    }

    protected  abstract  void lazyLoad();

}
