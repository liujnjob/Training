package com.cetc.training;

import android.os.Environment;

import java.io.File;

/**
 * Created by zang on 2016/3/6.
 */
public class AppConfig {

    /**
     * 天气，位置获取时间间隔
     */
    public static int WEATHER_LOCATION_INTERVAL = 60 * 60 * 1000;

    private static String APP_SDCARD_DIR = "Tobacco";//app在sd卡上的目录名

    /**
     * SD卡中应用的根目录 如果不存在内存卡，则返回系统应用目录
     */
    public static String getRootDir() {
        String sdStatus = Environment.getExternalStorageState();
        String StrRootDir = "";
        File myfile = null;
        // 如果内存卡正常
        if (sdStatus.equals(Environment.MEDIA_MOUNTED)) {
            StrRootDir = Environment.getExternalStorageDirectory()
                    .getAbsolutePath() + File.separator + APP_SDCARD_DIR;
            myfile = new File(StrRootDir);
            if (!myfile.exists()) {
                myfile.mkdir();
            }
        }

        if ((myfile != null) && (myfile.exists())) {
            return StrRootDir;
        } else {
            return "";
        }
    }

    /**
     * 获取应用下files目录
     *
     * @return
     */
    public static String getAppFilesDir() {
        return MyApplication.getInstance().getFilesDir().getAbsolutePath();

    }

    /**
     * SD卡照片目录
     *
     * @return
     */
    public static String getPhotoDir() {
        String cDir = getRootDir() + File.separator + "Camera" + File.separator;
        checkDir(cDir);
        return cDir;
    }

    /**
     * 音频目录
     *
     * @return
     */
    public static String getAudioDir() {
        String cDir = getRootDir() + File.separator + "Audio" + File.separator;
        checkDir(cDir);
        return cDir;
    }

    /**
     * 视频目录
     *
     * @return
     */
    public static String getVideoDir() {
        String cDir = getRootDir() + File.separator + "Video" + File.separator;
        checkDir(cDir);
        return cDir;
    }

    /**
     * 检查路径是否存在，如果不存在就创建
     *
     * @param strDir
     * @return
     */
    public static boolean checkDir(String strDir) {
        File file = new File(strDir);
        if (!file.exists()) {
            return file.mkdir();
        } else {
            return true;
        }
    }
}
