package com.stylefeng.guns.rest.model;

import java.io.Serializable;

public class SeachConditionVo implements Serializable {

    private int status;

    SeachDataVo data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public SeachDataVo getData() {
        return data;
    }

    public void setData(SeachDataVo data) {
        this.data = data;
    }
}
