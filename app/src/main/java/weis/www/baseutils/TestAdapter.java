package weis.www.baseutils;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import weis.www.baseframe.adapter.BaseRecycleAdapter;
import weis.www.baseframe.adapter.BaseViewHolder;
import weis.www.baseframe.outpututils.ToastUtils;

/**
 * Created by Administrator on 2018/2/5.
 */

public class TestAdapter extends BaseRecycleAdapter<String>  {
    private Context context;

    public TestAdapter(Context context, int layoutId) {
        super(context, layoutId);
        this.context = context;
    }

    @Override
    protected void viewHolderData(BaseViewHolder holder, String position) {
       /* TestViewHolder testViewHolder = new TestViewHolder(holder.itemView);
        testViewHolder.textView.setText(position);*/
        holder.setText(R.id.text, position);
        holder.setImage(R.id.imageView, R.mipmap.ic_launcher_round);
    }



    public class TestViewHolder extends BaseViewHolder {
        TextView textView;

        public TestViewHolder(View itemView) {
            super(itemView, context);
            textView = itemView.findViewById(R.id.text);
        }
    }
}
