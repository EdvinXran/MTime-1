package com.stylefeng.guns.rest.modular.order.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Gavin
 * on 2019/4/25 16:45
 */
@Data
public class BuyTicketsRequestVO implements Serializable {
    int fieldId;
    String soldSeats;
    String seatsName;

    public BuyTicketsRequestVO() {
    }

    public BuyTicketsRequestVO(int fieldId, String soldSeats, String seatsName) {
        this.fieldId = fieldId;
        this.soldSeats = soldSeats;
        this.seatsName = seatsName;
    }
}
