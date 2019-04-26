package com.stylefeng.guns.rest.persistence.model;

import lombok.Data;

import java.util.HashMap;

/**
 * Created by Gavin
 * on 2019/4/26 15:08
 */
@Data
public class OrderResponseVO {
    int status;
    String msg;
    HashMap<String,Object> data;

    public OrderResponseVO(int status, String msg, HashMap<String, Object> data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public OrderResponseVO() {
    }
}
