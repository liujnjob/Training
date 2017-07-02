package com.cetc.training;

import android.app.ActivityManager;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.multidex.MultiDex;
import android.util.Log;

import com.cetc.training.base.BaseApplication;
import com.cetc.training.common.ACache;
import com.cetc.training.entity.User;
import com.cetc.training.gen.DaoMaster;
import com.cetc.training.gen.DaoSession;

import java.util.Map;


/**
 * Created by zang on 2016/2/22 0022.
 */
public class MyApplication extends BaseApplication {

    public static final int PAGE_SIZE = 20;// 默认分页大小

    private User mUser;
    private ACache mACache;
    private static MyApplication instance;

    // 用于存放倒计时时间
    public static Map<String, Long> map;


    private DaoMaster.DevOpenHelper mHelper;
    private SQLiteDatabase db;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;

    @Override
    public void onCreate() {
//        PgyCrashManager.register(this);
        Log.d("app", "Oncreate");
        super.onCreate();
        instance = this;
        //初始化二维码
//        ZXingLibrary.initDisplayOpinion(this);
        mACache = ACache.get(this);

// 数据库
        setDatabase();
    }

    /**
     * 获得当前app运行的AppContext
     *
     * @return
     */
    public static MyApplication getInstance() {
        return instance;
    }

    public void setLoginUser(User user) {
        mUser = user;
        mACache.put("user", user);
    }

    public User getLoginUser() {
        mUser = (User) mACache.getAsObject("user");
        return mUser;
    }

    /**
     * 获得当前进程的名字
     *
     * @param context
     * @return
     */
    public static String getCurProcessName(Context context) {

        int pid = android.os.Process.myPid();

        ActivityManager activityManager = (ActivityManager) context
                .getSystemService(Context.ACTIVITY_SERVICE);

        for (ActivityManager.RunningAppProcessInfo appProcess : activityManager
                .getRunningAppProcesses()) {

            if (appProcess.pid == pid) {

                return appProcess.processName;
            }
        }
        return null;
    }
    /**
     * 设置greenDao
     */
    private void setDatabase() {
        // 通过 DaoMaster 的内部类 DevOpenHelper，你可以得到一个便利的 SQLiteOpenHelper 对象。
        // 可能你已经注意到了，你并不需要去编写「CREATE TABLE」这样的 SQL 语句，因为 greenDAO 已经帮你做了。
        mHelper = new DaoMaster.DevOpenHelper(this, "nsdate-db", null);
        db = mHelper.getWritableDatabase();
        // 注意：该数据库连接属于 DaoMaster，所以多个 Session 指的是相同的数据库连接。
        mDaoMaster = new DaoMaster(db);
        mDaoSession = mDaoMaster.newSession();
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }

    public SQLiteDatabase getDb() {
        return db;
    }


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
