package com.cetc.training.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;

/**
 * User: zsy(zsyclas@163.com)
 * Date: 2017-06-11
 * Time: 10:02
 * progject: hmp_android
 * Describe: 蓝牙手环
 */
@Entity(
        createInDb=true
)
public class NsDevice {
    @Id
    Long id;
    @NotNull
    private String NsDeviceName;
@Generated(hash = 1526987892)
public NsDevice(Long id, @NotNull String NsDeviceName) {
    this.id = id;
    this.NsDeviceName = NsDeviceName;
}
@Generated(hash = 711615890)
public NsDevice() {
}
public Long getId() {
    return this.id;
}
public void setId(Long id) {
    this.id = id;
}
public String getNsDeviceName() {
    return this.NsDeviceName;
}
public void setNsDeviceName(String NsDeviceName) {
    this.NsDeviceName = NsDeviceName;
}

   
}  
