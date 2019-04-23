package com.stylefeng.guns.rest.modular.cinema.vo;

import java.io.Serializable;

/**
 * Created by Gavin
 * on 2019/4/23 11:04
 */
public class HallTypeVO implements Serializable {
    int halltypeId;
    String halltypeName;
    boolean isActive;

    public HallTypeVO() {
    }

    public HallTypeVO(int halltypeId, String halltypeName, boolean isActive) {
        this.halltypeId = halltypeId;
        this.halltypeName = halltypeName;
        this.isActive = isActive;
    }

    public int getHalltypeId() {
        return halltypeId;
    }

    public void setHalltypeId(int halltypeId) {
        this.halltypeId = halltypeId;
    }

    public String getHalltypeName() {
        return halltypeName;
    }

    public void setHalltypeName(String halltypeName) {
        this.halltypeName = halltypeName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "HallTypeVO{" +
                "halltypeId=" + halltypeId +
                ", halltypeName='" + halltypeName + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
