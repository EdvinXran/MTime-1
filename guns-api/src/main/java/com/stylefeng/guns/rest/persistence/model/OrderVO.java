package com.stylefeng.guns.rest.persistence.model;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Gavin
 * on 2019/4/25 10:24
 */
@Data
public class OrderVO implements Serializable {
    private String orderId;
    private String filmName;
    private String fieldTime;
    private String cinemaName;
    private String seatsName;
    private String orderPrice;
    private String orderTimestamp;
    private String orderStatus;

    public OrderVO() {
    }

    public OrderVO(String orderId, String filmName, String fieldTime, String cinemaName, String seatsName, String orderPrice, String orderTimestamp, String orderStatus) {
        this.orderId = orderId;
        this.filmName = filmName;
        this.fieldTime = fieldTime;
        this.cinemaName = cinemaName;
        this.seatsName = seatsName;
        this.orderPrice = orderPrice;
        this.orderTimestamp = orderTimestamp;
        this.orderStatus = orderStatus;
    }
}
