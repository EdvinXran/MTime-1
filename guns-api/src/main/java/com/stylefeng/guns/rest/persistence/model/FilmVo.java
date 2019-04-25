package com.stylefeng.guns.rest.persistence.model;

import java.io.Serializable;

public class FilmVo implements Serializable {

    private int filmId;

    private String filmType;

    private String imgAddress;

    private String filmName;

    private String filmScore;

    /**
     * 影片分类，参照分类表,多个分类以#分割
     */
    private String filmCats;
    /**
     * 影片区域，参照区域表
     */
    private Integer filmArea;
    /**
     * 影片上映年代，参照年代表
     */
    private Integer filmDate;

    public String getFilmCats() {
        return filmCats;
    }

    public void setFilmCats(String filmCats) {
        this.filmCats = filmCats;
    }

    public Integer getFilmArea() {
        return filmArea;
    }

    public void setFilmArea(Integer filmArea) {
        this.filmArea = filmArea;
    }

    public Integer getFilmDate() {
        return filmDate;
    }

    public void setFilmDate(Integer filmDate) {
        this.filmDate = filmDate;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public String getFilmType() {
        return filmType;
    }

    public void setFilmType(String filmType) {
        this.filmType = filmType;
    }

    public String getImgAddress() {
        return imgAddress;
    }

    public void setImgAddress(String imgAddress) {
        this.imgAddress = imgAddress;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getFilmScore() {
        return filmScore;
    }

    public void setFilmScore(String filmScore) {
        this.filmScore = filmScore;
    }
}
