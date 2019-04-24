package com.stylefeng.guns.rest.persistence.model;


import java.io.Serializable;

/**
 * <p>
 * 演员表
 * </p>
 *
 * @author liang
 * @since 2019-04-21
 */
public class MtimeActor implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键编号
     */
    private Integer uuid;
    /**
     * 演员名称
     */
    private String actorName;
    /**
     * 演员图片位置
     */
    private String actorImg;


    public Integer getUuid() {
        return uuid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public String getActorImg() {
        return actorImg;
    }

    public void setActorImg(String actorImg) {
        this.actorImg = actorImg;
    }


    @Override
    public String toString() {
        return "MtimeActor{" +
        "uuid=" + uuid +
        ", actorName=" + actorName +
        ", actorImg=" + actorImg +
        "}";
    }
}
