package com.stylefeng.guns.rest.persistence.model;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by Gavin
 * on 2019/4/21 21:42
 */
//java.lang.IllegalStateException: Serialized class com.stylefeng.guns.rest.persistence.model.CinemaQueryVO must implement java.io.Serializable
public class CinemaQueryVO implements Serializable {
    int status;
    int nowPage;
    int totalPage;
    String msg;
    HashMap<String,Object> data;
    public CinemaQueryVO() {
    }

    public CinemaQueryVO(int status, int nowPage, int totalPage, String msg, HashMap<String, Object> data) {
        this.status = status;
        this.nowPage = nowPage;
        this.totalPage = totalPage;
        this.msg = msg;
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
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
