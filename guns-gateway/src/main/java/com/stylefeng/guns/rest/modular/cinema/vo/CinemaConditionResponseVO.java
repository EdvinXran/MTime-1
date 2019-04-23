package com.stylefeng.guns.rest.modular.cinema.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Gavin
 * on 2019/4/23 17:09
 */
@Data
public class CinemaConditionResponseVO implements Serializable {
    int status;
    HashMap<String, Object> data;

}
