package com.cetc.training.ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.androidquery.AQuery;
import com.cetc.training.R;
import com.cetc.training.base.BaseEntity;
import com.cetc.training.base.BaseListFragment;
import com.cetc.training.base.ListBaseAdapter;
import com.cetc.training.base.OnTabReselectListener;
import com.cetc.training.common.ACache;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * Created by zang on 2016/7/27 0027.
 */
public class TaskFragment extends BaseListFragment<BaseEntity> implements
        OnTabReselectListener {
    protected static final String TAG = TaskFragment.class.getSimpleName();
    private static final String CACHE_KEY_PREFIX = "tasklist_";
    private boolean isBP = true;
    private AQuery aQuery;
    private ACache mAcache;
    private int obey;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        aQuery = new AQuery(getActivity());
        mAcache = ACache.get(getActivity());
        EventBus.getDefault().register(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.listview_count;
    }

    @Override
    protected String getCacheKeyPrefix() {
        String key = CACHE_KEY_PREFIX + mCatalog;
        if (isBP) {
            key += "_bp";
        } else {
            key += "_bs";
        }
        return key;
    }

    @Override
    protected void sendRequestData() {
    }


    private void setTips(int count) {

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
       return false;

    }


    private void NormalListDialogCustomAttr(final int patient_id, final String patient_type, final String patient_name) {

    }



    @Override
    public void onTabReselect() {
    }

    @Subscribe
    public void onEventMainThread(String type) {
        Log.d(TAG, "EventBus收到int:" + type);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected ListBaseAdapter<BaseEntity> getListAdapter() {
        return null;
    }

}
