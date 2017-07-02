package com.cetc.training.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;

/**
 * User: zsy(zsyclas@163.com)
 * Date: 2017-06-09
 * Time: 09:37
 * progject: hmp_android
 * Describe: PEDDate 数据
 */
@Entity
public class PEDDate {
    @Id(autoincrement = true)
    private Long id;

    @NotNull
    private String pedTs;
    @NotNull
    private int pedSteps, pedCalories, pedDistance,
            pedActcalories, pedStepbpm, pedEnergy, pedMode, pedSleepPhase;
    @Generated(hash = 1293414065)
    public PEDDate(Long id, @NotNull String pedTs, int pedSteps, int pedCalories,
                   int pedDistance, int pedActcalories, int pedStepbpm, int pedEnergy,
                   int pedMode, int pedSleepPhase) {
        this.id = id;
        this.pedTs = pedTs;
        this.pedSteps = pedSteps;
        this.pedCalories = pedCalories;
        this.pedDistance = pedDistance;
        this.pedActcalories = pedActcalories;
        this.pedStepbpm = pedStepbpm;
        this.pedEnergy = pedEnergy;
        this.pedMode = pedMode;
        this.pedSleepPhase = pedSleepPhase;
    }
    @Generated(hash = 390568059)
    public PEDDate() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getPedTs() {
        return this.pedTs;
    }
    public void setPedTs(String pedTs) {
        this.pedTs = pedTs;
    }
    public int getPedSteps() {
        return this.pedSteps;
    }
    public void setPedSteps(int pedSteps) {
        this.pedSteps = pedSteps;
    }
    public int getPedCalories() {
        return this.pedCalories;
    }
    public void setPedCalories(int pedCalories) {
        this.pedCalories = pedCalories;
    }
    public int getPedDistance() {
        return this.pedDistance;
    }
    public void setPedDistance(int pedDistance) {
        this.pedDistance = pedDistance;
    }
    public int getPedActcalories() {
        return this.pedActcalories;
    }
    public void setPedActcalories(int pedActcalories) {
        this.pedActcalories = pedActcalories;
    }
    public int getPedStepbpm() {
        return this.pedStepbpm;
    }
    public void setPedStepbpm(int pedStepbpm) {
        this.pedStepbpm = pedStepbpm;
    }
    public int getPedEnergy() {
        return this.pedEnergy;
    }
    public void setPedEnergy(int pedEnergy) {
        this.pedEnergy = pedEnergy;
    }
    public int getPedMode() {
        return this.pedMode;
    }
    public void setPedMode(int pedMode) {
        this.pedMode = pedMode;
    }
    public int getPedSleepPhase() {
        return this.pedSleepPhase;
    }
    public void setPedSleepPhase(int pedSleepPhase) {
        this.pedSleepPhase = pedSleepPhase;
    }

}  
