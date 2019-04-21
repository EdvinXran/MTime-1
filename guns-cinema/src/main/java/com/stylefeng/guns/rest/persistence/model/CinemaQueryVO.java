package com.stylefeng.guns.rest.persistence.model;

import java.util.HashMap;

/**
 * Created by Gavin
 * on 2019/4/21 21:42
 */
public class CinemaQueryVO {
    int status;
    int nowPage;
    int totalPage;
    HashMap<String,Object> data;

    public CinemaQueryVO(int status, int nowPage, int totalPage, HashMap<String, Object> data) {
        this.status = status;
        this.nowPage = nowPage;
        this.totalPage = totalPage;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public HashMap<String, Object> getData() {
        return data;
    }

    public void setData(HashMap<String, Object> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CinemaQueryVO{" +
                "status=" + status +
                ", nowPage=" + nowPage +
                ", totalPage=" + totalPage +
                ", data=" + data +
                '}';
    }
}