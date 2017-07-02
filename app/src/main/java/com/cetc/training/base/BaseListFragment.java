package com.cetc.training.base;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.cetc.training.R;
import com.cetc.training.common.ACache;
import com.cetc.training.utils.TDevice;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

@SuppressLint("NewApi")
public abstract class BaseListFragment<T> extends BaseFragment
        implements SwipeRefreshLayout.OnRefreshListener, OnItemClickListener,
        OnScrollListener,AdapterView.OnItemLongClickListener{

    public static final String BUNDLE_KEY_CATALOG = "BUNDLE_KEY_CATALOG";

    protected SwipeRefreshLayout mSwipeRefreshLayout;

    public ListView mListView;
    

    protected ListBaseAdapter<T> mAdapter;

    protected int mStoreEmptyState = -1;

    protected int mCurrentPage = 0;//当前页

    protected int mPageSize = 20;//每页条数

    protected int mCatalog = 1;

    protected ACache mACache;
    //错误信息
//    protected Result mResult;

    //private AsyncTask<String, Void, ListEntity<T>> mCacheTask;
    //private ParserTask mParserTask;

    @Override
    protected int getLayoutId() {
        return R.layout.pull_refresh_listview;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        mACache = ACache.get(getActivity());
        initView(view);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //获取传到fragment中的值
        Bundle args = getArguments();
        if (args != null) {
            mCatalog = args.getInt(BUNDLE_KEY_CATALOG, 0);
        }
    }

    /**
     * 初始化视图，初始化下拉控件
     *
     * @param view
     */
    @Override
    public void initView(View view) {
        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swiperefreshlayout);
        mListView = (ListView) view.findViewById(R.id.listview);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        //设置下拉控件进度指示环中颜色
        mSwipeRefreshLayout.setColorSchemeResources(
                R.color.swiperefresh_color1, R.color.swiperefresh_color2,
                R.color.swiperefresh_color3, R.color.swiperefresh_color4);

//        mErrorLayout.setOnLayoutClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                mCurrentPage = 0;
//                mState = STATE_REFRESH;
//                mErrorLayout.setErrorType(EmptyLayout.NETWORK_LOADING);
//                requestData(true);
//            }
//        });

        mListView.setOnItemClickListener(this);
        mListView.setOnScrollListener(this);

        if (mAdapter != null) {
            mListView.setAdapter(mAdapter);
            // mErrorLayout.setErrorType(EmptyLayout.HIDE_LAYOUT);
        } else {
            mAdapter = getListAdapter();
            mListView.setAdapter(mAdapter);

            if (requestDataIfViewCreated()) {
                //mErrorLayout.setErrorType(EmptyLayout.NETWORK_LOADING);
                mState = STATE_NONE;
                requestData(false);
            } else {
                //mErrorLayout.setErrorType(EmptyLayout.HIDE_LAYOUT);
            }

        }
        if (mStoreEmptyState != -1) {
            // mErrorLayout.setErrorType(mStoreEmptyState);
        }
    }

    @Override
    public void onDestroyView() {
        //mStoreEmptyState = mErrorLayout.getErrorState();
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        //cancelReadCacheTask();
        //cancelParserTask();
        super.onDestroy();
    }

    /**
     * 设置为listview绑定的Adapter
     *
     * @return
     */
    protected abstract ListBaseAdapter<T> getListAdapter();

    // 下拉时刷新数据
    @Override
    public void onRefresh() {
        if (mState == STATE_REFRESH) {
            return;
        }
        // 设置顶部正在刷新
        mListView.setSelection(0);
        setSwipeRefreshLoadingState();
        mCurrentPage = 0;
        mState = STATE_REFRESH;
        requestData(true);
    }

    protected boolean requestDataIfViewCreated() {
        return true;
    }

    protected String getCacheKeyPrefix() {
        return null;
    }

//    protected ListEntity<T> parseList(InputStream is) throws Exception {
//        return null;
//    }
//
//    protected ListEntity<T> readList(Serializable seri) {
//        return null;
//    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {
    }

    private String getCacheKey() {
        return new StringBuilder(getCacheKeyPrefix()).append("_")
                .append(mCurrentPage).toString();
    }

    // 是否需要自动刷新
    protected boolean needAutoRefresh() {
        return true;
    }

    /***
     * 获取列表数据
     *
     * @param refresh
     * @return void
     * @author 火蚁 2015-2-9 下午3:16:12
     */
    protected void requestData(boolean refresh) {
        String key = getCacheKey();
        if (isReadCacheData(refresh)) {
            readCacheData(key);
        } else {
            // 取新的数据
            sendRequestData();
        }
    }

    /***
     * 判断是否需要读取缓存的数据
     *
     * @param refresh
     * @return
     * @author 火蚁 2015-2-10 下午2:41
     */
    private boolean isReadCacheData(boolean refresh) {
        String key = getCacheKey();

        if (!TDevice.hasInternet(getActivity())) {
            return true;
        }
        // 第一页若不是主动刷新，缓存存在，优先取缓存的
        if (mACache.getAsObject(key) != null && !refresh && mCurrentPage == 0)
            return true;
        // 其他页数的，缓存存在以及还没有失效，优先取缓存的
        if (mACache.getAsObject(key) != null && mCurrentPage != 0) {
            return true;
        }

        return false;
    }

    // 是否到时间去刷新数据了
//    private boolean onTimeRefresh() {
//        String lastRefreshTime = AppContext.getLastRefreshTime(getCacheKey());
//        String currTime = StringUtils.getCurTimeStr();
//        long diff = StringUtils.calDateDifferent(lastRefreshTime, currTime);
//        return needAutoRefresh() && diff > getAutoRefreshTime();
//    }

    /***
     * 自动刷新的时间
     * <p/>
     * 默认：自动刷新的时间为半天时间
     *
     * @return
     * @author 火蚁 2015-2-9 下午5:55:11
     */
    protected long getAutoRefreshTime() {
        return 12 * 60 * 60;
    }

    @Override
    public void onResume() {
        super.onResume();
//        if (onTimeRefresh()) {
//            onRefresh();
//        }
    }

    /**
     * 从外部请求数据
     * 覆盖该方法，将获取数据的逻辑写到这里
     */
    protected void sendRequestData() {
    }

    /**
     * 从缓存中获取数据
     *
     * @param cacheKey 缓存key
     */
    private void readCacheData(String cacheKey) {
        mACache.getAsObject(cacheKey);
        //cancelReadCacheTask();
        //mCacheTask = new CacheTask(getActivity()).execute(cacheKey);
    }


    /**
     * 获取数据后，交给该方法处理数据，执行添加到adapter等操作
     *
     * @param data
     */
    protected void executeOnLoadDataSuccess(List<T> data) {
        if (data == null) {
            data = new ArrayList<T>();
        }


        //mErrorLayout.setErrorType(EmptyLayout.HIDE_LAYOUT);
        if (mCurrentPage == 0) {
            mAdapter.clear();
        }

//        for (int i = 0; i < data.size(); i++) {
//            if (compareTo(mAdapter.getData(), data.get(i))) {
//                data.remove(i);
//                i--;
//            }
//        }
        int adapterState = ListBaseAdapter.STATE_EMPTY_ITEM;
        if ((mAdapter.getCount() + data.size()) == 0) {
            adapterState = ListBaseAdapter.STATE_EMPTY_ITEM;
        } else if (data.size() == 0
                || (data.size() < getPageSize() && mCurrentPage == 0)) {
            adapterState = ListBaseAdapter.STATE_NO_MORE;
            mAdapter.notifyDataSetChanged();
        } else {
            adapterState = ListBaseAdapter.STATE_LOAD_MORE;
        }
        mAdapter.setState(adapterState);
        mAdapter.addData(data);
        // 判断等于是因为最后有一项是listview的状态
        if (mAdapter.getCount() == 1) {

            if (needShowEmptyNoData()) {
                //mErrorLayout.setErrorType(EmptyLayout.NODATA);
            } else {
                mAdapter.setState(ListBaseAdapter.STATE_EMPTY_ITEM);
                mAdapter.notifyDataSetChanged();
            }
        }
    }

    /**
     * 是否需要隐藏listview，显示无数据状态
     *
     * @author 火蚁 2015-1-27 下午6:18:59
     */
    protected boolean needShowEmptyNoData() {
        return true;
    }

//    protected boolean compareTo(List<? extends BaseEntity> data, BaseEntity enity) {
//        int s = data.size();
//        if (enity != null) {
//            for (int i = 0; i < s; i++) {
//                if (enity.getId() == data.get(i).getId()) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

    /**
     * 每页加载数据量
     *
     * @return
     */
    protected int getPageSize() {
        return mPageSize;
    }

    protected void onRefreshNetworkSuccess() {
    }

//    protected void executeOnLoadDataError(String error) {
//        if (mCurrentPage == 0
//                && !CacheManager.isExistDataCache(getActivity(), getCacheKey())) {
//            mErrorLayout.setErrorType(EmptyLayout.NETWORK_ERROR);
//        } else {
//            mErrorLayout.setErrorType(EmptyLayout.HIDE_LAYOUT);
//            mAdapter.setState(ListBaseAdapter.STATE_NETWORK_ERROR);
//            mAdapter.notifyDataSetChanged();
//        }
//    }

    /**
     * 完成刷新
     */

    protected void executeOnLoadFinish() {
        setSwipeRefreshLoadedState();
        mState = STATE_NONE;
    }

    /**
     * 设置顶部正在加载的状态
     */
    private void setSwipeRefreshLoadingState() {
        if (mSwipeRefreshLayout != null) {
            mSwipeRefreshLayout.setRefreshing(true);
            // 防止多次重复刷新
            mSwipeRefreshLayout.setEnabled(false);
        }
    }

    /**
     * 设置顶部加载完毕的状态
     */
    private void setSwipeRefreshLoadedState() {
        if (mSwipeRefreshLayout != null) {
            mSwipeRefreshLayout.setRefreshing(false);
            mSwipeRefreshLayout.setEnabled(true);
        }
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        if (mAdapter == null || mAdapter.getCount() == 0) {
            return;
        }
        // 数据已经全部加载，或数据为空时，或正在加载，不处理滚动事件
        if (mState == STATE_LOADMORE || mState == STATE_REFRESH) {
            return;
        }
        // 判断是否滚动到底部
        boolean scrollEnd = false;
        try {
            if (view.getPositionForView(mAdapter.getFooterView()) == view
                    .getLastVisiblePosition())
                scrollEnd = true;
        } catch (Exception e) {
            scrollEnd = false;
        }

        if (mState == STATE_NONE && scrollEnd) {
            if (mAdapter.getState() == ListBaseAdapter.STATE_LOAD_MORE
                    || mAdapter.getState() == ListBaseAdapter.STATE_NETWORK_ERROR) {
                mCurrentPage++;
                mState = STATE_LOADMORE;
                requestData(false);
                mAdapter.setFooterViewLoading();
            }
        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem,
                         int visibleItemCount, int totalItemCount) {
        // 数据已经全部加载，或数据为空时，或正在加载，不处理滚动事件
        if (mState == STATE_NOMORE || mState == STATE_LOADMORE
                || mState == STATE_REFRESH) {
            return;
        }
        //滚到到底部加载数据
        if (mAdapter != null
                && mAdapter.getDataSize() > 0
                && mListView.getLastVisiblePosition() == (mListView.getCount() - 1)) {
            if (mState == STATE_NONE
                    && mAdapter.getState() == ListBaseAdapter.STATE_LOAD_MORE) {
                mState = STATE_LOADMORE;
                mCurrentPage++;
                requestData(true);
            }
        }
    }

}