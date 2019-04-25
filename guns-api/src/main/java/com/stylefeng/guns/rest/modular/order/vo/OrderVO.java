package com.stylefeng.guns.rest.modular.order.vo;

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
}
