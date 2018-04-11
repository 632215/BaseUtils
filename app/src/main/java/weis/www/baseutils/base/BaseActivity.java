package weis.www.baseutils.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import butterknife.ButterKnife;


/**
 * Created by Adminisrator on 2018/4/10.
 */

public abstract class BaseActivity<V, T extends BasePresneter<V>> extends FragmentActivity {
    public T presneter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setlayout());
        //ButterKnif绑定
         ButterKnife.bind(this);
        presneter = setPresenter();
        if (presneter != null)
            presneter.attach((V) this);
        initView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        ButterKnife.bind(this);
        if (presneter == null)
            presneter = setPresenter();
        presneter.attach((V) this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //ButterKnif解绑
        presneter.disAttach();
    }

    //初始化
    protected abstract void initView();

    //设置Presenter
    protected abstract T setPresenter();

    //设置layout
    protected abstract int setlayout();
}
