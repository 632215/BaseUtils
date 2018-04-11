package weis.www.baseutils.application;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.lody.turbodex.TurboDex;

/**
 * Created by Administrator on 2018/4/10.
 */

public class MyApplication extends Application {
    private static MyApplication myApplication;

    public MyApplication() {
    }

    public MyApplication getInstance() {
        if (myApplication == null)
            myApplication = this;
        return myApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;
    }

    @Override
    protected void attachBaseContext(Context base) {
        //初始化Dex拆包守护
        TurboDex.enableTurboDex();
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
