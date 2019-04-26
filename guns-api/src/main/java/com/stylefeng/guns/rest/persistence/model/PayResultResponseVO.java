package com.stylefeng.guns.rest.persistence.model;

import lombok.Data;

import java.util.HashMap;

/**
 * Created by Gavin
 * on 2019/4/26 15:47
 */
@Data
public class PayResultResponseVO {
    int status;
    HashMap<String,Object> data;

}
