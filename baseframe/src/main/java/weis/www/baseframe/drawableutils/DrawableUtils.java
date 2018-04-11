package weis.www.baseframe.drawableutils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.TextView;

/**
 * Created by root on 17-8-19.
 */

public class DrawableUtils {
    /**
     * 设置图片在文字的周围
     *
     * @param mContext
     * @param textView
     * @param res
     * @param position
     */
    public static void setDrawableLeft(Context mContext, TextView textView, int res, String position) {
        Drawable drawable = mContext.getResources().getDrawable(res);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        switch (position) {
            case "left":
                textView.setCompoundDrawables(drawable, null, null, null);
                break;

            case "top":
                textView.setCompoundDrawables(null, drawable, null, null);
                break;

            case "right":
                textView.setCompoundDrawables(null, null, drawable, null);
                break;

            case "bottom":
                textView.setCompoundDrawables(null, null, null, drawable);
                break;
        }
    }
}
