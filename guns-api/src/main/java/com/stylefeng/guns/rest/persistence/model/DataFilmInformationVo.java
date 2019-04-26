package com.stylefeng.guns.rest.persistence.model;

import java.io.Serializable;

public class DataFilmInformationVo implements Serializable {

    private String filmName;

    private String filmEnName;

    private String imgAddress;

    private String score;

    private String scoreNum;

    private String totalBox;

    private String info01;

    private String info02;

    private String info03;

    private DataFilmInformationImgsVo imgVO;

    private int filmId;


    public DataFilmInformationImgsVo getImgs() {
        return imgVO;
    }

    public void setImgs(DataFilmInformationImgsVo imgVO) {
        this.imgVO = imgVO;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    InfoDataFilmInformationVo info04;

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getFilmEnName() {
        return filmEnName;
    }

    public void setFilmEnName(String filmEnName) {
        this.filmEnName = filmEnName;
    }

    public String getImgAddress() {
        return imgAddress;
    }

    public void setImgAddress(String imgAddress) {
        this.imgAddress = imgAddress;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getScoreNum() {
        return scoreNum;
    }

    public void setScoreNum(String scoreNum) {
        this.scoreNum = scoreNum;
    }

    public String getTotalBox() {
        return totalBox;
    }

    public void setTotalBox(String totalBox) {
        this.totalBox = totalBox;
    }

    public String getInfo01() {
        return info01;
    }

    public void setInfo01(String info01) {
        this.info01 = info01;
    }

    public String getInfo02() {
        return info02;
    }

    public void setInfo02(String info02) {
        this.info02 = info02;
    }

    public String getInfo03() {
        return info03;
    }

    public void setInfo03(String info03) {
        this.info03 = info03;
    }

    public InfoDataFilmInformationVo getInfo04() {
        return info04;
    }

    public void setInfo04(InfoDataFilmInformationVo info04) {
        this.info04 = info04;
    }
}
