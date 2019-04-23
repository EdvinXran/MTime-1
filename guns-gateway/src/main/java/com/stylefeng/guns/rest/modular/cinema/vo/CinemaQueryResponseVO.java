package com.stylefeng.guns.rest.modular.cinema.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by Gavin
 * on 2019/4/23 17:29
 */
@Data
public class CinemaQueryResponseVO implements Serializable {
    int status;
    int nowPage;
    int totalPage;
    HashMap<String,Object> data;
}
