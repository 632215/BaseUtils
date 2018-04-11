package weis.www.baseframe.dialog;

import android.app.DialogFragment;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by Administrator on 2018/3/5.
 */

public abstract class BaseDialogFragment extends DialogFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view = inflater.inflate(setDialogLayoutId(), container);
        Window win = getDialog().getWindow();
        win.setBackgroundDrawable( new ColorDrawable(Color.TRANSPARENT));
        DisplayMetrics dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics( dm );
        WindowManager.LayoutParams params = win.getAttributes();
        // 使用ViewGroup.LayoutParams，以便Dialog 宽度充满整个屏幕
        params.width =  ViewGroup.LayoutParams.MATCH_PARENT;
        params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        win.setAttributes(params);
        findContentId(view);
        return view;
    }

    @Override
    public int show(FragmentTransaction transaction, String tag) {
        if (getDialog() != null && getDialog().isShowing()) {
            getDialog().dismiss();
        }
        return super.show(transaction, tag);
    }

    /**
     * 获取控件id
     *
     * @param view
     */
    protected abstract void findContentId(View view);

    /**
     * 设置dialog的布局
     *
     * @return
     */
    public abstract int setDialogLayoutId();
}
