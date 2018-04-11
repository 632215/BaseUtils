package weis.www.baseutils.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/4/10.
 */

public abstract class BaseFragment<V, T extends BasePresneter<V>> extends Fragment {
    public T presenter;
    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(setlayoutId(), container, false);
        presenter = setPresenter();
        unbinder = ButterKnife.bind(this, view);
        if (presenter != null)
            presenter.attach((V) this);
        initView();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (presenter == null)
            presenter = setPresenter();
        presenter.attach((V) this);
    }

    @Override
    public void onPause() {
        super.onPause();
        unbinder.unbind();
        if (presenter != null)
            presenter.disAttach();
    }

    protected abstract void initView();

    protected abstract T setPresenter();

    protected abstract int setlayoutId();

}
