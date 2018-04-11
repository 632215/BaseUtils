package weis.www.baseutils.view;

import weis.www.baseutils.base.BaseView;
import weis.www.baseutils.bean.WeatherBean;
import weis.www.baseutils.net.HttpResult;

/**
 * Created by Administrator on 2018/4/11.
 */

public interface NewView extends BaseView{
    void showMsg(String msg);

    void getWeatherSuccess(HttpResult object);
}
