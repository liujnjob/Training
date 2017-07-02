package com.cetc.training.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.androidquery.AQuery;
import com.cetc.training.R;
import com.cetc.training.base.BaseActivity;
import com.cetc.training.ui.fragment.TaskViewPagerFragment;

import org.greenrobot.eventbus.EventBus;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by zang on 2016/7/21 0021.
 */
public class TaskActivity extends BaseActivity {

    AQuery aQuery;
    @Bind(R.id.navigation_bar_title)
    TextView navigation_bar_title;
    @Bind(R.id.lay_btn_set)
    LinearLayout lay_btn_set;
    @Bind(R.id.tv_set)
    TextView tv_set;

    @Override
    protected void initView() {
        navigation_bar_title.setText("训练计划");
        lay_btn_set.setVisibility(View.VISIBLE);
        lay_btn_set.setPadding(14, 14, 14, 14);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.realtabcontent, new TaskViewPagerFragment());
        transaction.commit();
    }

    @Override
    protected void initVariables() {
        //EventBus.getDefault().register(this);
        aQuery = new AQuery(this);

    }

    @Override
    protected void initData(Bundle saveInstanceState) {
        //loadData();
    }


    public void loadBSMember() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_task;
    }

    @OnClick({R.id.lay_btn_set})
    public void click(View v) {
        switch (v.getId()) {
            case R.id.lay_btn_set:
                break;
        }
    }
    public void getData() {

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
