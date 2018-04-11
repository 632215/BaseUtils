package weis.www.baseutils.presenter;

import android.content.Context;

import java.util.HashMap;
import java.util.Map;

import weis.www.baseutils.base.BasePresneter;
import weis.www.baseutils.bean.WeatherBean;
import weis.www.baseutils.impl.NewImpl;
import weis.www.baseutils.impl.listener.NewListener;
import weis.www.baseutils.net.HttpResult;
import weis.www.baseutils.view.NewView;

/**
 * Created by Administrator on 2018/4/11.
 */

public class NewPresenter extends BasePresneter<NewView> implements NewListener {
    private Context mContext;
    private NewImpl impl;

    public NewPresenter(Context mContext) {
        this.mContext = mContext;
        impl = new NewImpl(mContext, this);
    }

    public void getWeather() {
        Map map=new HashMap();
        map.put("city","重庆");
        if (impl != null)
            impl.getWeather(map);
    }

    @Override
    public void getWeatherSuccess(HttpResult object) {
        if (mView != null)
            mView.getWeatherSuccess(object);
    }

    @Override
    public void getWeatherFail(String msg) {
        if (mView != null)
            mView.showMsg(msg);
    }
}
