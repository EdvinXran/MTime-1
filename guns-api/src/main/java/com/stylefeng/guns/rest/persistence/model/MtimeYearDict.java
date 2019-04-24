package com.stylefeng.guns.rest.persistence.model;

import java.io.Serializable;

/**
 * <p>
 * 年代信息表
 * </p>
 *
 * @author liang
 * @since 2019-04-21
 */
public class MtimeYearDict implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键编号
     */
    private Integer uuid;
    /**
     * 显示名称
     */
    private String showName;


    public Integer getUuid() {
        return uuid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    @Override
    public String toString() {
        return "MtimeYearDict{" +
        "uuid=" + uuid +
        ", showName=" + showName +
        "}";
    }
}
