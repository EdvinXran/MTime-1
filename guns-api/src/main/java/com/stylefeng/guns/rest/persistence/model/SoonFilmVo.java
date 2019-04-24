package com.stylefeng.guns.rest.persistence.model;

import java.io.Serializable;
import java.util.List;

public class SoonFilmVo implements Serializable {

    private int filmNum;

    List<MtimeFilm> filmInfo;

    public SoonFilmVo() {
    }

    public int getFilmNum() {
        return filmNum;
    }

    public void setFilmNum(int filmNum) {
        this.filmNum = filmNum;
    }

    public List<MtimeFilm> getFilmInfo() {
        return filmInfo;
    }

    public void setFilmInfo(List<MtimeFilm> filmInfo) {
        this.filmInfo = filmInfo;
    }
}
