package com.stylefeng.guns.rest.persistence.model;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Gavin
 * on 2019/4/23 11:29
 */
@Data
public class CinemaInfoVO implements Serializable {
       String cinemaAddress;
        String imgUrl;
        String cinemaPhone;
      String cinemaName;
      String   cinemaId;
}
