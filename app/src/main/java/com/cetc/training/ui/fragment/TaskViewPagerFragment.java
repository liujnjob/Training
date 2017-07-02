package com.cetc.training.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.cetc.training.base.BaseListFragment;
import com.cetc.training.base.BaseViewPagerFragment;
import com.cetc.training.base.OnTabReselectListener;
import com.cetc.training.base.ViewPageFragmentAdapter;

/**
 * Created by zang on 2016/7/27 0027.
 */
public class TaskViewPagerFragment extends BaseViewPagerFragment implements OnTabReselectListener {
    @Override
    protected void onSetupTabAdapter(ViewPageFragmentAdapter adapter) {
//添加头上的栏目
//        String[] title = getResources().getStringArray(
//                R.array.news_viewpage_arrays);
        adapter.addTab("今日任务", "task", TaskFragment.class,
                getBundle(1));
        adapter.addTab("本周计划", "task", TaskFragment.class,
                getBundle(2));
        adapter.addTab("本月计划", "task", TaskFragment.class,
                getBundle(3));
    }

    @Override
    public void onTabReselect() {
        try {
            int currentIndex = mViewPager.getCurrentItem();
            Fragment currentFragment = getChildFragmentManager().getFragments()
                    .get(currentIndex);
            if (currentFragment != null
                    && currentFragment instanceof OnTabReselectListener) {
                OnTabReselectListener listener = (OnTabReselectListener) currentFragment;
                listener.onTabReselect();
            }
        } catch (NullPointerException e) {
        }
    }

    @Override
    protected void setScreenPageLimit() {
        mViewPager.setOffscreenPageLimit(1);
    }

    private Bundle getBundle(int newType) {
        Bundle bundle = new Bundle();
        bundle.putInt(BaseListFragment.BUNDLE_KEY_CATALOG, newType);
        return bundle;
    }
}
