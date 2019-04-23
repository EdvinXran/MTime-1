package com.stylefeng.guns.rest.modular.cinema.vo;

import java.io.Serializable;

/**
 * Created by Gavin
 * on 2019/4/23 11:04
 */
public class AreaVO implements Serializable {
    int areaId;
    String areaName;
    boolean isActive;

    public AreaVO() {
    }

    public AreaVO(int areaId, String areaName, boolean isActive) {
        this.areaId = areaId;
        this.areaName = areaName;
        this.isActive = isActive;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "AreaVO{" +
                "areaId=" + areaId +
                ", areaName='" + areaName + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
