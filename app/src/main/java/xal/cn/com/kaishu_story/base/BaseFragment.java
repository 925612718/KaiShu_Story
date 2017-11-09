package xal.cn.com.kaishu_story.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import xal.cn.com.kaishu_story.cache.NetworkState;

/**
 * Created by Administrator on 2017/10/28.
 * 作者:刘鑫
 */

public abstract class BaseFragment extends LazyFragment {
    protected Unbinder unbinder;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), null);
        unbinder = ButterKnife.bind(this, view);
        boolean networkAvailable;
        networkAvailable = NetworkState.isNetworkAvailable(getActivity());
        if (!networkAvailable) {
            // TOD  O: 2017/10/30 做网络请求
            // TODO: 2017/10/30  加载缓存数据 吐司提示（无网络，请检查网络设置）
            Toast.makeText(getActivity(), "无网络，请检查网络设置", Toast.LENGTH_SHORT).show();
        }
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
        loadData();

    }



    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);

        //当前Fragment处于隐藏状态
        if (hidden){
            onHidden();
        }else {//当前Fragment处于显示状态
            onShow();
        }
    }

    //加载布局
    protected abstract int getLayoutId();
    //初始化数据
    protected abstract void init(View view);
    //加载数据
    protected abstract void loadData();
    //该方法在Fragment可见时调用，可以在该方法中刷新数据
    protected void onShow(){}
    //该方法在Fragment隐藏时调用，可以做数据保存
    protected void onHidden(){}

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
