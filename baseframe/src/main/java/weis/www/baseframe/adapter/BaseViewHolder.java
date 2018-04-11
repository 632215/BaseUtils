package weis.www.baseframe.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by Administrator on 2018/2/5.
 */

public class BaseViewHolder extends RecyclerView.ViewHolder {
    public View itemView;
    private Context context;

    public BaseViewHolder(View itemView, Context context) {
        super(itemView);
        this.context = context;
        this.itemView = itemView;
    }

    public void setText(int resId, String content) {
        if (getTextById(resId) != null) {
            getTextById(resId).setText(content);
        }
    }

    public TextView getTextById(int resId) {
        if (itemView != null) {
            TextView textView = itemView.findViewById(resId);
            return textView;
        } else {
            return null;
        }
    }

    public void setImage(int resId, int imageId) {
        if (getImageById(resId) != null) {
            Glide.with(context).load(imageId).into(getImageById(resId));
        }
    }

    public ImageView getImageById(int resId) {
        if (itemView != null) {
            ImageView iamgeView = itemView.findViewById(resId);
            return iamgeView;
        } else {
            return null;
        }
    }
}
