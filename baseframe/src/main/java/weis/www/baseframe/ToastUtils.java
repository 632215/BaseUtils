package weis.www.baseframe;

import android.content.Context;
import android.widget.Toast;

/**
 * 吐司工具类
 * <p>
 * Created by Administrator on 2018/1/30.
 */

public class ToastUtils {

    /**
     * 展示吐司——长时间
     *
     * @param context
     * @param content
     */
    public static void showLong(Context context, String content) {
        Toast.makeText(context, content, Toast.LENGTH_LONG).show();
    }

    /**
     * 展示吐司——短时间
     *
     * @param context
     * @param content
     */
    public static void showShort(Context context, String content) {
        Toast.makeText(context, content, Toast.LENGTH_SHORT).show();
    }
}