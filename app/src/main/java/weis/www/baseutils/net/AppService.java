package weis.www.baseutils.net;

import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import rx.Observable;
import weis.www.baseutils.bean.WeatherBean;

/**
 * Created by Administrator on 2018/4/10.
 */

public interface AppService {
    @GET("json.shtml?")
    Observable<HttpResult> getWeather(@QueryMap Map<String, String> map);

    @FormUrlEncoded
    @POST
    Observable<WeatherBean> getPostRequest(@FieldMap Map map);
}
