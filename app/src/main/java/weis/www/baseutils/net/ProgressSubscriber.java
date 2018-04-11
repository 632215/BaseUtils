package weis.www.baseutils.net;

import android.content.Context;

import com.google.gson.Gson;

import java.io.IOException;

import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;
import weis.www.baseframe.stringutils.StringUtils;

/**
 * Created by Administrator on 2018/4/11.
 */

public class ProgressSubscriber<T> extends Subscriber {
    private ProgressSubscriberListener listener;
    private Context mContext;
    //可定义些常量判断网络请求的返回值
    private String SUCCESS = "200";


    public ProgressSubscriber(ProgressSubscriberListener listener, Context mContext) {
        this.listener = listener;
        this.mContext = mContext;
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        if (listener == null)
            return;
        Throwable throwable = e;
        //获取最根源的异常
        while (throwable.getCause() != null) {
            e = throwable;
            throwable = throwable.getCause();
        }

        if (e instanceof HttpException) {
            listener.fail("网络错误", 400);
        } else if (e instanceof ClassCastException) {
            listener.fail("数据转化异常", 401);
        } else {
            listener.fail(e.getMessage(), 402);
        }
    }

    @Override
    public void onNext(Object o) {
        HttpResult httpResult = (HttpResult) o;
        if (httpResult == null)
            return;
        if (listener == null)
            return;
        switch (httpResult.getStatus()) {
            case 200:
                listener.success(httpResult);
                break;
        }
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    public interface ProgressSubscriberListener<T> {
        void success(T object);

        void fail(String msg, int code);
    }
}
