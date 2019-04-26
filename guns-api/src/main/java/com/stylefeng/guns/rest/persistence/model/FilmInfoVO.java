package com.stylefeng.guns.rest.persistence.model;

import java.io.Serializable;

/**
 * Created by Gavin
 * on 2019/4/23 11:04
 */

public class FilmInfoVO implements Serializable {
int uuid;
int filmId;
String filmName;
int filmLength;
String filmCats;
String filmLanguage;
String actors;
String imgAddress;

    public FilmInfoVO() {
    }

    public int getUuid() {
        return uuid;
    }

    public void setUuid(int uuid) {
        this.uuid = uuid;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public int getFilmLength() {
        return filmLength;
    }

    public void setFilmLength(int filmLength) {
        this.filmLength = filmLength;
    }

    public String getFilmCats() {
        return filmCats;
    }

    public void setFilmCats(String filmCats) {
        this.filmCats = filmCats;
    }

    public String getFilmLanguage() {
        return filmLanguage;
    }

    public void setFilmLanguage(String filmLanguage) {
        this.filmLanguage = filmLanguage;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getImgAddress() {
        return imgAddress;
    }

    public void setImgAddress(String imgAddress) {
        this.imgAddress = imgAddress;
    }

    @Override
    public String toString() {
        return "FilmInfoVO{" +
                "uuid=" + uuid +
                ", filmId=" + filmId +
                ", filmName='" + filmName + '\'' +
                ", filmLength=" + filmLength +
                ", filmCats='" + filmCats + '\'' +
                ", filmLanguage='" + filmLanguage + '\'' +
                ", actors='" + actors + '\'' +
                ", imgAddress='" + imgAddress + '\'' +
                '}';
    }
}
