package com.stylefeng.guns.rest.persistence.model;

import java.io.Serializable;
import java.util.List;

public class FilmsVo implements Serializable {

    private int status;

    private String imgPre;

    private int nowPage;

    private int totalPage;

    List<FilmVo> data;

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

    public int getNowPage() {
        return nowPage;
    }

    public void setNowPage(int nowPage) {
        this.nowPage = nowPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<FilmVo> getData() {
        return data;
    }

    public void setData(List<FilmVo> data) {
        this.data = data;
    }
}
