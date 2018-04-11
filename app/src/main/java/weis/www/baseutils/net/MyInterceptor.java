package weis.www.baseutils.net;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;
import okhttp3.ResponseBody;
import weis.www.baseframe.outpututils.LogUtils;

/**
 * Created by Administrator on 2018/4/10.
 */

public class MyInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Response response = chain.proceed(chain.request());
        LogUtils.i("网络请求结果-------结果码：" + response.code() + "-----返回结果：" + response.body().string().trim());
        return response.newBuilder().body(ResponseBody.create(response.body().contentType()
                , response.body().toString().trim())).build();
    }
}
