package com.stylefeng.guns.rest.modular.cinema.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Gavin
 * on 2019/4/23 16:31
 */
@Data
public class CinemaConditionVO implements Serializable {
    int brandId;
    int hallType;
    int districtId;

    public CinemaConditionVO() {
    }

    public CinemaConditionVO(int brandId, int hallType, int districtId) {
        this.brandId = brandId;
        this.hallType = hallType;
        this.districtId = districtId;
    }
}
