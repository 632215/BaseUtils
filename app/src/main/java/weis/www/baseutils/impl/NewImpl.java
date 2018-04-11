package weis.www.baseutils.impl;

import android.content.Context;

import java.util.Map;

import weis.www.baseutils.bean.WeatherBean;
import weis.www.baseutils.impl.listener.NewListener;
import weis.www.baseutils.net.HttpMethod;
import weis.www.baseutils.net.HttpResult;
import weis.www.baseutils.net.ProgressSubscriber;


/**
 * Created by Administrator on 2018/4/11.
 */

public class NewImpl {
    private Context mContext;
    private NewListener listener;

    public NewImpl(Context mContext, NewListener listener) {
        this.mContext = mContext;
        this.listener = listener;
    }

    public void getWeather(Map map) {
        ProgressSubscriber.ProgressSubscriberListener<HttpResult> progressSubscriberListener = new ProgressSubscriber.ProgressSubscriberListener<HttpResult>() {
            @Override
            public void success(HttpResult object) {
                listener.getWeatherSuccess(object);
            }

            @Override
            public void fail(String msg, int code) {
                listener.getWeatherFail(msg);
            }
        };
        HttpMethod.getInstance().getWeather(new ProgressSubscriber<HttpMethod>(progressSubscriberListener, mContext), map );
    }
}
