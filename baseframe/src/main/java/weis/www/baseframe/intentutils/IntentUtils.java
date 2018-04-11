package weis.www.baseframe.intentutils;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;

import weis.www.baseframe.outpututils.ToastUtils;

/**
 * Created by Administrator on 2018/3/5.
 */

public class IntentUtils {

    /**
     * 检查目标Activity是否存在
     * @param context
     * @param intent
     */
    public void startActicityJump(Context context, Intent intent) {
        if (context.getPackageManager().resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY) != null) {
            try {
                context.startActivity(intent);
            } catch (ActivityNotFoundException e) {
                ToastUtils.showShort(context, "target activity not found!");
            }
        }
    }
}
