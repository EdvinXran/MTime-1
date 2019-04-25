package com.stylefeng.guns.rest.modular.cinema.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Gavin
 * on 2019/4/23 11:04
 */
@Data
public class BrandVO implements Serializable {
    int brandId;
    String brandName;
    boolean isActive;

    public BrandVO() {
    }

    public BrandVO(int brandId, String brandName, boolean isActive) {
        this.brandId = brandId;
        this.brandName = brandName;
        this.isActive = isActive;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean active) {
        isActive = active;
    }
}
