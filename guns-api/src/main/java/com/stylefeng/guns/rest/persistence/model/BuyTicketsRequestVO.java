package com.stylefeng.guns.rest.persistence.model;

import lombok.Data;

/**
 * Created by Gavin
 * on 2019/4/26 15:00
 */
@Data
public class BuyTicketsRequestVO {
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
