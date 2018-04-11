package weis.www.baseframe.outpututils;

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

    /***
     * 展示土司——长时间——位置设置
     * @param context
     * @param content
     * @param gravity
     * @param offX
     * @param offY
     */
    public static void showLongGravity(Context context, String content, int gravity, int offX, int offY) {
        Toast toast=Toast.makeText(context, content, Toast.LENGTH_LONG);
        toast.setGravity(gravity, offX, offY);
        toast.show();
    }

    /**
     * 展示土司——短时间——位置设置
     * @param context
     * @param content
     * @param gravity
     * @param offX
     * @param offY
     */
    public static void showShortGravity(Context context, String content, int gravity, int offX, int offY) {
        Toast toast=Toast.makeText(context, content, Toast.LENGTH_SHORT);
        toast.setGravity(gravity, offX, offY);
        toast.show();
    }
}