package com.cetc.training;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;

import com.cetc.training.utils.AlertUtil;
import com.cetc.training.utils.PreferencesUtil;
import com.cetc.training.utils.StringUtil;

/**
 * Created by zang on 2016/2/17 0017.
 */
public class AppManager {
    private static String ip = "health.22tianbo.com";
    private static String port = "8011";

    private static String debug_ip = "192.168.0.21";
    private static String debug_port = "8011";

    /**
     * 获取web接口地址
     */
    public static String getHostPort(Context ctx) {
        String cHost = PreferencesUtil.getString(ctx, "ip", ip);
        String cPort = PreferencesUtil.getString(ctx, "port", port);
        if (StringUtil.isEmpty(cPort)) {
            return "http://" + cHost;
        }
        return "http://" + cHost + ":" + cPort;
    }

    public static void AlertMSG(Context context, String message) {

        AlertUtil.dialog(context, "提示框", message, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
    }

    public static void AlertMSG(final Context context, String message, Boolean isClose) {

        AlertUtil.dialog(context, "提示框", message, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Activity activity = (Activity) context;
                activity.setResult(Activity.RESULT_OK);
                activity.finish();
            }
        });
    }

}
