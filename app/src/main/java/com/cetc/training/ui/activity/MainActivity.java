package com.cetc.training.ui.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.androidquery.AQuery;
import com.cetc.training.R;
import com.cetc.training.base.BaseActivity;
import com.cetc.training.common.ACache;
import com.cetc.training.entity.User;
import com.cetc.training.utils.PermissionUtils;
import com.cetc.training.utils.ToastUtils;

import java.util.Arrays;

import butterknife.Bind;
import butterknife.OnClick;
import cn.bingoogolapple.bgabanner.BGABanner;

public class MainActivity extends BaseActivity {
    AQuery aQuery;
    ACache mACache;
    User loginUser;
    @Bind(R.id.navigation_bar_title)
    TextView navigationBarTitle;
    @Bind(R.id.banner_guide_content)
    BGABanner bannerGuideContent;
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            "android.permission.READ_EXTERNAL_STORAGE",
            "android.permission.WRITE_EXTERNAL_STORAGE"};
    @Bind(R.id.ll_task_plan)
    LinearLayout llTaskPlan;
    @Bind(R.id.ll_statistics)
    LinearLayout llStatistics;
    @Bind(R.id.ll_examine)
    LinearLayout llExamine;
    @Bind(R.id.ll_synchrodata)
    LinearLayout llSynchrodata;
    @Bind(R.id.ll_user_info)
    LinearLayout llUserInfo;
    @Bind(R.id.ll_system_setting)
    LinearLayout llSystemSetting;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }


    @Override
    protected void initView() {
        //android 6.0动态申请读写权限
        checkReadAndWritePermission();
    }

    @Override
    protected void initVariables() {
        initBanner();
    }

    @Override
    protected void initData(Bundle saveInstanceState) {
    }
//
//    @OnClick({R.id.ll_task_plan, R.id.ll_statistics, R.id.ll_examine, R.id.ll_synchrodata, R.id.ll_user_info, R.id.ll_user_info})
//    public void click(View view){
//        switch(view.getId()){
//            case R.id.ll_task_plan:
//                break;
//        }
//
//    }

    /**
     * 初始化轮播图
     */
    void initBanner() {
        //初始化方式1
//        List<View> views = new ArrayList<>();
//        views.add(BGABannerUtil.getItemImageView(getContext(), R.mipmap.banner_yi));
//        views.add(BGABannerUtil.getItemImageView(getContext(), R.mipmap.banner_er));
//        views.add(BGABannerUtil.getItemImageView(getContext(), R.mipmap.banner_san));
//        mContentBanner.setData(views);

        //初始化方式2
        bannerGuideContent.setAdapter(new BGABanner.Adapter() {
            @Override
            public void fillBannerItem(BGABanner banner, View view, Object model, int position) {
                ((ImageView) view).setImageResource((int) model);
            }
        });
        bannerGuideContent.setData(Arrays.asList(R.mipmap.banner_4, R.mipmap.banner_5, R.mipmap.banner_6, R.mipmap.banner_7), null);
        bannerGuideContent.setOnItemClickListener(new BGABanner.OnItemClickListener() {
            @Override
            public void onBannerItemClick(BGABanner banner, View view, Object model, int position) {
                Log.i(TAG, "点击了第" + (position + 1) + "页");
            }
        });
    }

    /**
     * 检查读写权限
     */
    public void checkReadAndWritePermission() {
        if (Build.VERSION.SDK_INT >= 23) {//6.0新的权限规则
            boolean hasPermission = PermissionUtils
                    .checkPermissions(this, PERMISSIONS_STORAGE, REQUEST_EXTERNAL_STORAGE);
            if (!hasPermission) {
                ToastUtils.show(this, "请设置SD卡读写权限");
            }
        }
    }

    @OnClick({R.id.ll_task_plan, R.id.ll_statistics, R.id.ll_examine, R.id.ll_synchrodata, R.id.ll_user_info, R.id.ll_system_setting})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_task_plan:
                Intent intent = new Intent(this, TaskActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_statistics:
                break;
            case R.id.ll_examine:
                break;
            case R.id.ll_synchrodata:
                break;
            case R.id.ll_user_info:
                break;
            case R.id.ll_system_setting:
                break;
        }
    }
}
