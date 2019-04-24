package com.stylefeng.guns.rest.model;


import java.io.Serializable;

/**
 * <p>
 * 影片与演员映射表
 * </p>
 *
 * @author liang
 * @since 2019-04-21
 */

public class MtimeFilmActor implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键编号
     */
    private Integer uuid;
    /**
     * 影片编号,对应mtime_film_t
     */
    private Integer filmId;
    /**
     * 演员编号,对应mtime_actor_t
     */
    private Integer actorId;
    /**
     * 角色名称
     */
    private String roleName;


    public Integer getUuid() {
        return uuid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public Integer getActorId() {
        return actorId;
    }

    public void setActorId(Integer actorId) {
        this.actorId = actorId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "MtimeFilmActor{" +
        "uuid=" + uuid +
        ", filmId=" + filmId +
        ", actorId=" + actorId +
        ", roleName=" + roleName +
        "}";
    }
}
