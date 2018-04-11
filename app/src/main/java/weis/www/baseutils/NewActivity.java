package weis.www.baseutils;

import android.widget.TextView;

import butterknife.BindView;
import weis.www.baseutils.base.BaseActivity;
import weis.www.baseutils.bean.WeatherBean;
import weis.www.baseutils.net.HttpResult;
import weis.www.baseutils.presenter.NewPresenter;
import weis.www.baseutils.view.NewView;

/**
 * Created by Administrator on 2018/4/10.
 */

public class NewActivity extends BaseActivity<NewView, NewPresenter> implements NewView {
    @BindView(R.id.tx_weather)
    TextView txWeather;

    @Override
    protected void initView() {
        presneter.getWeather();
    }

    @Override
    protected NewPresenter setPresenter() {
        return new NewPresenter(this);
    }

    @Override
    protected int setlayout() {
        return R.layout.activity_photo_deal;
    }

    @Override
    public void getWeatherSuccess(HttpResult object) {
        txWeather.setText(object.getCity() + object.getDate() + object.getMessage());
    }

    @Override
    public void showMsg(String msg) {

    }

    @Override
    public void showDialog() {

    }

    @Override
    public void hideDialog() {

    }
}
