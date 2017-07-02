package com.cetc.training.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.cetc.training.utils.TDevice;

import java.io.Serializable;

import butterknife.ButterKnife;
//import com.zhy.autolayout;

/**
 * Activity 基类<br/>
 * 初始化了ButterKnife，可以使用注解绑定控件<br/>
 * <pre>
 *     继承该activity
 *         设置View：覆盖<code>getLayoutId()</code>方法
 * </pre>
 * Created by zang on 2016/2/18 0018.
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected final String TAG = this.getClass().getSimpleName();//用于打印日志（log）的类的标记
    //进度弹窗
    protected ProgressDialog progressDialog = null;
    public Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        if (getLayoutId() != 0) {
            setContentView(getLayoutId());
        }
        ButterKnife.bind(this);
        initView();
        initVariables();
        initData(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        TDevice.hideSoftKeyboard(this, getCurrentFocus());
        ButterKnife.unbind(this);
    }

    /**
     * 获取intent传递的数据
     *
     * @return
     */
    public Bundle getBundle() {
        Intent intent = getIntent();
        return intent.getExtras();
    }

    /**
     * 获取activity传递的数据
     * @param cParm key
     * @return
     */
    public String getParm(String cParm) {
        Bundle bundle = getBundle();
        if (bundle!=null&&bundle.containsKey(cParm)) {
            return bundle.getString(cParm);
        } else {
            return "";
        }
    }

    public Serializable getParam(String param){
        Bundle bundle=getBundle();
        if (bundle!=null&&bundle.containsKey(param)){
            return bundle.getSerializable(param);
        }
        return null;
    }

    /**
     * 通过覆盖改该方法设置当前view
     *
     * @return
     */
    protected int getLayoutId() {
        return 0;
    }

    /**
     * 初始化控件
     */
    protected abstract void initView();

    /**
     * 初始化变量
     */
    protected abstract void initVariables();

    /**
     * 初始化数据
     */
    protected abstract void initData(Bundle saveInstanceState);



    /**
     * 展示加载进度条,无标题
     *
     * @param stringResId
     */
    public void showProgressDialog(int stringResId) {
        try {
            showProgressDialog(null, getString(stringResId));
        } catch (Exception e) {
            Log.e(TAG, "showProgressDialog  showProgressDialog(null, getString(stringResId));");
        }
    }

    /**
     * 展示加载进度条,无标题
     *
     * @param dialogMessage
     */
    public void showProgressDialog(String dialogMessage) {
        showProgressDialog(null, dialogMessage);
    }

    /**
     * 展示加载进度条
     *
     * @param dialogTitle   标题
     * @param dialogMessage 信息
     */
    public void showProgressDialog(final String dialogTitle, final String dialogMessage) {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                if (progressDialog == null) {
                    progressDialog = new ProgressDialog(BaseActivity.this);
                }
                if (progressDialog.isShowing() == true) {
                    progressDialog.dismiss();
                }
                if (dialogTitle != null && !"".equals(dialogTitle.trim())) {
                    progressDialog.setTitle(dialogTitle);
                }
                if (dialogMessage != null && !"".equals(dialogMessage.trim())) {
                    progressDialog.setMessage(dialogMessage);
                }
                progressDialog.setCanceledOnTouchOutside(false);
                progressDialog.show();
            }
        });
    }

    /**
     * 隐藏加载进度
     */
    public void dismissProgressDialog() {
        if (progressDialog != null && progressDialog.isShowing() == true) {

            runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    progressDialog.dismiss();
                }
            });
        }
    }
    /**
     *  @author liu
     *  @time 2017/3/2  9:52
     *  @describe 用Fragment填充Framelayout
     *  @return
     */
    public void replaceContent(int resourceId, Fragment fragment){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(resourceId, fragment);
        transaction.commit();
    }

    
}
