package com.stylefeng.guns.rest.persistence.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class OrderInsertVo implements Serializable {

    private String orderId;
    private int cinemaId;
    private int fieldId;
    private int filmId;
    private String seatsIds;
    private String seatsName;
    private int filmPrice;
    private int orderPrice;
    private Date orderTime;
    private int orderUserId;
    private int orderStatus;
}
