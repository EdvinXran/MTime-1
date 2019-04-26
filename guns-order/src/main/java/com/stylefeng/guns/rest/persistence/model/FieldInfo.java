package com.stylefeng.guns.rest.persistence.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class FieldInfo implements Serializable {
    private Integer uuid;
    private int cinemaId;
    private int filmId;
    private Date beginTime;
    private Date endTime;
    private int hallId;
    private String hallName;
    private int price;
}
