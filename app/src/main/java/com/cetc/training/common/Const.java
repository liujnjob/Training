package com.cetc.training.common;

/**
 * Created by zsy
 */
public class Const {

    /**
     * 请求相册
     */
    public static final int REQUEST_CODE_GETIMAGE_BYSDCARD = 0;
    public static final int ACTION_PHOTO = 101; // 照相拍照
    public static final int LOCATION_PERMISSION_CODE = 100;//定位
    public static final int CAMERA_PERMISSION_CODE = 101;//相机
    //二维码扫描常量
    public static final int QR_REQUEST_CODE = 111;
    /**
     * 血压 bp
     */
    public static final String API_ACTION_BP_LASTONE = "/api/v1/bp";
    public static final String API_ACTION_BP_RECENT = "/api/v1/bp/recent";
    public static final String API_ACTION_BP_ADD = "/api/v1/bp/add";


    /**
     * 血糖 bs
     */
    public static final String API_ACTION_BS_LASTONE = "/api/v1/bs";
    public static final String API_ACTION_BS_RECENT = "/api/v1/bs/recent";
    public static final String API_ACTION_BS_ADD = "/api/v1/bs/add";

    /**
     * 体重 weight
     */
    public static final String API_ACTION_WEIGHT_RECENT = "/api/v1/weight/recent";
    public static final String API_ACTION_WEIGHT_ADD = "/api/v1/weight/add";
    public static final String API_ACTION_WEIGHT_LASTONE = "/api/v1/weight";

    /**
     * news
     */
    public static final String API_ACTION_NEWS = "/api/v1/news";
    public static final String API_NEWS = "/api/v1/news/view"; // 新闻详情  192.168.1.102:8011/api/v1/news/view?id=21

    /**
     * family 家庭成员相关
     */
    public static final String API_ACTION_FAMILY = "/api/v1/family";
    //    public static final String API_ACTION_FAMILY_DATA = "/api/v1/family/data";  //家人页面接口 爱牵挂定位数据之前接口
    public static final String API_ACTION_FAMILY_DATA = "/api/v1/family/familyPData"; //家人页面接口  修改后增加爱牵挂设备定位接口

    public static final String API_FAMILAY_MEMBERS_ADD = "/api/v1/family/add";  // 家庭成员添加
    public static final String API_ADD_DEVICE = "/api/v1/family/deviceAdd";// 为家人绑定设备* http://xx.com/api/v1/family/deviceAdd
    public static final String API_DEVICES_LIST = "/api/v1/family/devices";//获取设备列表
    public static final String API_DELETE_DEVICE = "/api/v1/family/deviceDel"; //删除设备
    public static final String API_FAMILAY_MEMBERS = "/api/v1/family/info"; //获取家庭成员信息
    public static final String API_FAMILAY_MEMBERS_EDIT = "/api/v1/family/edit"; //获取家庭成员信息
    public static final String API_FAMILAY_MEMBERS_DELETE = "/api/v1/family/delete";//删除家庭成员




    /**
     * 用户相关
     */
    public static final String API_ACTION_LOGIN = "/api/v1/user/login";
    public static final String API_USER_REGISTER = "/api/v1/user/register";//注册  /api/v1/user/register?username=1111111&password=2222
    public static final String API_USER_MESSAGE = "/api/v1/user/getuserinfo";//获取用户信息  localhost:8011/api/v1/user/getuserinfo?userid=4&flag=1
    public static final String API_USER_PIC = "/api/v1/user/changeAvatar";//修改用户头像  localhost:8011/api/v1/user/changeAvatar
    public static final String API_USER_MESSAGE_FIX = "/api/v1/user/userInfoEdit";//修改用户信息  localhost:8011/api/v1/user/userInfoEdit
    public static final String API_USER_FORGET_PASSWORD = "/api/v1/user/forgetPassword";//找回密码(凭短信验证码)
    public static final String API_USER_CHANGE_PASSWORD = "/api/v1/user/modifyPassword";//修改密码(凭旧密码)
    public static final String API_SUGGESTION = "/api/v1/user/feedBack";  //意见反馈接口
    public static final String API_LOGINUSER_DEVICE_MESSAGE="/api/v1/family/getDeviceOfUserId";//判断当前用户是否绑定设备
    /**
     * SMS 短信服务
     */
    public static final String API_CHECK_REGIST = "/api/v1/SMS/checktelephoneregist"; //注册时 验证是否注册    localhost:8011/api/v1/SMS/checktelephoneregist
    //   注册时 申请短信验证码    localhost:8011/api/v1/SMS/checktelephoneregist.
    public static final String API_SMS_REGIST = "/api/v1/SMS/sendSMS";


    public static final String API_DOCTOR_INFO = "/api/v1/specialist/appSpecialist";    //医生信息  名医预约
    public static final String API_FAMILY_DOCTOR_INFO = "/api/v1/signOnline/appGetSignDoctor";    //医生信息  家庭签约医生

    public static final String API_FAMILY_DOCTOR_TEAM_INFO = "/api/v1/signed/appGetSignTeam";    //获取签约团队信息


    public static final String API_HOSPITAL_INFO = "/api/v1/signOnline/appGetHospital";//医院信息  医院列表  签约医生

    public static final String API_HOSPITAL_DOCTOR = "/api/v1/signOnline/appSignDoctors";//医院信息  医院列表  签约医生列表


    public static final String API_SYMPTOM_DESCRIPTIONS = "/api/v1/appointment/appAppointment";//症状描述上传接口,预约信息上传接口


    public static final String API_PERSONAL_SERVICE_ITEM = "/api/v1/serviceItems/getServiceItemsOfApp";//个性服务  服务项目
    public static final String API_PERSONAL_SERVICE_TEAM = "/api/v1/serviceItems/getServiceTeamOfApp";//个性服务  服务团队


    public static final String API_SIGNED_FAMILYDOCTOR = "/api/v1/signOnline/appReservation";//签约
    public static final String API_HAS_SIGNED_FAMILYDOCTOR = "/api/v1/appointment/appGetSpecialist";//用户已经签约的医生

    //circleView颜色常量
    public static final int colorLow = 0xffebd800;//偏低
    public static final int colorNormal = 0xff45c854;//正常
    public static final int colorHigh = 0xffff9f00;//偏高
    public static final int CircleGray = 0xffd6d8d7;//圆环灰色


    public static final int colorSerious = 0xffd34656;//严重

    //服务记录
    public static final String API_SERVICE_RECORD = "/api/v1/serviceReservation/appServiceOfToken";//服务记录
    public static final String API_SUBMMIT_RESERVE_EVALUATE = "/api/v1/appointment/appServiceEvaluation";//提交预约评价
    public static final String API_GET_RESERVE_EVALUATE = "/api/v1/appointment/appGetEvaluation";//获取预约评价
    public static final String API_SUBMMIT_SERVICE_EVALUATE = "/api/v1/serviceReservation/appServiceEvaluation";//提交服务评价
    public static final String API_GET_SERIVCE_EVALUATE = "/api/v1/serviceReservation/appGetEvaluation";//获取服务评价
    public static final String API_PERSONAL_SERIVCE_CONFIRM = "/api/v1/serviceReservation/appServiceReservation";//个性服务确认
    public static final String API_ONE_SERVICE = "/api/v1/serviceItems/appServiceItemsOfId";//获取当前团队所得服务
    public static final String API_HEALTH_RECORD = "/api/v1/bp/getQuestionNaires";//健康记录
    public static final String API_HEALTH_RECORD_DETAIL = "/api/v1/bp/toAnalysis";//健康记录详情

    /**
     * aiqiangua设备
     */
    public static final String API_ACTION_AQG_location = "/api/v1/aiqiangua/location";
    public static final String API_ACTION_AQG_devicelist = "/api/v1/aiqiangua/devicelist";
    public static final String API_ACTION_AQG_fences = "/api/v1/aiqiangua/fences";
    public static final String API_ACTION_AQG_device = "/api/v1/aiqiangua/device";
    public static final String API_DEVICE_RING = "/api/v1/aiqiangua/ring"; //唤醒设备 响铃
    public static final String API_CHECK_DEVICE = "/api/v1/aiqiangua/validate";// 设备校验
    public static final String API_DEVICE_EDIT ="/api/v1/aiqiangua/editDevice" ;//爱牵挂设备信息修改
    public static final String API_FAMILY_NUMBERS = "/api/v1/aiqiangua/listSoSNumber";//爱牵挂设备对应的亲情号
    public static final String API_ADD_FAMILY_NUMBER = "/api/v1/aiqiangua/addSOSNumber";//爱牵挂设备添加亲情号
    public static final String API_POWER_OFF = "/api/v1/aiqiangua/powerOff";//爱牵挂设备关机
    public static final String API_DEVICE_RESTART = "/api/v1/aiqiangua/restart";//爱牵挂设备重启
    public static final String API_DEVICE_FACTORYRESET = "/api/v1/aiqiangua/restore";//爱牵挂设备恢复出厂设置
    public static final String API_DEVICES_STATE = "/api/v1/aiqiangua/deviceState";//爱牵挂设备获取设备各种功能开关状态
    public static final String API_DEVICE_SWITCH ="/api/v1/aiqiangua/deviceSwitch" ;//爱牵挂设备更改设备各种功能开关状态
    public static final String API_DEVICE_INFO ="/api/v1/aiqiangua/device" ;//爱牵挂设备更改设备各种功能开关状态
    public static final String API_SOS_RECORD ="/api/v1/aiqiangua/sosData" ;//爱牵挂设备SOS记录
    public static final String API_ELECTRIC_FENCE_RECORD ="/api/v1/aiqiangua/fenceNotification" ;//爱牵挂设备SOS记录
    public static final String API_DEVICE_REMIND ="/api/v1/aiqiangua/listAlerts" ;//爱牵挂设备提醒列表
    public static final String API_DEVICE_ADD_EDIT_REMIND ="/api/v1/aiqiangua/addAlerts" ;//爱牵挂设备添加或编辑提醒
    public static final String API_DEVICE_HEART_RATE_RECORD ="/api/v1/aiqiangua/heartrateData" ;//爱牵挂设备心率记录
    public static final String API_DEVICE_STEP_COUNT_RECORD ="/api/v1/aiqiangua/sportData" ;//爱牵挂设备计步记录
    public static final String API_DEVICE_HEART_RATE_MEASURED ="/api/v1/aiqiangua/getHeartrateData" ;//爱牵挂设备心率及时测量
    public static final String API_DEVICE_WIFI_DATA_INTERFACE ="/api/v1/aiqiangua/getWifiData" ;//爱牵挂设备获取WiFi数据接口
    public static final String API_DEVICE_NEW_HEART_RATE_DATA ="/api/v1/aiqiangua/newHeartrateData" ;//爱牵挂设备获取最进一条心率值
    //绑定血压血糖设备
    public static final String API_DEVICE_BPBS_BIND ="/api/v1/family/bindDevice" ;//血压血糖设备绑定接口
    public static final String API_DEVICE_BPBS_UNBIND ="/api/v1/family/unbindDevice" ;//血压血糖设备解除绑定接口
    public static final String API_DEVICES_BINDED ="/api/v1/family/getDevices" ;//获取绑定的血压血糖设备接口


}