package com.stylefeng.guns.rest.persistence.model;


import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 影片主表
 * </p>
 *
 * @author liang
 * @since 2019-04-21
 */
public class MtimeFilm implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键编号
     */
    private Integer filmId;
    /**
     * 影片名称
     */
    private String filmName;
    /**
     * 片源类型: 0-2D,1-3D,2-3DIMAX,4-无
     */
    private Integer filmType;
    /**
     * 影片主图地址
     */
    private String imgAddress;
    /**
     * 影片评分
     */
    private String filmScore;

    private String score;
    /**
     * 影片预售数量
     */
    private Integer expectNum;
    /**
     * 影片票房：每日更新，以万为单位
     */
    private Integer boxNum;
    /**
     * 影片片源，参照片源字典表
     */
    //private Integer filmSource;
    /**
     * 影片分类，参照分类表,多个分类以#分割
     */
    //private String filmCats;
    /**
     * 影片区域，参照区域表
     */
    //private Integer filmArea;
    /**
     * 影片上映年代，参照年代表
     */
    //private Integer filmDate;
    /**
     * 影片上映时间
     */
    private Date showTime;

    public Date getShowTime() {
        return showTime;
    }

    public void setShowTime(Date showTime) {
        this.showTime = showTime;
    }

    /**
     * 影片状态,1-正在热映，2-即将上映，3-经典影片
     */
    //private Integer filmStatus;



    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public Integer getFilmType() {
        return filmType;
    }

    public void setFilmType(Integer filmType) {
        this.filmType = filmType;
    }

    public String getImgAddress() {
        return imgAddress;
    }

    public void setImgAddress(String imgAddress) {
        this.imgAddress = imgAddress;
    }

    public String getFilmScore() {
        return filmScore;
    }

    public void setFilmScore(String filmScore) {
        this.filmScore = filmScore;
    }

    public Integer getBoxNum() {
        return boxNum;
    }

    public void setBoxNum(Integer boxNum) {
        this.boxNum = boxNum;
    }

    public Integer getExpectNum() {
        return expectNum;
    }

    public void setExpectNum(Integer expectNum) {
        this.expectNum = expectNum;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
