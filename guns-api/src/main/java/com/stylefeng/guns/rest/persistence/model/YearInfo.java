package com.stylefeng.guns.rest.model;

import java.io.Serializable;

public class YearInfo implements Serializable {

    private int yearId;

    private String yearName;

    private boolean isActive;

    public int getYearId() {
        return yearId;
    }

    public void setYearId(int yearId) {
        this.yearId = yearId;
    }

    public String getYearName() {
        return yearName;
    }

    public void setYearName(String yearName) {
        this.yearName = yearName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
