package weis.www.baseframe.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import weis.www.baseframe.outpututils.ToastUtils;

/**
 * Created by Administrator on 2018/2/1.
 */

public abstract class BaseRecycleAdapter<T> extends RecyclerView.Adapter<BaseViewHolder> {
    private List<T> dataList;
    private Context context;
    private int layoutId;
    private boolean isClick = false;
    private boolean isLongClick = false;
    private BaseRecycleAdapterListener listener;

    public BaseRecycleAdapter(Context context, int layoutId) {
        this.context = context;
        this.layoutId = layoutId;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
        notifyDataSetChanged();
    }

    public void setListener(BaseRecycleAdapterListener listener) {
        this.listener = listener;
    }

    public void setClick(boolean click) {
        isClick = click;
    }

    public void setLongClick(boolean longClick) {
        isLongClick = longClick;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(layoutId, null);
        return new BaseViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, final int position) {
        if (isClick)
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.shortClick(position);
                }
            });
        if (isLongClick)
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    listener.longClick(position);
                    return true;
                }
            });
        viewHolderData(holder, dataList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    protected abstract void viewHolderData(BaseViewHolder holder, T data);

    public interface BaseRecycleAdapterListener {
        void longClick(int position);

        void shortClick(int position);
    }
}
