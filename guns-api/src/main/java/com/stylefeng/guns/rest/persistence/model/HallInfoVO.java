package com.stylefeng.guns.rest.persistence.model;

import java.io.Serializable;

/**
 * Created by Gavin
 * on 2019/4/23 11:05
 */
public class HallInfoVO implements Serializable {
     String hallFieldId;
     String hallName;
     String price;
     String seatFile;
    // 已售座位必须关联订单才能查询
     String soldSeats;

    public String getHallFieldId() {
        return hallFieldId;
    }

    public void setHallFieldId(String hallFieldId) {
        this.hallFieldId = hallFieldId;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSeatFile() {
        return seatFile;
    }

    public void setSeatFile(String seatFile) {
        this.seatFile = seatFile;
    }

    public String getSoldSeats() {
        return soldSeats;
    }

    public void setSoldSeats(String soldSeats) {
        this.soldSeats = soldSeats;
    }

    public HallInfoVO() {
    }

    @Override
    public String toString() {
        return "HallInfoVO{" +
                "hallFieldId='" + hallFieldId + '\'' +
                ", hallName='" + hallName + '\'' +
                ", price='" + price + '\'' +
                ", seatFile='" + seatFile + '\'' +
                ", soldSeats='" + soldSeats + '\'' +
                '}';
    }
}
