package com.stylefeng.guns.rest.modular.vo;

/**
 * Created by Gavin
 * on 2019/4/22 21:01
 */
public class CinemaRequestVO {
    String brandId;
    String hallType;
    String districtId;

    public CinemaRequestVO() {
    }

    public CinemaRequestVO(String brandId, String hallType, String districtId) {
        this.brandId = brandId;
        this.hallType = hallType;
        this.districtId = districtId;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getHallType() {
        return hallType;
    }

    public void setHallType(String hallType) {
        this.hallType = hallType;
    }

    public String getDistrictId() {
        return districtId;
    }

    public void setDistrictId(String districtId) {
        this.districtId = districtId;
    }
}
