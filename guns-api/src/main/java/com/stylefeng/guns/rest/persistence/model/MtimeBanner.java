package com.stylefeng.guns.rest.persistence.model;


import java.io.Serializable;

/**
 * <p>
 * banner信息表
 * </p>
 *
 * @author liang
 * @since 2019-04-21
 */
public class MtimeBanner implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键编号
     */
    private Integer bannerId;
    /**
     * banner图存放路径
     */
    private String bannerAddress;
    /**
     * banner点击跳转url
     */
    private String bannerUrl;


    public Integer getBannerId() {
        return bannerId;
    }

    public void setBannerId(Integer bannerId) {
        this.bannerId = bannerId;
    }

    public String getBannerAddress() {
        return bannerAddress;
    }

    public void setBannerAddress(String bannerAddress) {
        this.bannerAddress = bannerAddress;
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }

}
