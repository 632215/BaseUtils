package weis.www.baseframe.outpututils;

import android.util.Log;

/**
 * 日志打印工具
 * <p>
 * Created by Administrator on 2018/2/1.
 */

public final class LogUtils {
    private static boolean showFlag = true;//定义一个开关，控制是否打印。可以在application中进行控制
    private static String Tag = "32s";//标签

    private LogUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static void setTag(String tag) {
        Tag = tag;
    }

    public static void setShowFlag(boolean showFlag) {
        LogUtils.showFlag = showFlag;
    }

    public static void e(String msg) {
        if (showFlag)
            Log.e(Tag, msg);
    }

    public static void d(String msg) {
        if (showFlag)
            Log.d(Tag, msg);

    }

    public static void i(String msg) {
        if (showFlag)
            Log.i(Tag, msg);

    }

    public static void v(String msg) {
        if (showFlag)
            Log.v(Tag, msg);

    }

    public static void w(String msg) {
        if (showFlag)
            Log.w(Tag, msg);

    }
}
