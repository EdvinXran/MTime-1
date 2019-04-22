package com.stylefeng.guns.rest.service;

import com.stylefeng.guns.rest.persistence.model.CinemaQueryVO;

/**
 * Created by Gavin
 * on 2019/4/22 17:39
 */
public interface CinemaService {
    CinemaQueryVO queryCinemasByConditions(String brandId, String hallType, String districtId);
}