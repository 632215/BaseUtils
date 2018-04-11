package weis.www.baseutils.net;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by Administrator on 2018/4/10.
 */

public class HttpMethod<T> {
    //http相关
    private static String BASE_URL = "https://www.sojson.com/open/api/weather/";
    private static int DEFAULT_TIME = 120;
    private static OkHttpClient.Builder builder;
    private static Retrofit retrofit;

    private static HttpMethod httpMethod;
    private AppService appService;

    //饥饿单例
    public static HttpMethod getInstance() {
        if (httpMethod == null) {
            httpMethod = new HttpMethod();
        }
        return httpMethod;
    }

    //私有构造方法
    private HttpMethod() {
        builder = new OkHttpClient.Builder();
        builder.connectTimeout(DEFAULT_TIME, TimeUnit.SECONDS);
        builder.readTimeout(DEFAULT_TIME, TimeUnit.SECONDS);
        builder.writeTimeout(DEFAULT_TIME, TimeUnit.SECONDS);

        //添加拦截器
//        builder.addInterceptor(new MyInterceptor());
        retrofit = new Retrofit.Builder()
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build();

        appService = retrofit.create(AppService.class);
    }

    public <T> void toSubscribe(Observable<T> observable, Subscriber<T> subscriber) {
        observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    //获取天气信息
    public void getWeather(Subscriber<HttpResult> subscriber,Map map) {
        Observable observable = appService.getWeather(map);
        toSubscribe(observable, subscriber);
    }
}
