package xal.cn.com.kaishu_story.cache;

import android.content.Context;
import android.util.Log;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import xal.cn.com.kaishu_story.net.callback.MyNetWorkCallback;

/**
 * 作者:小贺
 * 编写时间: 2017/11/1.
 */

public class MyObserver<T> implements Observer<T> {
    private static final String TAG = "MyObserver";
    private MyNetWorkCallback<T> listener;
    private Context context;

    public MyObserver(Context context, MyNetWorkCallback<T> listener) {
        this.listener = listener;
        this.context = context;
    }

    @Override
    public void onSubscribe(Disposable d) {
        Log.d(TAG, "onSubscribe: ");
        //添加业务处理
    }

    @Override
    public void onNext(T t) {
        listener.onSuccess(t);
    }

    @Override
    public void onError(Throwable e) {
        listener.onError(404,e.toString());
        Log.e(TAG, "onError: ", e);
        //添加业务处理
    }

    @Override
    public void onComplete() {
        Log.d(TAG, "onComplete: ");
        //添加业务处理
    }

}
