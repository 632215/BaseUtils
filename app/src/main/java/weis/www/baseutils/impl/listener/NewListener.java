package weis.www.baseutils.impl.listener;

import weis.www.baseutils.bean.WeatherBean;
import weis.www.baseutils.net.HttpMethod;
import weis.www.baseutils.net.HttpResult;

/**
 * Created by Administrator on 2018/4/11.
 */

public interface NewListener {
    void getWeatherSuccess(HttpResult object);

    void getWeatherFail(String msg);
}
