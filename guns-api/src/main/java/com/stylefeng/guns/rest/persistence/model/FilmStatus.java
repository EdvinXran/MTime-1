package com.stylefeng.guns.rest.persistence.model;

import java.io.Serializable;

public class FilmStatus implements Serializable {

    private int status;

    private String msg;

    public FilmStatus() {
    }

    public FilmStatus(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
