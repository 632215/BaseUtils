package weis.www.baseutils.base;


/**
 * Created by Administrator on 2018/4/10.
 */

public abstract class BasePresneter<V> {
    public V mView;

    public void attach(V view) {
        mView = view;
    }

    public void disAttach() {
        mView = null;
    }
}
