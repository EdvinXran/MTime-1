package com.stylefeng.guns.rest.persistence.model;

import java.io.Serializable;

public class Director implements Serializable {

    private String imgAddress;

    private String directorName;

    public String getImgAddress() {
        return imgAddress;
    }

    public void setImgAddress(String imgAddress) {
        this.imgAddress = imgAddress;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }
}
