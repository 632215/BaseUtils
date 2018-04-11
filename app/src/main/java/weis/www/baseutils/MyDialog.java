package weis.www.baseutils;

import android.view.View;
import android.widget.TextView;

import weis.www.baseframe.dialog.BaseDialogFragment;
import weis.www.baseframe.outpututils.LogUtils;

/**
 * Created by Administrator on 2018/3/5.
 */

public class MyDialog extends BaseDialogFragment implements View.OnClickListener {
    TextView txTitle;
    TextView txContent;
    TextView txCancle;
    TextView txSure;

    @Override
    protected void findContentId(View view) {
        txTitle = view.findViewById(R.id.tx_title);
        txContent = view.findViewById(R.id.tx_content);
        txCancle = view.findViewById(R.id.tx_cancle);
        txSure = view.findViewById(R.id.tx_sure);
        txCancle.setOnClickListener(this);
        txSure.setOnClickListener(this);
    }

    @Override
    public int setDialogLayoutId() {
        return R.layout.dialog_test;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tx_cancle:
                dismiss();
                LogUtils.e("取消");
                break;
            case R.id.tx_sure:
                LogUtils.e("确定");
                break;
        }
    }
}
