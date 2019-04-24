package com.stylefeng.guns.rest.model;

import java.io.Serializable;

public class FilmHomeVo implements Serializable {

    private int status;

    private String imgPre;

    DataVo data;

    public FilmHomeVo() {
    }

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

    public DataVo getData() {
        return data;
    }

    public void setData(DataVo data) {
        this.data = data;
    }
}
