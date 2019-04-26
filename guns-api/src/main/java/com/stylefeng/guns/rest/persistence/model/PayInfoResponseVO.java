package com.stylefeng.guns.rest.persistence.model;

import lombok.Data;

import java.util.HashMap;

/**
 * Created by Gavin
 * on 2019/4/26 15:45
 */
@Data
public class PayInfoResponseVO {
    int status;
    String imgPre;
    HashMap<String,Object> data;
}
