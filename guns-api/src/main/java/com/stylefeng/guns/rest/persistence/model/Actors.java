package com.stylefeng.guns.rest.persistence.model;

import lombok.Data;

import java.io.Serializable;

public class Actors implements Serializable {

    private String imgAddress;

    private String directorName;

    private String roleName;

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

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }


}
