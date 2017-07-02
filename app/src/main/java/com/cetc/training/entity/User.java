package com.cetc.training.entity;

import com.cetc.training.base.BaseEntity;

/**
 * Created by zang on 2016/5/6 0006.
 */
public class User extends BaseEntity {

    /**
     * v_idcard: "410702198508211516",
     * i_weight: 79,
     * i_height: 179,
     * v_address: "河南省郑州市",
     * dt_birthday: "2014-09-13",
     * v_bloodtype: "4",
     * i_sex : 1
     * v_mobileno : 13523213213
     * v_username : admin(登陆名)
     * * v_cname : 管理员(中文名字)
     * v_pic:    /upload/userpic/e0c7465a-decc-496f-a5a5-85bd58a3c26d.png     //头像路径
     * isBP:
     * isBS:
     */
    /**
     * dt_createdate : 2015-12-24 17:32:18
     * dt_lastdatetime : 2015-12-24 17:32:18
     * i_id : 4
     * i_roleid : 21
     * i_status : 0
     * i_type : 1
     * isdelete : 1
     * rolename : 管理员
     * token : 548171870b33459f947c21ab08bd042f
     */


    private String v_idcard;
    private int i_weight;
    private int i_height;
    private String v_address;
    private String dt_birthday;
    private String v_bloodtype;


    private String dt_createdate;
    private String dt_lastdatetime;
    private int i_id;
    private int i_roleid;
    private int i_sex;
    private int i_status;
    private int i_type;
    private int isdelete;
    private String rolename;
    private String token;
    private String v_cname;
    private String v_mobileno;
    private String v_username;
    private String v_pic;
    private int isBP;
    private int isBS;
    private String im_token;

    public void setIm_token(String im_token) {
        this.im_token = im_token;
    }

    public String getIm_token() {
        return im_token;
    }

    public String getV_idcard() {
        return v_idcard;
    }

    public void setV_idcard(String v_idcard) {
        this.v_idcard = v_idcard;
    }

    public int getI_weight() {
        return i_weight;
    }

    public void setI_weight(int i_weight) {
        this.i_weight = i_weight;
    }

    public int getI_height() {
        return i_height;
    }

    public void setI_height(int i_height) {
        this.i_height = i_height;
    }

    public String getV_address() {
        return v_address;
    }

    public void setV_address(String v_address) {
        this.v_address = v_address;
    }

    public String getDt_birthday() {
        return dt_birthday;
    }

    public void setDt_birthday(String dt_birthday) {
        this.dt_birthday = dt_birthday;
    }

    public String getV_bloodtype() {
        return v_bloodtype;
    }

    public void setV_bloodtype(String v_bloodtype) {
        this.v_bloodtype = v_bloodtype;
    }


    public String getDt_createdate() {
        return dt_createdate;
    }

    public void setDt_createdate(String dt_createdate) {
        this.dt_createdate = dt_createdate;
    }

    public String getDt_lastdatetime() {
        return dt_lastdatetime;
    }

    public void setDt_lastdatetime(String dt_lastdatetime) {
        this.dt_lastdatetime = dt_lastdatetime;
    }

    public int getI_id() {
        return i_id;
    }

    public void setI_id(int i_id) {
        this.i_id = i_id;
    }

    public int getI_roleid() {
        return i_roleid;
    }

    public void setI_roleid(int i_roleid) {
        this.i_roleid = i_roleid;
    }

    public int getI_sex() {
        return i_sex;
    }

    public void setI_sex(int i_sex) {
        this.i_sex = i_sex;
    }

    public int getI_status() {
        return i_status;
    }

    public void setI_status(int i_status) {
        this.i_status = i_status;
    }

    public int getI_type() {
        return i_type;
    }

    public void setI_type(int i_type) {
        this.i_type = i_type;
    }

    public int getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(int isdelete) {
        this.isdelete = isdelete;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getV_cname() {
        return v_cname;
    }

    public void setV_cname(String v_cname) {
        this.v_cname = v_cname;
    }

    public String getV_mobileno() {
        return v_mobileno;
    }

    public void setV_mobileno(String v_mobileno) {
        this.v_mobileno = v_mobileno;
    }

    public String getV_username() {
        return v_username;
    }

    public void setV_username(String v_username) {
        this.v_username = v_username;
    }

    public String getV_pic() {
        return v_pic;
    }

    public void setV_pic(String v_pic) {
        this.v_pic = v_pic;
    }


    public int getIsBP() {
        return isBP;
    }

    public void setIsBP(int isBP) {
        this.isBP = isBP;
    }

    public int getIsBS() {
        return isBS;
    }

    public void setIsBS(int isBS) {
        this.isBS = isBS;
    }

    @Override
    public String toString() {
        return "User{" +
                "v_idcard='" + v_idcard + '\'' +
                ", i_weight=" + i_weight +
                ", i_height=" + i_height +
                ", v_address='" + v_address + '\'' +
                ", dt_birthday='" + dt_birthday + '\'' +
                ", v_bloodtype='" + v_bloodtype + '\'' +
                ", dt_createdate='" + dt_createdate + '\'' +
                ", dt_lastdatetime='" + dt_lastdatetime + '\'' +
                ", i_id=" + i_id +
                ", i_roleid=" + i_roleid +
                ", i_sex=" + i_sex +
                ", i_status=" + i_status +
                ", i_type=" + i_type +
                ", isdelete=" + isdelete +
                ", rolename='" + rolename + '\'' +
                ", token='" + token + '\'' +
                ", v_cname='" + v_cname + '\'' +
                ", v_mobileno='" + v_mobileno + '\'' +
                ", v_username='" + v_username + '\'' +
                ", v_pic='" + v_pic + '\'' +
                ", isBP=" + isBP +
                ", isBS=" + isBS +
                ", im_token='" + im_token + '\'' +
                '}';
    }
}
