package com.stylefeng.guns.rest.persistence.model;

import java.io.Serializable;

public class FilmInformationVo implements Serializable {

    private int status;

    private String imgPre;

    DataFilmInformationVo data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getImgPre() {
        return imgPre;
    }

    public void setImgPre(String imgPre) {
        this.imgPre = imgPre;
    }

    public DataFilmInformationVo getData() {
        return data;
    }

    public void setData(DataFilmInformationVo data) {
        this.data = data;
    }
}
