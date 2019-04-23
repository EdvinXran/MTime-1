package com.stylefeng.guns.rest.modular.cinema.vo;

import java.io.Serializable;

/**
 * Created by Gavin
 * on 2019/4/21 21:42
 */
public class CinemaQueryVO implements Serializable {
   int brandId;
   int hallType;
   int districtId;
   int pageSize;
   int nowPage;

    public CinemaQueryVO() {
    }

    public CinemaQueryVO(int brandId, int hallType, int districtId, int pageSize, int nowPage) {
        this.brandId = brandId;
        this.hallType = hallType;
        this.districtId = districtId;
        this.pageSize = pageSize;
        this.nowPage = nowPage;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public int getHallType() {
        return hallType;
    }

    public void setHallType(int hallType) {
        this.hallType = hallType;
    }

    public int getDistrictId() {
        return districtId;
    }

    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getNowPage() {
        return nowPage;
    }

    public void setNowPage(int nowPage) {
        this.nowPage = nowPage;
    }

    @Override
    public String toString() {
        return "CinemaQueryVO{" +
                "brandId=" + brandId +
                ", hallType=" + hallType +
                ", districtId=" + districtId +
                ", pageSize=" + pageSize +
                ", nowPage=" + nowPage +
                '}';
    }
}
