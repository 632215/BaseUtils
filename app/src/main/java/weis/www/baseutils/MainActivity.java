package weis.www.baseutils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import weis.www.baseframe.adapter.BaseRecycleAdapter;
import weis.www.baseframe.customview.EmjolEditText;
import weis.www.baseframe.outpututils.ToastUtils;
import weis.www.baseframe.timeutils.TimeUtils;

public class MainActivity extends Activity implements BaseRecycleAdapter.BaseRecycleAdapterListener, View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EmjolEditText emjolEditText = findViewById(R.id.ed);
        RecyclerView recyclerView = findViewById(R.id.recycleview);
        TextView txNext = findViewById(R.id.tx_next);
        txNext.setOnClickListener(this);
        TestAdapter testAdapter = new TestAdapter(this, R.layout.item_test);
        recyclerView.setAdapter(testAdapter);
        List<String> list = new ArrayList<>();
        String time = TimeUtils.getTimeCurrentDate();
        list.add("当前时间戳：" + time);
        list.add("yyyy/MM/dd...." + TimeUtils.getFormatLongDate("yyyy/MM/dd", time));
        list.add("yyyy/MM/dd HH:mm:ss...." + TimeUtils.getFormatLongDate("yyyy/MM/dd HH:mm:ss", time));
        list.add("long...." + TimeUtils.getTime(TimeUtils.getFormatLongDate("yyyy/MM/dd HH:mm:ss", time)));
        testAdapter.setClick(true);
        testAdapter.setLongClick(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        testAdapter.setDataList(list);
        testAdapter.setListener(this);
    }

    @Override
    public void longClick(int position) {
        MyDialog dialog = new MyDialog();
        dialog.show(getFragmentManager(), "dialog");
    }

    @Override
    public void shortClick(int position) {
        ToastUtils.showLongGravity(this, String.valueOf(position), Gravity.BOTTOM, 0, 0);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tx_next:
                startActivity(new Intent(this,NewActivity.class));
                break;
        }
    }
}
