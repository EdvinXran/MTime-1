package com.stylefeng.guns.rest.persistence.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

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


    public void setCinemaInfo(CinemaInfoVO cinemaInfoById) {

    }

    public void setFilmList(List<FilmInfoVO> filmInfoByCinemaId) {

    }
}
